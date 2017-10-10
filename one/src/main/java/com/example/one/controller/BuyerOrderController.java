package com.example.one.controller;

import com.example.one.converter.OrderForm2OrderDTOConverter;
import com.example.one.dto.OrderDTO;
import com.example.one.enums.ResultEnum;
import com.example.one.exception.SellException;
import com.example.one.form.OrderForm;
import com.example.one.service.OrderService;
import com.example.one.util.ResultVOUtil;
import com.example.one.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("[创建订单]参数不正确, orderForm = {}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){\
            log.error("[创建订单]购物车不能为空");
        throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult =     orderService.create(orderDTO);
        Map<String,String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());

        return ResultVOUtil.success(map);

    }

    //订单列表

    //订单详情

    //取消订单
}
