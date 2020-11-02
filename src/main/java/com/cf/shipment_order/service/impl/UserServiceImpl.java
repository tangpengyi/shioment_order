package com.cf.shipment_order.service.impl;

import com.cf.shipment_order.dao.HelloDao;
import com.cf.shipment_order.entity.User;
import com.cf.shipment_order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private HelloDao helloDao;

    @Override
    public User getUser() {
        return helloDao.hello();
    }
}
