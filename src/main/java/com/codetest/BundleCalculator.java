package com.codetest;

import com.codetest.entities.Input;
import com.codetest.entities.Output;

import java.util.Arrays;
import java.util.stream.IntStream;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BundleCalculator {

  BundleCollection bundleCollection = new BundleCollection();
  Input input = new Input();
  Output output = new Output();

  private Map<Integer, BigDecimal> getBundle(String format) {
    return bundleCollection.getBundleCollection().get(format);
  }

  private Integer[] getBundleSizeList(Map<Integer, BigDecimal> bundleDetail) {
    return bundleDetail.keySet().toArray(new Integer[0]);
  }

  private BigDecimal[] getBundlePriceList(Map<Integer, BigDecimal> bundleDetail) {
    return bundleDetail.values().toArray(new BigDecimal[0]);
  }

  private int[] getBundlePlan(Integer[] bundleSizeList, int amount) {
    int[][] amountPath = new int[bundleSizeList.length][amount + 1];

    int current = amount;
    int[] bundlePlan = new int[bundleSizeList.length];

    for(int[] row: amountPath)
      Arrays.fill(row, Integer.MAX_VALUE);

    for (int i = 1; i <= bundleSizeList.length - 1; i++) {
      for (int j = 1; j <= amount; j++) {
        if (j <= bundleSizeList[i]) amountPath[i][j] = Math.min(amountPath[i-1][j],bundleSizeList[i]);
        else amountPath[i][j] = Math.min(amountPath[i-1][j],amountPath[i][j - bundleSizeList[i]] + bundleSizeList[i]);
      }
    }

    for(int i = bundleSizeList.length - 1; i >= 1; i--) {
      int count = 0;
      if(amountPath[i][current] != amountPath[i -1][current]) {
        current -= bundleSizeList[i];
        bundlePlan[i] = ++ count;
        while(current >= bundleSizeList[i] && amountPath[i][current] != amountPath[i - 1][current]) {
          bundlePlan[i] = ++ count;
          current -= bundleSizeList[i];
        }
      }
    }
    return bundlePlan;
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
                    getBundlePlan(getBundleSizeList(getBundle(input.getPostFormat())), input.getPostAmount()),
                    getBundlePriceList(getBundle(input.getPostFormat()))
                )
            ).build();

    return output;
  }
}
