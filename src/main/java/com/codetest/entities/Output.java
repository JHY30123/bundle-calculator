package com.codetest.entities;

import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class Output {
  private int postAmount;
  private String postFormat;
  private BigDecimal minTotalPrice;
  private String[] bundleSelectionDetail;

  public Output(int postAmount, String postFormat, BigDecimal minTotalPrice, String[] bundleSelectionDetail) {
    this.postAmount = postAmount;
    this.postFormat = postFormat;
    this.minTotalPrice = minTotalPrice;
    this.bundleSelectionDetail = bundleSelectionDetail;
  }
}
