package com.luma.api.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDto {
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
   private ArrayList<VariationDto> variationDto;
   private ArrayList<StickerDto> sticker;
   private StockDto stockDto;
   private GaAttachedOfferDto gaAttachedOffer;
   private boolean isSelected;
   private int quantity;
}
