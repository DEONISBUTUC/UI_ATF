package com.luma.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)

public class InstallmentDto {
    private int period;
    private int monthlyFee;
}
