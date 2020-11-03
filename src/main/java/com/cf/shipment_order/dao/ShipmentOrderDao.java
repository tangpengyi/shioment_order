package com.cf.shipment_order.dao;

import com.cf.shipment_order.entity.Customer;
import com.cf.shipment_order.entity.OrderDetails;
import com.cf.shipment_order.entity.OrderHead;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface ShipmentOrderDao {

    public int addOrderHead(OrderHead orderHead);

    public int addOrderDetails(List<OrderDetails> orderDetails);

    public OrderHead getOrderHeadByOrderNo(String order_no);

    public List<OrderDetails> getOrderDetailsByOrderNo(String order_no);

    public int modityOrderHead(OrderHead orderHead);

    public int modityOrderDetails(List<OrderDetails> orderDetails);

    public List<OrderHead> getOrderHeadByCondition(Map paramMap);

    public int getOrderHeadCount(Map paramMap);

    public List<Customer> getCustomerByName(String customerName);
}
