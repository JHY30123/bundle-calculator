package com.codetest.fields;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Output {
  private int postAmount;
  private String postFormat;
  private BigDecimal minTotalPrice;
  private List<String> bundleSelectionDetail;
}
