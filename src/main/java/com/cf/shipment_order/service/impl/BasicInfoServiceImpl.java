package com.cf.shipment_order.service.impl;

import com.cf.shipment_order.api.ResponseResult;
import com.cf.shipment_order.dao.BasicInfoDao;
import com.cf.shipment_order.entity.*;
import com.cf.shipment_order.service.BasicInfoService;
import com.cf.shipment_order.utils.CommonsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BasicInfoServiceImpl implements BasicInfoService {

    @Autowired
    private BasicInfoDao basicInfoDao;

    @Override
    public ResponseResult findCustomerByName(String cusromerName) {

        List<Customer> customers = basicInfoDao.getCustomerByName(cusromerName);

        for (Customer customer : customers){
            customer.setContacts(basicInfoDao.getContactsByCustomerNo(customer.getCustomer_no()));
        }

        return CommonsResult.getSuccesResult("查询成功",customers);
    }

    @Override
    public ResponseResult findSalesByName(String name) {
        List<Sales> sales = basicInfoDao.getSalesByName(name);
        return CommonsResult.getSuccesResult("查询成功",sales);
    }

    @Override
    public ResponseResult findBasicInfo() {
        //货币
        List<Currency> currency = basicInfoDao.getCurrency();
        //优先级
        List<String> priority = basicInfoDao.getPriority();
        //状态
        List<String> orderStatus = basicInfoDao.getOrderStatus();
        //单位
        List<String> quantityUnit = basicInfoDao.getQuantityUnit();

        Map<String,Object> map = new HashMap<>();
        map.put("priority",priority);
        map.put("currency",currency);
        map.put("order_status",orderStatus);
        map.put("quantity_unit",quantityUnit);
        return CommonsResult.getSuccesResult("查询成功",map);
    }

    @Override
    public ResponseResult findMaterilaByNo(String materialNo) {
        List<Material> materilas = basicInfoDao.getMaterila(materialNo);
        for(Material material : materilas){
            List<Color> colorByMaterialNo = basicInfoDao.getColorByMaterialNo(material.getMaterial_no());
            material.setColor(colorByMaterialNo);
        }
        return CommonsResult.getSuccesResult("查询成功",materilas);
    }
}
