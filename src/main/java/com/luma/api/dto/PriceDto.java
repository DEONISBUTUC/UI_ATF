package com.luma.api.dto;


import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)

public class PriceDto {
    private String discountType;
    private String gaPriceOffer;
    private int price;
    private InstallmentDto installment;
    private int old;
    private DiscountDto  discount;
}
