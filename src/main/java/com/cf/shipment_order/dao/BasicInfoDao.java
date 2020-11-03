package com.cf.shipment_order.dao;

import com.cf.shipment_order.entity.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasicInfoDao {
    public List<Customer> getCustomerByName(String customerName);

    public List<Contacts> getContactsByCustomerNo(String customerNo);

    public List<Sales> getSalesByName(String name);

    public List<String> getPriority();

    public List<Currency> getCurrency();

    public List<String> getOrderStatus();

    public List<String> getQuantityUnit();

    public List<Material> getMaterila(String materialNo);

    public List<Color> getColorByMaterialNo(String materialNo);
}
