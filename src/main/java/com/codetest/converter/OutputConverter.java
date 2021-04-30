package com.codetest.converter;

import com.codetest.BundleCalculator;
import com.codetest.fields.Input;
import com.codetest.fields.Output;
import com.codetest.resources.BundleCollection;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.Data;
import lombok.extern.java.Log;

@Data
@Log
public class OutputConverter {

  BundleCollection bundleCollection = new BundleCollection();
  BundleCalculator bundleCalculator = new BundleCalculator();

  public Output setOutputFormat(Input input) {
    Output output =
        Output.builder()
            .postAmount(input.getPostAmount())
            .postFormat(input.getPostFormat())
            .minTotalPrice(
                this.bundleCalculator.totalPriceCalculator(
                    this.bundleCollection.getBundlePriceList(
                        this.bundleCollection.getBundle(input.getPostFormat())),
                    this.bundleCalculator.getBundlePlan(
                        this.bundleCollection.getBundleSizeList(
                            this.bundleCollection.getBundle(input.getPostFormat())),
                        input.getPostAmount())))
            .bundleSelectionDetail(
                setSelectionDetailList(
                    this.bundleCalculator.getBundlePlan(
                        this.bundleCollection.getBundleSizeList(
                            this.bundleCollection.getBundle(input.getPostFormat())),
                        input.getPostAmount()),
                    this.bundleCollection.getBundlePriceList(
                        this.bundleCollection.getBundle(input.getPostFormat()))))
            .build();
    return output;
  }

  private List<String> setSelectionDetailList(int[] bundlePlan, BigDecimal[] bundlePriceList) {
    return IntStream.range(1, Math.max(bundlePlan.length, bundlePriceList.length))
        .mapToObj(i -> bundlePlan[i] + "* $" + bundlePriceList[i])
        .collect(Collectors.toList());
  }
}
