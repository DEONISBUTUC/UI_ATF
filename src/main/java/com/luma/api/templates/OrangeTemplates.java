package com.luma.api.templates;

import com.luma.api.dto.*;
import io.cucumber.datatable.DataTable;
import java.util.Map;

public class OrangeTemplates {

    public OrangeRequestDtoGetHomePage getHomePageRequest(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap();
        return OrangeRequestDtoGetHomePage.builder()
                .mostPopularProducts(MostPopularProductsDto.builder()
                        .include(Boolean.parseBoolean(map.getOrDefault("mostPopular", map.get("mostPopular"))))
                        .build())
                .recentlyViewedProducts(RecentlyViewedProductsDto.builder()
                        .include(Boolean.parseBoolean(map.getOrDefault("recentlyViewed", map.get("recentlyViewed"))))
                        .build())
                .build();
    }







}
