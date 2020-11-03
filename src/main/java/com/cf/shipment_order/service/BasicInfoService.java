package com.cf.shipment_order.service;

import com.cf.shipment_order.api.ResponseResult;

public interface BasicInfoService {

    public ResponseResult findCustomerByName(String cusromerName);

    public ResponseResult findSalesByName(String name);

    public ResponseResult findBasicInfo();

    public ResponseResult findMaterilaByNo(String materialNo);


}
