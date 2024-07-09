package com.inditex.inditex_technical_test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ConfirmationDTO {
    private String code;
    private String description;

}
