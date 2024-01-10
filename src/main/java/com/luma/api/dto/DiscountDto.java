package com.luma.api.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)

public class DiscountDto {
   private int amount;
   private int percent;
}
