package com.example.one.repository;

import com.example.one.domain.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void testSave(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("eggrice");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("very good");
        productInfo.setProductIcon("http://dafa");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);
        ProductInfo productInfo1 = productInfoRepository.save(productInfo);
        Assert.assertNotNull(productInfo1);
    }
}