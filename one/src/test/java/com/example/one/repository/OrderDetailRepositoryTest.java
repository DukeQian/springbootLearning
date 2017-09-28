package com.example.one.repository;

import com.example.one.domain.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123456728");
        orderDetail.setOrderId("123213");
        orderDetail.setProductId("123");
        orderDetail.setProductIcon("http://");
        orderDetail.setProductName("TEST");
        orderDetail.setProductPrice(new BigDecimal(3.3));
        orderDetail.setProductQuantity(22);

        OrderDetail orderDetail1 = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(orderDetail1);
    }

    @Test
    public void findByOrderId()throws Exception{
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId("123213");
        Assert.assertNotEquals(0, orderDetailList.size());
    }
}