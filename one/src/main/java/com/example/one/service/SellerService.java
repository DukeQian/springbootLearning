package com.example.one.service;

import com.example.one.domain.SellerInfo;

/**
 * Created by QianYunlong on 19
 */
public interface SellerService {

    SellerInfo findSellerInfoByOpenid(String openid);
}
