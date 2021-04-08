package com.revenue.revenueCollection.WebService;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;

import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.engine.export.JExcelApiExporterParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path="/api/erevenue/")
public class ReportsService extends HttpServlet {
    @Autowired
    private Environment env;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        try {

            System.out.println("here 1,,,,,,,,,,,,,,,,,,");
            String keyValue = env.getProperty("rportpath");
            System.out.println(keyValue+"here 1,,,,,,,,,,,,,,,,,,");
            String Type = request.getParameter("type");
            String exportType = request.getParameter("eType");
            Connection connection = null;
            JasperReport jasperReport = null;
            JasperPrint jasperPrint = null;
            JasperDesign jasperDesign = null;
            Map<String, String> parameters = new HashMap();
            ServletOutputStream outstream;
            InitialContext initialContext = new InitialContext();
            //Context context = (Context) initialContext.lookup("java:/comp/env");java:jboss/datasources/ExampleDS
            //Context context = new nitialContext();
            DataSource ds = (DataSource) initialContext.lookup("java:jboss/datasources/ExampleDS");
            connection = ds.getConnection();
            if (Type.equalsIgnoreCase("I")) {
                String business=request.getParameter("businnessNo");
                String paid=request.getParameter("paidUser");
                String applied=request.getParameter("appliedFor");
                System.out.println(business +"business");
                System.out.println(paid +"paid");
                System.out.println(applied +"jasperPrint.getPages().size()");
                parameters.put("businessNo", business);
                parameters.put("paidUser", paid);
                parameters.put("appliedFor", applied);


                jasperDesign = JRXmlLoader
                        .load(keyValue+"RptInvoice.jrxml");
                jasperReport = JasperCompileManager.compileReport(jasperDesign);
                jasperPrint = JasperFillManager.fillReport(jasperReport,
                        parameters, connection);

                System.out.println(connection +"jasperPrint.getPages().size()");
                System.out.println(jasperPrint.getPages().size() +"jasperPrint.getPages().size()");
                System.out.println(jasperPrint.getRightMargin() +"jasperPrint.getPages().size()");

                /* if (jasperPrint.getPages().size() == 0) {*/
                byte[] pdfasbytes = JasperExportManager
                        .exportReportToPdf(jasperPrint);
                outstream = response.getOutputStream();
                response.setContentType("application/pdf");
                response.setContentLength(pdfasbytes.length);
                outstream.write(pdfasbytes, 0, pdfasbytes.length);
                 JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());

                // }
            /*        else {
                        System.out.println("No data");

                }*/

            } else {
                System.out.println("calling servlet## Summary Excel");
                jasperDesign = JRXmlLoader.load(keyValue
                        + "RptEnrolledCustomers_xlsx.jrxml");
                jasperReport = JasperCompileManager
                        .compileReport(jasperDesign);
                jasperPrint = JasperFillManager.fillReport(jasperReport,
                        parameters, connection);

                if (jasperPrint.getPages().size() != 0) {
                    JRXlsxExporter exporter = getCommonXlsxExporter();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    exporter.setParameter(
                            JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN,
                            Boolean.TRUE);
                    exporter.setParameter(
                            JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,
                            Boolean.TRUE);
                    exporter.setParameter(
                            JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
                            Boolean.TRUE);
                    exporter.setParameter(
                            JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
                            Boolean.FALSE);
                    exporter.setParameter(
                            JRXlsExporterParameter.IS_DETECT_CELL_TYPE,
                            Boolean.TRUE);
                    exporter.setParameter(
                            JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,
                            Boolean.FALSE);
                    exporter.setParameter(
                            JRXlsExporterParameter.IS_IGNORE_GRAPHICS,
                            Boolean.TRUE);
                    exporter.setParameter(
                            JRXlsExporterParameter.JASPER_PRINT,
                            jasperPrint);
                    exporter.setParameter(
                            JRXlsExporterParameter.OUTPUT_STREAM, baos);
                    exporter.exportReport();

                    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                    response.setHeader("Content-disposition",
                            "attachment; filename=" + "ENROLLED CUSTOMERS"
                                    + ".xlsx");
                    response.setContentLength(baos.size());
                    response.getOutputStream().write(baos.toByteArray());

                } else {
                    System.out.println("No data");
                }
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping(path= "/reports")
    public void getReports(
            @RequestParam(value="type")
                    String reportType,

            @RequestParam("businnessNo")
            String businnessNo,
            @RequestParam(value="approvedUser")
                    String approvedUser,
            @RequestParam(value="appliedFor")
                    String appliedFor,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String Type = request.getParameter("type");
        String exportType = request.getParameter("eType");
        try {

            System.out.println("here 1,,,,,,,,,,,,,,,,,,");
            String keyValue = env.getProperty("rportpath");
            System.out.println(keyValue+"here 1,,,,,,,,,,,,,,,,,,");
            Connection connection = null;
            JasperReport jasperReport = null;
            JasperPrint jasperPrint = null;
            JasperDesign jasperDesign = null;
            Map<String, String> parameters = new HashMap();
            ServletOutputStream outstream = null;
            InitialContext initialContext = new InitialContext();
            //Context context = (Context) initialContext.lookup("java:/comp/env");java:jboss/datasources/ExampleDS
            //Context context = new nitialContext();
            DataSource ds = (DataSource) initialContext.lookup("java:jboss/datasources/ExampleDS");
            connection = ds.getConnection();
            if (reportType.equalsIgnoreCase("I")) {
                businnessNo=request.getParameter("businnessNo");
                approvedUser=request.getParameter("approvedUser");
                appliedFor=request.getParameter("appliedFor");
                System.out.println(businnessNo +"business");
                System.out.println(approvedUser +"paid");
                System.out.println(appliedFor +"jasperPrint.getPages().size()");
                System.out.println(reportType +"jasperPrint.getPages().size()");
                parameters.put("businnessNo", businnessNo);
                parameters.put("approvedUser", approvedUser);
                parameters.put("appliedFor", appliedFor);
                System.out.println(parameters +"jasperPrint.parameters().size()");
                System.out.println(connection +"jasperPrint.parameters().size()");



                jasperDesign = JRXmlLoader
                        .load(keyValue+"RptInvoice.jrxml");
                jasperReport = JasperCompileManager.compileReport(jasperDesign);
                System.out.println(jasperDesign +"jasperPrint.parameters().size()");
                System.out.println(jasperReport +"jasperPrint.parameters().size()");

                jasperPrint = JasperFillManager.fillReport(jasperReport,
                        parameters, connection);

                System.out.println(connection +"jasperPrint.getPages().size()");
                    System.out.println(jasperPrint.getPages().size() +"jasperPrint.getPages().size()");
                System.out.println(jasperPrint.getRightMargin() +"jasperPrint.getPages().size()");

                   if (jasperPrint.getPages().size() != 0) {
                        byte[] pdfasbytes = JasperExportManager
                                .exportReportToPdf(jasperPrint);
                        outstream = response.getOutputStream();
                        response.setContentType("application/pdf");
                        response.setContentLength(pdfasbytes.length);
                        outstream.write(pdfasbytes, 0, pdfasbytes.length);
                //JasperExportManager.exportReportToPdfStream(jasperPrint, outstream);

                   }
                    else {
                        System.out.println("No data");

                }

                }
            if (reportType.equalsIgnoreCase("R")) {
                String businessNo = request.getParameter("businnessNo");
                String paidUser = request.getParameter("approvedUser");
                String year = request.getParameter("appliedFor");
                parameters.put("businnessNo", businessNo);
                parameters.put("approvedUser", paidUser);
                parameters.put("appliedFor", year);

                System.out.println("-------------------"+businessNo);
                System.out.println("-------------------"+paidUser);
                System.out.println("-------------------"+year);
                System.out.println("calling servlet## Invoice Receipt Pdf");
                jasperDesign = JRXmlLoader
                        .load(keyValue+"RptInvoiceReceipt.jrxml");


                jasperReport = JasperCompileManager.compileReport(jasperDesign);
                jasperPrint = JasperFillManager.fillReport(jasperReport,
                        parameters, connection);



                if (jasperPrint.getPages().size() != 0) {

                    byte[] pdfasbytes = JasperExportManager
                            .exportReportToPdf(jasperPrint);
                    outstream = response.getOutputStream();
                    response.setContentType("application/pdf");
                    response.setContentLength(pdfasbytes.length);
                    outstream.write(pdfasbytes, 0, pdfasbytes.length);

                } else {
                    System.out.println("No data");
                }



            }
            if (reportType.equalsIgnoreCase("LRInv")) {
                String plotNumber = request.getParameter("plotNumber");
                String approved = request.getParameter("approvedUser");
                String year = request.getParameter("year");
                parameters.put("plotNumber", plotNumber);
                parameters.put("approvedUser", approved);
                parameters.put("year", year);

                System.out.println("calling servlet## LandInvoice Pdf");
                jasperDesign = JRXmlLoader
                        .load(keyValue+"RptLandRateInvoice.jrxml");
                jasperReport = JasperCompileManager.compileReport(jasperDesign);
                jasperPrint = JasperFillManager.fillReport(jasperReport,
                        parameters, connection);

                if (jasperPrint.getPages().size() != 0) {
                    byte[] pdfasbytes = JasperExportManager
                            .exportReportToPdf(jasperPrint);
                    outstream = response.getOutputStream();
                    response.setContentType("application/pdf");
                    response.setContentLength(pdfasbytes.length);
                    outstream.write(pdfasbytes, 0, pdfasbytes.length);

                } else {
                    System.out.println("No data");
                }

            }

            if (reportType.equalsIgnoreCase("LRRec")) {
                String plotNumber = request.getParameter("plotNumber");
                String paidUser = request.getParameter("paidUser");
                String year = request.getParameter("year");
                parameters.put("plotNumber", plotNumber);
                parameters.put("paidUser", paidUser);
                parameters.put("year", year);

                System.out.println("calling servlet##Land Invoice Receipt Pdf");
                jasperDesign = JRXmlLoader
                        .load(keyValue+"RptLandReceipt.jrxml");

                jasperReport = JasperCompileManager
                        .compileReport(jasperDesign);
                jasperPrint = JasperFillManager.fillReport(jasperReport,
                        parameters, connection);

                if (jasperPrint.getPages().size() != 0) {

                    if (jasperPrint.getPages().size() != 0) {

                        byte[] pdfasbytes = JasperExportManager
                                .exportReportToPdf(jasperPrint);
                        outstream = response.getOutputStream();
                        response.setContentType("application/pdf");
                        response.setContentLength(pdfasbytes.length);
                        outstream.write(pdfasbytes, 0, pdfasbytes.length);

                    } else {
                        System.out.println("No data");
                    }

                }

            }
            if (reportType.equalsIgnoreCase("P")) {

                String permitNo = request.getParameter("permitNo");
                // String fee = request.getParameter("fee");
                parameters.put("permitNo", permitNo);

                jasperDesign = JRXmlLoader
                        .load(keyValue+"RptPermit.jrxml");
                jasperReport = JasperCompileManager.compileReport(jasperDesign);
                jasperPrint = JasperFillManager.fillReport(jasperReport,
                        parameters, connection);

                if (jasperPrint.getPages().size() != 0) {
                    byte[] pdfasbytes = JasperExportManager
                            .exportReportToPdf(jasperPrint);
                    outstream = response.getOutputStream();
                    response.setContentType("application/pdf");
                    response.setContentLength(pdfasbytes.length);
                    outstream.write(pdfasbytes, 0, pdfasbytes.length);
              /*      ErevenueResponse response2 = UpdatePermitStatus(permitNo,
                            "PR");
                    if (response2.respCode == 200) {
                        Response.status(200).entity(response2).build();
                        return;
                    } else {
                        Response.status(201).entity(response2).build();
                        return;
                    }*/

                } else {
                    System.out.println("No data");
                }

            }

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    @GetMapping(path= "/permit")
    public void getLandReports(
            @RequestParam(value="type")
                    String reportType,

            @RequestParam("permitNo")
                    String permitNo,

            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String Type = request.getParameter("type");
        String exportType = request.getParameter("eType");
        try {

            System.out.println("here 1,,,,,,,,,,,,,,,,,,");
            String keyValue = env.getProperty("rportpath");
            System.out.println(keyValue+"here 1,,,,,,,,,,,,,,,,,,");
            Connection connection = null;
            JasperReport jasperReport = null;
            JasperPrint jasperPrint = null;
            JasperDesign jasperDesign = null;
            Map<String, String> parameters = new HashMap();
            ServletOutputStream outstream = null;
            InitialContext initialContext = new InitialContext();
            //Context context = (Context) initialContext.lookup("java:/comp/env");java:jboss/datasources/ExampleDS
            //Context context = new nitialContext();
            DataSource ds = (DataSource) initialContext.lookup("java:jboss/datasources/ExampleDS");
            connection = ds.getConnection();



            if (reportType.equalsIgnoreCase("P")) {

                 permitNo = request.getParameter("permitNo");
                // String fee = request.getParameter("fee");
                parameters.put("permitNo", permitNo);

                jasperDesign = JRXmlLoader
                        .load(keyValue+"RptPermit.jrxml");
                jasperReport = JasperCompileManager.compileReport(jasperDesign);
                jasperPrint = JasperFillManager.fillReport(jasperReport,
                        parameters, connection);

                if (jasperPrint.getPages().size() != 0) {
                    byte[] pdfasbytes = JasperExportManager
                            .exportReportToPdf(jasperPrint);
                    outstream = response.getOutputStream();
                    response.setContentType("application/pdf");
                    response.setContentLength(pdfasbytes.length);
                    outstream.write(pdfasbytes, 0, pdfasbytes.length);
              /*      ErevenueResponse response2 = UpdatePermitStatus(permitNo,
                            "PR");
                    if (response2.respCode == 200) {
                        Response.status(200).entity(response2).build();
                        return;
                    } else {
                        Response.status(201).entity(response2).build();
                        return;
                    }*/

                } else {
                    System.out.println("No data");
                }

            }

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    @GetMapping(path= "/landreports")
    public void getLandReports(
            @RequestParam(value="type")
                    String reportType,

            @RequestParam("plotNumber")
                    String plotNumber,
            @RequestParam(value="paidUser")
                    String paidUser,
            @RequestParam(value="appliedFor")
                    String appliedFor,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String Type = request.getParameter("type");
        String exportType = request.getParameter("eType");
        try {

            System.out.println("here 1,,,,,,,,,,,,,,,,,,");
            String keyValue = env.getProperty("rportpath");
            System.out.println(keyValue+"here 1,,,,,,,,,,,,,,,,,,");
            Connection connection = null;
            JasperReport jasperReport = null;
            JasperPrint jasperPrint = null;
            JasperDesign jasperDesign = null;
            Map<String, String> parameters = new HashMap();
            ServletOutputStream outstream = null;
            InitialContext initialContext = new InitialContext();
            //Context context = (Context) initialContext.lookup("java:/comp/env");java:jboss/datasources/ExampleDS
            //Context context = new nitialContext();
            DataSource ds = (DataSource) initialContext.lookup("java:jboss/datasources/ExampleDS");
            connection = ds.getConnection();


            if (reportType.equalsIgnoreCase("LRInv")) {
                plotNumber = request.getParameter("plotNumber");
                paidUser = request.getParameter("paidUser");
                appliedFor = request.getParameter("appliedFor");
                parameters.put("plotNumber", plotNumber);
                parameters.put("paidUser", paidUser);
                parameters.put("appliedFor", appliedFor);

                System.out.println("calling servlet## LandInvoice Pdf");
                jasperDesign = JRXmlLoader
                        .load(keyValue+"RptLandRateInvoice.jrxml");
                jasperReport = JasperCompileManager.compileReport(jasperDesign);
                jasperPrint = JasperFillManager.fillReport(jasperReport,
                        parameters, connection);

                if (jasperPrint.getPages().size() != 0) {
                    byte[] pdfasbytes = JasperExportManager
                            .exportReportToPdf(jasperPrint);
                    outstream = response.getOutputStream();
                    response.setContentType("application/pdf");
                    response.setContentLength(pdfasbytes.length);
                    outstream.write(pdfasbytes, 0, pdfasbytes.length);

                } else {
                    System.out.println("No data");
                }

            }

            if (reportType.equalsIgnoreCase("LRRec")) {
               plotNumber = request.getParameter("plotNumber");
                paidUser = request.getParameter("paidUser");
                 appliedFor = request.getParameter("appliedFor");
                parameters.put("plotNumber", plotNumber);
                parameters.put("paidUser", paidUser);
                parameters.put("appliedFor", appliedFor);

                System.out.println("calling servlet##Land Invoice Receipt Pdf");
                jasperDesign = JRXmlLoader
                        .load(keyValue+"RptLandReceipt.jrxml");

                jasperReport = JasperCompileManager
                        .compileReport(jasperDesign);
                jasperPrint = JasperFillManager.fillReport(jasperReport,
                        parameters, connection);

                if (jasperPrint.getPages().size() != 0) {

                    if (jasperPrint.getPages().size() != 0) {

                        byte[] pdfasbytes = JasperExportManager
                                .exportReportToPdf(jasperPrint);
                        outstream = response.getOutputStream();
                        response.setContentType("application/pdf");
                        response.setContentLength(pdfasbytes.length);
                        outstream.write(pdfasbytes, 0, pdfasbytes.length);

                    } else {
                        System.out.println("No data");
                    }

                }

            }
            if (reportType.equalsIgnoreCase("P")) {

                String permitNo = request.getParameter("permitNo");
                // String fee = request.getParameter("fee");
                parameters.put("permitNo", permitNo);

                jasperDesign = JRXmlLoader
                        .load(keyValue+"RptPermit.jrxml");
                jasperReport = JasperCompileManager.compileReport(jasperDesign);
                jasperPrint = JasperFillManager.fillReport(jasperReport,
                        parameters, connection);

                if (jasperPrint.getPages().size() != 0) {
                    byte[] pdfasbytes = JasperExportManager
                            .exportReportToPdf(jasperPrint);
                    outstream = response.getOutputStream();
                    response.setContentType("application/pdf");
                    response.setContentLength(pdfasbytes.length);
                    outstream.write(pdfasbytes, 0, pdfasbytes.length);
              /*      ErevenueResponse response2 = UpdatePermitStatus(permitNo,
                            "PR");
                    if (response2.respCode == 200) {
                        Response.status(200).entity(response2).build();
                        return;
                    } else {
                        Response.status(201).entity(response2).build();
                        return;
                    }*/

                } else {
                    System.out.println("No data");
                }

            }

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("deprecation")
    private JRXlsxExporter getCommonXlsxExporter() {
        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setParameter(JRXlsExporterParameter.IGNORE_PAGE_MARGINS,
                Boolean.TRUE);
        exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
                Boolean.FALSE);
        exporter.setParameter(JRXlsExporterParameter.IS_AUTO_DETECT_CELL_TYPE,
                Boolean.FALSE);
        exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,
                Boolean.FALSE);
        exporter.setParameter(
                JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
                Boolean.TRUE);
        exporter.setParameter(JExcelApiExporterParameter.IS_DETECT_CELL_TYPE,
                Boolean.TRUE);
        exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.TRUE);
        exporter.setParameter(JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN, Boolean.TRUE);
        // exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE,
        // Boolean.TRUE);

        return exporter;
    }
}
