package com.revenue.revenueCollection.Beans;

import com.google.gson.Gson;
import com.revenue.revenueCollection.Dao.AuditTrailDao;
import com.revenue.revenueCollection.Dao.PermitDao;
import com.revenue.revenueCollection.Dao.PermitTypeDao;
import com.revenue.revenueCollection.Dao.UserDao;
import com.revenue.revenueCollection.Interfaces.PermitBal;
import com.revenue.revenueCollection.Models.*;
import com.revenue.revenueCollection.Utility.AES;
import net.glxn.qrgen.QRCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import sun.misc.BASE64Decoder;

import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;

import net.glxn.qrgen.image.ImageType;



import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.Date;
import java.util.List;
@Component
public class PermitBalIml implements PermitBal {
    Gson gson = new Gson();
    @Autowired
    private Environment env;
    @Autowired
    PermitDao permitDao;
    @Autowired
    UserDao userDao;
    @Autowired
    AuditTrailDao auditTrailDao;
    @Autowired
    PermitTypeDao permitTypeDao;
    @Override
    public ResponseMessage registerPermit(Permit permit) {


        Audit_trail auditTrail = new Audit_trail();
        try {


            System.out.println("customer " + permit);
            System.out.println(permit.permitId +"permit Id ***************************");
            System.out.println(permit.getPermitId() +"permit Id ***************************");






                PermitType permitType = permitTypeDao.findById(permit.permitTypeId).orElseThrow(NullPointerException::new);
                System.out.println(permitType.getPermitFee() + "Permittttttttttttt");
                System.out.println(permitType.permitFee + "Permittttttttttttt1111111111");
            permit.permitQr = generateQrImageBase64String(permit.regNo);
                permit.setFee(permitType.getPermitFee());
                permit.setCreatedOn(new Timestamp(new Date().getTime()));
                auditTrail.setAction("Apply  permit");
                auditTrail.setCreatedBy(permit.getCreatedBy());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));
                permit.setApproved("N");
            String amountInWords = Utility.convertNumberToWords((int) permitType.getPermitFee());

            System.out.println("amount in words.........." +amountInWords);
            permit.setAmountInWords(amountInWords);
             System.out.println(permit.mpesaCode +"WEREEEE");
            if (permit.mpesaCode!=null){
                permit.setPaidStatus("paid");
                permit.setPaidDate(new Timestamp(new Date().getTime()));
                permit.setApproved("V");
            }
                String jsonString = gson.toJson(permit);
                //permit.setCreate_json(jsonString);

                permitDao.save(permit);
                auditTrailDao.save(auditTrail);
                 UpdateQrImagePath(permit);
                return new ResponseMessage(200, "Permit Applied Successfully");




        }catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }

    }

    @Override
    public List<Permit> viewPermitDetails() {
        List<Permit> permits= permitDao.findAll();

        for(int i=0; i<permits.size();i++){
            System.out.println(permits.get(i).getApproved()+"&&&&&&&&&&&&&&&&&&");
            if(permits.get(i).getApprovedBy()!=0) {
                Users users = userDao.findById(permits.get(i).getApprovedBy()).orElseThrow(NullPointerException::new);
                permits.get(i).setPaidUser(users.getUserName());
            }
            if(permits.get(i).getApproved().equals("N")){
                permits.get(i).setApproved("Pending Approval");
            }else {
                permits.get(i).setApproved("Approved");
            }


            System.out.println(permits.get(i).getPaidUser() +"bbbbbbbbbbbbbbbbbbbbb");
        }

        return permitDao.findAll();
    }

    @Override
    public ResponseMessage deletePermit(Permit permit) {
        return null;
    }

    public static BufferedImage decodeToImage(String imageString) {

        BufferedImage image = null;
        byte[] imageByte;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

   public ResponseMessage UpdateQrImagePath(Permit app) {
        BufferedImage image = null;
        try {

            String keyValue = env.getProperty("qr.filePathQrCode");
 String path = keyValue+ app.regNo
                    + ".jpg";
            System.out.println("qrpath##" + path);
            //System.out.println(image+" image");
            //System.out.println(app.permitQr+" app.permitQr");
            System.out.println(app.amountInWords+" app.permitQr");
            String base64Image = app.permitQr.split(",")[1];
            image = decodeToImage(base64Image);
            File outputfile = new File(path);
            ImageIO.write(image, "jpg", outputfile);

            int feeValue = (int) Math.round(app.permitFee);
            System.out.println(feeValue);
            String amountInWords = Utility.convertNumberToWords(feeValue);
            Permit permit1 = permitDao.findById(app.permitId).orElseThrow(NullPointerException::new);


            permit1.setQr_image( path);
            permitDao.save(permit1);


            return new ResponseMessage(200, ".........");

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseMessage(202, "Exception Occured");
        }
    }
    @Override
    public ResponseMessage approvePermit(Permit permit) {
        try {
            System.out.println("&&&&&&&&" + permit);
            if (permit.permitId !=0) {
                Permit permit1 = permitDao.findById(permit.permitId).orElseThrow(NullPointerException::new);
                permit1.setApproved(permit.getApproved());
                System.out.println(permit.getApprovedBy() +"stoooop");
                permit1.setApprovedBy(permit.getApprovedBy());
                permit1.setApprovedOn(new Timestamp(new Date().getTime()));

                Audit_trail auditTrail = new Audit_trail();
                if(permit.getApproved().equals('V')) {
                    auditTrail.setAction("Approve Permit");
                }else{
                    auditTrail.setAction("Reject2 Permit");
                }
                auditTrail.setCreatedBy(permit1.getApprovedBy());
                auditTrail.setCreatedOn(new Timestamp(new Date().getTime()));

                auditTrailDao.save(auditTrail);
                permitDao.save(permit1);
                return new ResponseMessage(200,"Permit updated Successfully");

            }
            return new ResponseMessage(201,"permir update Failed");

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(202,"Exception Occurred");

        }
    }

    @Override
    public ResponseMessage approveDeletePermit(Permit permit) {
        return null;
    }

    @Override
    public List<Permit> getPermitToApprove() {
        List<Permit> permits= permitDao.getPermitToApprove();
        for(int i=0; i<permits.size();i++){
            System.out.println(permits.get(i).getApproved()+"&&&&&&&&&&&&&&&&&&");
            if(permits.get(i).getApproved().equals("N")){
                permits.get(i).setApproved("Pending Approval");
            }else {
                permits.get(i).setApproved("Approved");
            }
        }
        return permitDao.getPermitToApprove();
    }

    @Override
    public List<Permit> getPermitToApproveDelete() {
        return null;
    }

    @Override
    public ResponseMessage updatePermit(Permit permit) {
        return null;
    }

    @Override
    public ResponseMessage renewPermit(Permit permit) {
       try{

           if (ValidateRenewBusinessId(permit.permitId)) {
               return new ResponseMessage(201,
                       "Application is already in renewal state");
           }
           Permit permit1 = permitDao.findById(permit.permitId).orElseThrow(NullPointerException::new);
           permit1.setStatus(permit.getStatus());
           permit1.setAppType(permit.getAppType());
           permit1.setValidity(permit.getValidity());
           permit1.setExpiryDate(permit.getExpiryDate());
           permitDao.save(permit1);
           return new ResponseMessage(200,
                   "Permit Renewed Successfully");
       }catch (Exception e){
          e.printStackTrace();
           return new ResponseMessage(404,
                   "Exception Occurred");
       }
    }

    @Override
    public List<Permit> getPermitToRenew() {
        List<Permit> permits= permitDao.findAll();

        for(int i=0; i<permits.size();i++){
            System.out.println(permits.get(i).getApproved()+"&&&&&&&&&&&&&&&&&&");
            if(permits.get(i).getApprovedBy()!=0) {
                Users users = userDao.findById(permits.get(i).getApprovedBy()).orElseThrow(NullPointerException::new);
                permits.get(i).setPaidUser(users.getUserName());
            }
            if(permits.get(i).getApproved().equals("N")){
                permits.get(i).setApproved("Pending Approval");
            }else {
                permits.get(i).setApproved("Approved");
            }


            System.out.println(permits.get(i).getPaidUser() +"bbbbbbbbbbbbbbbbbbbbb");
        }
        return permitDao.findAllToRenew();
    }

    public boolean ValidateRenewBusinessId(int businessId) {

        try {
            List<Permit> permit1 = permitDao.findByRegNo(businessId);





            if (permit1.size()==0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    /**
     * generates qr image based on permit no
     * @param permitNo
     * @return base64 Qr code string
     *
     */
    public String generateQrImageBase64String(String permitNo) {
        String imageString = null;
        String qrText = permitNo;
        // String qrText =
        // voucher.getVoucher()+"$"+voucher.getVoucher()+voucher.getVoucher()+voucher.getVoucher();

        qrText = getBase64QrCodeText(qrText);
        // System.out.println("QrTextLength$$" + qrText.length());
        ByteArrayOutputStream bos = QRCode.from(qrText).to(ImageType.PNG)
                .stream();
        byte[] imageBytes = bos.toByteArray();

        BASE64Encoder encoder = new BASE64Encoder();

        imageString = "data:image/png;base64," + encoder.encode(imageBytes);
        BASE64Decoder decoder=new BASE64Decoder();
        String img=imageString.split(",")[1];
        System.out.println(img+"  imageString");
       // imageBytes=decoder.decode(imageBytes,11,11);
        //String dStr = new String(decoder.decode(imageBytes));
        System.out.println(imageBytes+"  imageBytes");

        return imageString;
    }
    /**
     * converts the qr image to encrypted string
     * @param qrText-plain qr text
     * @return encrypted qrCode;
     */
    public String getBase64QrCodeText(String qrText) {
        String imageString = "";
        byte[] stringBytes = qrText.getBytes();
        BASE64Encoder encoder = new BASE64Encoder();
        imageString = encoder.encode(stringBytes);
        Base64.Decoder decoder = Base64.getDecoder();
        // Decoding string
        String dStr = new String(decoder.decode(imageString));
        System.out.println("Decoded string: "+dStr);

        return dStr;
    }
}
