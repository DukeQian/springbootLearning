package com.example.one.converter;

import com.example.one.domain.OrderMaster;
import com.example.one.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();

        BeanUtils.copyProperties(orderMaster, orderDTO);

        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (OrderMaster orderMaster:orderMasterList){
            orderDTOList.add(convert(orderMaster));
        }
        return orderDTOList;
    }
}
