package com.cf.shipment_order.filter;

import com.cf.shipment_order.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private TokenUtils tokenUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response
            , Object handler) throws Exception {

        String authorization = request.getHeader("Authorization");
        try{
            if (authorization == null || !authorization.startsWith("Bearer ")) {
                throw new Exception("用户未登录");
            }

            String token = authorization.substring(7);
            //jjwt验证
            tokenUtils.verity(token);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
