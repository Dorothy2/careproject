package com.drifai.careproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProviderDTO {
   private String firstName;
   private String lastName;
   private String vertical;
   private String zipCode;
   private BigDecimal rate;

}
