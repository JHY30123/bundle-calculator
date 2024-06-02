package com.codetest.service;

import com.codetest.dto.BundleBreakdown;
import com.codetest.dto.Post;
import com.codetest.resources.Bundle;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class OutputConverter {
  Bundle bundle = new Bundle();
  BundleSelector bundleSelector = new BundleSelector();

  public BundleBreakdown populateBreakdown(Post post) {
    BundleBreakdown bundleBreakdown =
        BundleBreakdown.builder()
            .postAmount(post.getAmount())
            .postFormat(post.getFormat())
            .minTotalCost(
                bundleSelector.totalPriceCalculator(
                    bundle.getBundlePriceList(
                        bundle.getBundle(post.getFormat())),
                    bundleSelector.calculateBundlePlan(
                        bundle.getBundleSizeList(
                            bundle.getBundle(post.getFormat())),
                        post.getAmount())))
            .selectionDetail(
                setSelectionDetailList(
                    bundleSelector.calculateBundlePlan(
                        bundle.getBundleSizeList(
                            bundle.getBundle(post.getFormat())),
                        post.getAmount()),
                    bundle.getBundlePriceList(
                        bundle.getBundle(post.getFormat()))))
            .build();
    return bundleBreakdown;
  }

  private List<String> setSelectionDetailList(List<Integer> bundlePlan, List<BigDecimal> bundlePriceList) {
    return IntStream.range(1, Math.max(bundlePlan.size(), bundlePriceList.size()))
        .mapToObj(i -> bundlePlan.get(i) + "* $" + bundlePriceList.get(i))
        .collect(Collectors.toList());
  }
}
