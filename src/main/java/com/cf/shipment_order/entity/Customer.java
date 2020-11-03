package com.cf.shipment_order.entity;

import java.util.List;

public class Customer {

    private int customer_id;
    //客户简称
    private String customer_abbreviation;
    private String customer_no;
    private String customer_name;
    //默认销售员
    private String default_salesperson;
    //部门
    private String department;
    private String telephone;
    //传真
    private String fax;
    //交地
    private String land_exchange;

    private List<Contacts> contacts;


    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_abbreviation() {
        return customer_abbreviation;
    }

    public void setCustomer_abbreviation(String customer_abbreviation) {
        this.customer_abbreviation = customer_abbreviation;
    }

    public String getCustomer_no() {
        return customer_no;
    }

    public void setCustomer_no(String customer_no) {
        this.customer_no = customer_no;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getDefault_salesperson() {
        return default_salesperson;
    }

    public void setDefault_salesperson(String default_salesperson) {
        this.default_salesperson = default_salesperson;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getLand_exchange() {
        return land_exchange;
    }

    public void setLand_exchange(String land_exchange) {
        this.land_exchange = land_exchange;
    }

    public List<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contacts> contacts) {
        this.contacts = contacts;
    }
}
