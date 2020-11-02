package com.cf.shipment_order.controller;

import com.cf.shipment_order.entity.User;
import com.cf.shipment_order.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试")
@RequestMapping("shipment_order/")
@RestController
public class HelloController {

    @Autowired
    private UserService userService;

    @ApiOperation(value="查询待入仓的订单")
    @GetMapping("hello")
    public User hello(){
        return userService.getUser();
    }
}
