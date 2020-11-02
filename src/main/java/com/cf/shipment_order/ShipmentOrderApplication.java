package com.cf.shipment_order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.cf.shipment_order.dao")
public class ShipmentOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShipmentOrderApplication.class, args);
    }

}
