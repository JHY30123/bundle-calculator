package com.codetest;

import java.util.Arrays;
import lombok.Data;

import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BundleCalculator {

  /**
   * Get list of how many element got used in list in order to get target value.
   *
   * @param bundleSizeList Size list of
   * @param amount The target value
   * @return a list of element usage in bundleSizeList
   */
  public int[] getBundlePlan(Integer[] bundleSizeList, int amount) {
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
}
