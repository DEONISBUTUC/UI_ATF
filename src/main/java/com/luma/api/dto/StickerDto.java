package com.luma.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StickerDto {
   private String id;
   private boolean isOnlyOnlineSticker;
   private boolean isDynamicPrice;
   private String image;
   private String cssClass;
}
