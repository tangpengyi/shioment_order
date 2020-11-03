package com.cf.shipment_order.entity;

public class Contacts {

    private int id;
    private String customer_no;
    private String general_manager;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer_no() {
        return customer_no;
    }

    public void setCustomer_no(String customer_no) {
        this.customer_no = customer_no;
    }

    public String getGeneral_manager() {
        return general_manager;
    }

    public void setGeneral_manager(String general_manager) {
        this.general_manager = general_manager;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
