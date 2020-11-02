package com.cf.shipment_order.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TokenUtils {

    @Value("${token.secert}")
    private String secert;

    private String token = "";

    /**
     * 验证token
     * @param token
     * @return
     */
    public DecodedJWT verity(String token){
        this.token = token;
        return JWT.require(Algorithm.HMAC256(secert)).build().verify(token);
    }

    /**
     * 获取用户的id
     * @return
     */
    public Integer getUserId(){
        DecodedJWT verity = verity(token);
        String user_id = verity.getClaim("user_id").asString();
        return Integer.valueOf(user_id);
    }

}
