package com.cf.shipment_order.service.impl;

import com.cf.shipment_order.api.ResponseResult;
import com.cf.shipment_order.dao.ShipmentOrderDao;
import com.cf.shipment_order.entity.OrderDetails;
import com.cf.shipment_order.entity.OrderHead;
import com.cf.shipment_order.service.ShipmentOrderService;
import com.cf.shipment_order.utils.CommonsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 销售落单业务层
 */
@Service
public class ShipmentOrderServiceImpl implements ShipmentOrderService {

    @Autowired
    private ShipmentOrderDao shipmentOrderDao;

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;
    @Autowired
    private TransactionDefinition transactionDefinition;

    @Override
    public ResponseResult saveShiomentOrder(OrderHead orderHead) {

        List<OrderDetails> orderDetials = orderHead.getOrderDetials();

        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        try{
            //保存head信息
            int isSuccesHead = shipmentOrderDao.addOrderHead(orderHead);
            if(isSuccesHead == 0){
                return CommonsResult.getFailResult("保存失败");
            }

            // 保存明细
            // 1. 给明细添加订单号，和head数据进行绑定
            for (OrderDetails orderDetail : orderDetials) {
                orderDetail.setOrder_no(orderHead.getOrder_no());
            }
            int isSuccesDetails = shipmentOrderDao.addOrderDetails(orderDetials);
            if(isSuccesDetails == 0){
                dataSourceTransactionManager.rollback(transactionStatus);
                return CommonsResult.getFailResult("保存失败");
            }
            dataSourceTransactionManager.commit(transactionStatus);
        }catch (Exception e){
            dataSourceTransactionManager.rollback(transactionStatus);
            e.printStackTrace();
            return CommonsResult.getFailResult("保存失败");
        }

        return CommonsResult.getSuccesResult(orderHead);
    }

    @Override
    public ResponseResult getOrderByNo(String order_no) {
        OrderHead orderHead = shipmentOrderDao.getOrderHeadByOrderNo(order_no);
        List<OrderDetails> orderDetails = shipmentOrderDao.getOrderDetailsByOrderNo(order_no);
        orderHead.setOrderDetials(orderDetails);
        return CommonsResult.getSuccesResult("查询成功",orderHead);
    }

    @Override
    public ResponseResult modityOrder(OrderHead orderHead) {
        List<OrderDetails> orderDetials = orderHead.getOrderDetials();

        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        try{
            //保存head信息
            int isSuccesHead = shipmentOrderDao.modityOrderHead(orderHead);
            if(isSuccesHead == 0){
                return CommonsResult.getFailResult("修改失败");
            }

            // 修改明细
            int isSuccesDetails = shipmentOrderDao.modityOrderDetails(orderDetials);
            if(isSuccesDetails == 0){
                dataSourceTransactionManager.rollback(transactionStatus);
                return CommonsResult.getFailResult("保存失败");
            }
            dataSourceTransactionManager.commit(transactionStatus);
        }catch (Exception e){
            dataSourceTransactionManager.rollback(transactionStatus);
            e.printStackTrace();
            return CommonsResult.getFailResult("保存失败");
        }

        return CommonsResult.getSuccesResult(orderHead);
    }

    @Override
    public Map getOrderHeadByCondition(Map paramMap) {
        List<OrderHead> orderHead = shipmentOrderDao.getOrderHeadByCondition(paramMap);

        if(paramMap.get("total") == null){
            paramMap.put("page_index",1);
            paramMap.put("page_size",2);
        }

        int count = shipmentOrderDao.getOrderHeadCount(paramMap);
        Map<String,Object> map = new HashMap();

            map.put("page_index",paramMap.get("page_index"));
        map.put("total",count);
        map.put("page_size",2);
        map.put("data",orderHead);

        map.put("msg","查询成功");
        map.put("code",1);

        return map;
    }
}
