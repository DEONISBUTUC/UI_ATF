package com.luma.api.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.ArrayList;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)

public class FilterDto {
   private int id;
   private String name;
   private String type;
   private ArrayList<ItemDto> item;
   private NumericRangeDto numericRange;
}
