package com.luma.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)

public class StockDto {
   private boolean inStock;
   private boolean isOnline;
   private boolean isPickup;
   private boolean isOnlyOnline;
}
