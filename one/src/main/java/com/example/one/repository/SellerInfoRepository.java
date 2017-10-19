package com.example.one.repository;

import com.example.one.domain.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by QianYunlong on 19
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String>{

    SellerInfo findByOpenid(String openid);
}
