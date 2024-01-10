package com.luma.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)

public class BreadcrumbDto {
   private String id;
   private String name;
   private String href;
}
