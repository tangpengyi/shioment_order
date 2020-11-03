package com.cf.shipment_order.service;

import com.cf.shipment_order.api.ResponseResult;
import com.cf.shipment_order.entity.OrderHead;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface ShipmentOrderService {

    public ResponseResult saveShiomentOrder(OrderHead orderHead);

    public ResponseResult getOrderByNo(String order_no);

    public ResponseResult modityOrder(OrderHead orderHead);

    public Map getOrderHeadByCondition(Map paramMap);

}
