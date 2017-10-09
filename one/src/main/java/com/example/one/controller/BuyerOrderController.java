package com.example.one.controller;

import com.example.one.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    //创建订单
    public ResultVO<Map<String,String>> create(){
        
    }

    //订单列表

    //订单详情

    //取消订单
}
