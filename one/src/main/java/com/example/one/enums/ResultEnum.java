package com.example.one.enums;


public enum  ResultEnum {

    UNKNOWN_ERROR(1,"未知错误"),
    SUCCESSOR(2,"成功"),

    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "库存不足"),
    ORDER_NOT_EXIST(12,"订单号不存在"),
    ORDERDETAIL_NOT_EXIST(13,"订单号明细不存在"),
    ORDERSTATUS_ERROR(14,"订单状态不对"),
    ORDERMASTER_UPDATE_FAIL(15,"更新失败"),
    ORDER_DETAIL_EMPTY(15,"商品没有"),
    ORDERPAYSTATUS_ERROR(15,"支付状态不正确"),
    PARAM_ERROR(1,"参数不正确"),
    CART_EMPTY(1,"购物车不能为空"),


    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
