package com.codetest.converter;

import com.codetest.BundleCalculator;
import com.codetest.config.BundlesConfig;
import com.codetest.model.Order;
import com.codetest.model.BundleSelection;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.Data;
import lombok.extern.java.Log;

@Data
@Log
public class OutputConverter {

  BundlesConfig bundlesConfig = new BundlesConfig();
  BundleCalculator bundleCalculator = new BundleCalculator();

  public BundleSelection setOutputFormat(Order order) {
    BundleSelection bundleSelection =
        BundleSelection.builder()
            .postAmount(order.getPostAmount())
            .postFormat(order.getPostFormat())
            .minTotalPrice(
                bundleCalculator.totalPriceCalculator(
                        bundlesConfig.getBundlePriceList(
                        this.bundlesConfig.getBundle(order.getPostFormat())),
                    this.bundleCalculator.getBundlePlan(
                        this.bundlesConfig.getBundleSizeList(
                            this.bundlesConfig.getBundle(order.getPostFormat())),
                        order.getPostAmount())))
            .bundleSelectionDetail(
                setSelectionDetailList(
                    this.bundleCalculator.getBundlePlan(
                        this.bundlesConfig.getBundleSizeList(
                            this.bundlesConfig.getBundle(order.getPostFormat())),
                        order.getPostAmount()),
                    this.bundlesConfig.getBundlePriceList(
                        this.bundlesConfig.getBundle(order.getPostFormat()))))
            .build();
    return bundleSelection;
  }

  private List<String> setSelectionDetailList(int[] bundlePlan, BigDecimal[] bundlePriceList) {
    return IntStream.range(1, Math.max(bundlePlan.length, bundlePriceList.length))
        .mapToObj(i -> bundlePlan[i] + "* $" + bundlePriceList[i])
        .collect(Collectors.toList());
  }
}
