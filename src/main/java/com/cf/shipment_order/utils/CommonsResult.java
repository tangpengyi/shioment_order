package com.cf.shipment_order.utils;

import com.cf.shipment_order.api.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class CommonsResult {

    public static ResponseResult getSuccesResult(Object obj){
        ResponseResult bean = ResponseResult.getBean();
        bean.setCode(1);
        bean.setMsg("操作成功");
        bean.setData(obj);
        return bean;
    }

    public static ResponseResult getSuccesResult(String msg,Object obj){
        ResponseResult bean = ResponseResult.getBean();
        bean.setCode(1);
        bean.setMsg(msg);
        bean.setData(obj);
        return bean;
    }

    public static ResponseResult getFailResult(String msg){
        ResponseResult bean = ResponseResult.getBean();
        bean.setCode(0);
        bean.setMsg(msg);
        return bean;
    }

    public static ResponseResult getFailResult(){
        ResponseResult bean = ResponseResult.getBean();
        bean.setCode(0);
        bean.setMsg("操作失败");
        return bean;
    }
}
