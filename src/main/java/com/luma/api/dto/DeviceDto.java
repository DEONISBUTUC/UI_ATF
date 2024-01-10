package com.luma.api.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

import java.util.ArrayList;
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)

public class DeviceDto {
   private String id;
   private String name;
   private String defaultName;
   private String seo;
   private String href;
   private String brandName;
   private String subCategoryId;
   private String categoryType;
   private String categoryName;
   private boolean isRefubrished;
   private PriceDto price;
   private ArrayList<VariationDto> variation;
   private ArrayList<Object> sticker;
   private StockDto stock;
   private GaAttachedOfferDto gaAttachedOffer;
}
