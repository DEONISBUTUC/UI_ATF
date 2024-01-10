package com.luma.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.ArrayList;
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)

public class VariationDto {
   private String id;
   private ArrayList<PictureDto> pictures;
   private String vendorSku;
   private String variationCode;
   private String colorCSS;
}
