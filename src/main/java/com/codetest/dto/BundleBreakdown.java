package com.codetest.dto;

import com.codetest.resources.Format;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class BundleBreakdown {
  private int postAmount;
  private Format postFormat;
  private BigDecimal minTotalCost;
  private List<String> selectionDetail;
}
