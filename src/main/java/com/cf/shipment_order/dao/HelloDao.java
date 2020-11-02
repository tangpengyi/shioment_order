package com.cf.shipment_order.dao;

import com.cf.shipment_order.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface HelloDao {
    public User hello();
}
