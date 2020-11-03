package com.cf.shipment_order.controller;

import com.cf.shipment_order.api.ResponseResult;
import com.cf.shipment_order.entity.OrderHead;
import com.cf.shipment_order.service.BasicInfoService;
import com.cf.shipment_order.service.ShipmentOrderService;
import com.cf.shipment_order.utils.CommonsResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Api("销售落单通知")
@RestController
//@RequestMapping("/shipment_order")
public class SOrderController {

    @Autowired
    private ShipmentOrderService shipmentOrderService;

    @Autowired
    private BasicInfoService basicInfoService;

    @ApiOperation(value="保存订单")
    @PostMapping("/shipment_order")
    public ResponseResult shipmentOrder(@RequestBody OrderHead orderHead){
        return shipmentOrderService.saveShiomentOrder(orderHead);
    }


    @ApiOperation("根据订单号查询订单信息")
    @GetMapping("/shipment_order")
    public ResponseResult findShipmentOrderByOrderNo(String order_no){
        return shipmentOrderService.getOrderByNo(order_no);
    }

    @ApiOperation("修改订单")
    @PutMapping("/shipment_order")
    public ResponseResult modityShipmentOrder(@RequestBody OrderHead orderHead){
        return shipmentOrderService.modityOrder(orderHead);
    }

    @ApiOperation("条件查询订单")
    @GetMapping("/order_head")
    public Map findOrderHeadByCondition(@RequestBody Map<String,Object> paramMap){
        return shipmentOrderService.getOrderHeadByCondition(paramMap);
    }


    @ApiOperation("根据客户名称查询客户")
    @GetMapping("/shipment_order/customer")
    public ResponseResult findCustomerByName(String customerName){
        return basicInfoService.findCustomerByName(customerName);
    }

    @ApiOperation("根据销售名查询销售员")
    @GetMapping("/shipment_order/sales")
    public ResponseResult getSalesByName(String name){
        return basicInfoService.findSalesByName(name);
    }

    @ApiOperation("查询销售落单基础信息")
    @GetMapping("/page_info")
    public ResponseResult getBasicInfo(){
        return basicInfoService.findBasicInfo();
    }

    @ApiOperation("/根据编号查询物料")
    @GetMapping("/material")
    public ResponseResult getMaterialInfo(String materialNo){
        return basicInfoService.findMaterilaByNo(materialNo);
    }

}
