package com.revenue.revenueCollection.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Time;

import java.sql.Timestamp;
@Entity
public class RequestMessages {
    @Id
    @GeneratedValue
    @NotNull
public int ID ;
public String DIRECTION ;
public Timestamp CREATED_ON ;
public String ESB_REFERENCE ;
public String CHANNEL_TIMESTAMP ;
public String CHANNEL_REFERENCE ;
public String CHANNEL_IP ;
public String GEOLOCATION ;
public String USER_AGENT ;
public String USER_AGENT_VERSION ;
public String CHANNEL ;
public String TRANSACTION_TYPE ;
public String TRANSACTION_CODE ;
public String HOST_CODE ;
public String CLIENT_ID ;
public int AMOUNT;
public String DEBIT_ACCOUNT ;
public String CREDIT_ACCOUNT ;
public String BILLER_REF ;
public String RESPONSE_CODE ;
public String RESPONSE_MESSAGE ;
public String ERROR_DESCRIPTION ;
public Double CHARGE_AMOUNT ;
public Double VAT_AMOUNT ;
public Double COMMISSION_AMOUNT ;
public String SERVICE_STATUS ;
public String PHONE;
public int IS_CBS ;
public int CBS_STATUS ;
public String CBS_RESPONSE_CODE ;
public String CBS_RESPONSE_MESSAGE ;
public String WALLET_RESPONSE_CODE ;
public String WALLET_RESPONSE ;
public String POS_RECEIPT ;
public String GROUP_ID ;
public int ID1 ;
public String DIRECTION1 ;
public Timestamp CREATED_ON1 ;
public String ESB_REFERENCE1 ;
public String CHANNEL_TIMESTAMP1 ;
public String CHANNEL_REFERENCE1 ;
public String CHANNEL_IP1 ;
public String GEOLOCATION1 ;
public String USER_AGENT1 ;
public String USER_AGENT_VERSION1 ;
public String CHANNEL1 ;
public String TRANSACTION_TYPE1 ;
public String TRANSACTION_CODE1 ;
public String HOST_CODE1 ;
public String CLIENT_ID1 ;
public Double AMOUNT1 ;
public String DEBIT_ACCOUNT1 ;
public String CREDIT_ACCOUNT1 ;
public String BILLER_REF1 ;
public String RESPONSE_CODE1 ;
public String RESPONSE_MESSAGE1 ;
public String ERROR_DESCRIPTION1 ;
public Double CHARGE_AMOUNT1 ;
public Double VAT_AMOUNT1 ;
public int COMMISSION_AMOUNT1 ;
public String SERVICE_STATUS1 ;

public int IS_CBS1 ;
public int CBS_STATUS1 ;
public String CBS_RESPONSE_CODE1 ;
public String CBS_RESPONSE_MESSAGE1 ;
public String WALLET_RESPONSE_CODE1 ;
public String WALLET_RESPONSE1 ;
public String POS_RECEIPT1 ;
public int GROUP_ID1 ;
}
