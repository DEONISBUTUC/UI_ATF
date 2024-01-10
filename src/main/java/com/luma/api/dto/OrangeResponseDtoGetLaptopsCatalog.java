package com.luma.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.ArrayList;
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)

public class OrangeResponseDtoGetLaptopsCatalog {

  private String id;
  private String name;
  private String href;
  private String sorting;
  private ListInfoDto listInfo;
  private ArrayList<FilterDto> filter;
  private ArrayList<DeviceDto> device;
  private ArrayList<Object> subMenu;
  private ArrayList<BreadcrumbDto> breadcrumbs;
}
