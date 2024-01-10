package com.luma.api.dto;


import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)

public class ListInfoDto {
    private String id;
    private String name;
}
