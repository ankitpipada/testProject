package com.eps.smart_epds.Model;

/**
 * Created by Admin on 12/7/2017.
 */

public class Applcation_Status_Model {
    String Date;
    String AcknowledgeNo;
    String RequestType;

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getAcknowledgeNo() {
        return AcknowledgeNo;
    }

    public void setAcknowledgeNo(String acknowledgeNo) {
        AcknowledgeNo = acknowledgeNo;
    }

    public String getRequestType() {
        return RequestType;
    }

    public void setRequestType(String requestType) {
        RequestType = requestType;
    }

    public String getWaorkFlow() {
        return WaorkFlow;
    }

    public void setWaorkFlow(String waorkFlow) {
        WaorkFlow = waorkFlow;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    String WaorkFlow;
    String Status;
    String DateTime;
}
