package com.cf.shipment_order.api;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ResponseResult {

    private static volatile ResponseResult responseResult = null;

    private int code;
    private String msg;
    private Object data;


    public static ResponseResult getBean(){
        Lock lock = new ReentrantLock();

        if(responseResult == null){
            lock.lock();
            try{
                if(responseResult == null){
                    responseResult = new ResponseResult();
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
        return responseResult;
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
