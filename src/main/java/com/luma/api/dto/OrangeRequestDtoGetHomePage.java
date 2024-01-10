package com.luma.api.dto;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrangeRequestDtoGetHomePage {

    @JsonProperty("MostPopularProducts")
    private MostPopularProductsDto mostPopularProducts;
    @JsonProperty("RecentlyViewedProducts")
    private RecentlyViewedProductsDto recentlyViewedProducts;
}
