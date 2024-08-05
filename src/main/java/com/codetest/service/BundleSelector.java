package com.codetest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BundleSelector {
  private int[] minCountArray;
  private List<List<Integer>> breakdownList;

  /**
   * Calculate the fewest number of bundles to make up the given number, return empty list if no
   * combinations suitable
   *
   * @param bundleOptionList Size list of
   * @param amount The target value
   * @return bundle number list
   */
  public List<Integer> generateSelection(List<Integer> bundleOptionList, int amount) {
    minCountArray = new int[amount + 1];
    breakdownList = new ArrayList<>(Collections.nCopies(amount + 1, null));
    Arrays.fill(minCountArray, Integer.MAX_VALUE);
    minBundleNumberDp(bundleOptionList, amount);
    return minCountArray[amount] == Integer.MAX_VALUE
        ? Collections.emptyList()
        : breakdownList.get(amount);
  }

  /**
   * Dynamic programming to find the fewest number of bundles to make up the given number
   *
   * @param bundleSizeList Size list of
   * @param count The target value
   * @return The fewest number of bundles to make up the given number
   */
  public int minBundleNumberDp(List<Integer> bundleSizeList, int count) {
    if (count == 0) return 0;
    // No solution
    if (count < 0) return -1;
    if (minCountArray[count] != Integer.MAX_VALUE) return minCountArray[count];

    int minCount = Integer.MAX_VALUE;
    for (int i = 0; i < bundleSizeList.size(); i++) {
      int bundleSize = bundleSizeList.get(i);
      int subProblem = minBundleNumberDp(bundleSizeList, count - bundleSize);
      if (subProblem != -1 && subProblem + 1 < minCount) {
        minCount = subProblem + 1;

        // TODO: Refactor this part
        if (breakdownList.get(count - bundleSize) == null) {
          breakdownList.set(
              count - bundleSize, new ArrayList<>(Collections.nCopies(bundleSizeList.size(), 0)));
        }
        breakdownList.set(count, new ArrayList<>(breakdownList.get(count - bundleSize)));
        breakdownList.get(count).set(i, breakdownList.get(count).get(i) + 1);
      }
      this.minCountArray[count] = (minCount == Integer.MAX_VALUE ? -1 : minCount);
    }
    return this.minCountArray[count];
  }
}
