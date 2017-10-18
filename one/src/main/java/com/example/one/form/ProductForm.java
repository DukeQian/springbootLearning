package com.example.one.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by QianYunlong on 18
 */
@Data
public class ProductForm {

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer productStatus;

    private Integer categoryType;
}
