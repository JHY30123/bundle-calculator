package com.codetest.entities;

import com.codetest.enums.Format;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BundleBreakdown {
  private int number;
  private Format format;
  private BigDecimal totalPrice;
  private List<String> breakdownDetail;
}
