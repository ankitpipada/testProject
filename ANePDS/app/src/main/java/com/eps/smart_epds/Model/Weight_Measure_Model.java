package com.eps.smart_epds.Model;

/**
 * Created by lenovo on 12/15/2017.
 */

public class Weight_Measure_Model
{
    String type;
    String license_no;
    String issue_date;
    String expiry_date;

    public String getType() {
        return type;
    }

    public void setType(String number) {
        this.type = number;
    }

    public String getLicense_no() {
        return license_no;
    }

    public void setLicense_no(String license_no) {
        this.license_no = license_no;
    }

    public String getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }
}
