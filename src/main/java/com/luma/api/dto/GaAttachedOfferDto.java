package com.luma.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.ArrayList;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)

public class GaAttachedOfferDto {
   private String device;
   private String bonus;
   private String subscription;
   private ArrayList<String> promotions;
}
