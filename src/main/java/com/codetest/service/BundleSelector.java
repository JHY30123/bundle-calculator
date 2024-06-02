package com.codetest.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BundleSelector {

//  private int test() {
//    for(int i = 1; i <= n; i++) {
//      for(int j = m; j >= v[i]; j --) {
//        f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
//      }
//    }
//    return f[m];
//  }

  /**
   * Get list of how many element got used in bundleSizeList in order to get target value.
   *
   * @param bundleSizeList Size list of
   * @param amount The target value
   * @return a list of element usage in bundleSizeList
   */
  public List<Integer> calculateBundlePlan(List<Integer> bundleSizeList, int amount) {
    int[][] amountPath = new int[bundleSizeList.size()][amount + 1];

    int current = amount;
    Integer[] bundlePlan = new Integer[bundleSizeList.size()];
    for (int[] row : amountPath) Arrays.fill(row, Integer.MAX_VALUE);

    for (int i = 1; i <= bundleSizeList.size() - 1; i++) {
      for (int j = 1; j <= amount; j++) {
        if (j <= bundleSizeList.get(i))
          amountPath[i][j] = Math.min(amountPath[i - 1][j], bundleSizeList.get(i));
        else
          amountPath[i][j] =
              Math.min(
                  amountPath[i - 1][j], amountPath[i][j - bundleSizeList.get(i)] + bundleSizeList.get(i));
      }
    }

    for (int i = bundleSizeList.size() - 1; i >= 1; i--) {
      int count = 0;
      if (amountPath[i][current] != amountPath[i - 1][current]) {
        current -= bundleSizeList.get(i);
        bundlePlan[i] = ++count;
        while (current >= bundleSizeList.get(i)
            && amountPath[i][current] != amountPath[i - 1][current]) {
          bundlePlan[i] = ++count;
          current -= bundleSizeList.get(i);
        }
      }
    }
    return Arrays.asList(bundlePlan);
  }

  /**
   * Get total cost of selected plan in certain bundle
   *
   * @param bundlePriceList Price list of certain format
   * @param bundlePlan BundlePriceList's element usage situation
   * @return Total cost of this selected plan
   */
  public BigDecimal totalPriceCalculator(List<BigDecimal> bundlePriceList, List<Integer> bundlePlan) {
    return IntStream.range(1, Math.max(bundlePriceList.size(), bundlePlan.size()))
        .mapToObj(x -> bundlePriceList.get(x).multiply(BigDecimal.valueOf(bundlePlan.get(x))))
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}
