package com.codetest.mapper;

import com.codetest.BundleCalculator;
import com.codetest.BundleCollection;
import com.codetest.entities.Input;
import com.codetest.entities.Output;
import java.math.BigDecimal;
import java.util.Map;

public class OutputMapper {

  BundleCalculator bundleCalculator = new BundleCalculator();
  BundleCollection bundleCollection = new BundleCollection();

  private Map<Integer, BigDecimal> getBundle(String format) {
    return bundleCollection.getBundleCollection().get(format);
  }

  private Integer[] getBundleSizeList(Map<Integer, BigDecimal> bundleDetail) {
    return bundleDetail.keySet().toArray(new Integer[0]);
  }

  private BigDecimal[] getBundlePriceList(Map<Integer, BigDecimal> bundleDetail) {
    return bundleDetail.values().toArray(new BigDecimal[0]);
  }

  private String[] writeToSelectinDetailList(int[] bundlePlan, BigDecimal[] bundlePriceList) {
//    return IntStream.range(1, bundlePlan.length)
//        .collect(String[]::new, x -> (bundlePlan[x] + "* $" + bundlePriceList[x]))
////    return Arrays.stream(bundlePlan).map(x -> )
    String[] selectionDetailList = new String[bundlePlan.length];
    for(int i = 1; i <= bundlePlan.length - 1; i++) {
      if(bundlePlan[i] != 0) {
        selectionDetailList[i] = (bundlePlan[i] + "* $" + bundlePriceList[i]);
      }
    }
    return selectionDetailList;
  }

//  private BigDecimal getTotalAmount(int[] bundlePlan, BigDecimal[] bundlePriceList[]) {
//    BigDecimal totalAmount;
//    for(int i = 1; i <= bundlePlan.length; i++) {
//      totalAmount += BigDecimal.valueOf(bundlePlan[i] * bundlePriceList[i]);
//    }
//    return totalAmount;
//  }

  public Output getMinBundleSelection(Input input) {
    Output output = Output.builder()
        .postAmount(input.getPostAmount())
        .postFormat(input.getPostFormat())
        .minTotalPrice(BigDecimal.valueOf(12.0))
        .bundleSelectionDetail(
            writeToSelectinDetailList(
                bundleCalculator.getBundlePlan(getBundleSizeList(getBundle(input.getPostFormat())), input.getPostAmount()),
                getBundlePriceList(getBundle(input.getPostFormat()))
            )
        ).build();

    return output;
  }
}
