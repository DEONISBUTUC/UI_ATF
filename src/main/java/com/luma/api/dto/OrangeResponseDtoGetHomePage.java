package com.luma.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrangeResponseDtoGetHomePage {
    private MostPopularProductsDto mostPopularProducts;
    private RecentlyViewedProductsDto recentlyViewedProducts;

}
