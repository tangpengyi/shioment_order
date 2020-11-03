package com.cf.shipment_order.entity;

public class Sales {

    private int sales_id;
    private String sales_name;
    private String sales_group;


    public int getSales_id() {
        return sales_id;
    }

    public void setSales_id(int sales_id) {
        this.sales_id = sales_id;
    }

    public String getSales_name() {
        return sales_name;
    }

    public void setSales_name(String sales_name) {
        this.sales_name = sales_name;
    }

    public String getSales_group() {
        return sales_group;
    }

    public void setSales_group(String sales_group) {
        this.sales_group = sales_group;
    }
}
