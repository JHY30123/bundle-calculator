package com.codetest.resources;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

@Data
public class BundleCollection {
  private final Map<String, Map<Integer, BigDecimal>> bundleCollection =
      new HashMap<>() {
        {
          put(
              "IMG",
              new HashMap<>() {
                {
                  put(0, BigDecimal.valueOf(0.0));
                  put(5, BigDecimal.valueOf(450.0));
                  put(10, BigDecimal.valueOf(800.0));
                }
              });
          put(
              "Flac",
              new HashMap<>() {
                {
                  put(0, BigDecimal.valueOf(0.0));
                  put(3, BigDecimal.valueOf(427.50));
                  put(6, BigDecimal.valueOf(810.0));
                  put(9, BigDecimal.valueOf(1147.50));
                }
              });
          put(
              "VID",
              new HashMap<>() {
                {
                  put(0, BigDecimal.valueOf(0.0));
                  put(3, BigDecimal.valueOf(570.0));
                  put(5, BigDecimal.valueOf(900.0));
                  put(9, BigDecimal.valueOf(1530.0));
                }
              });
        }
      };

  public Map<Integer, BigDecimal> getBundle(String format) {
    return this.bundleCollection.get(format);
  }

  public Integer[] getBundleSizeList(Map<Integer, BigDecimal> bundleDetail) {
    return bundleDetail.keySet().toArray(new Integer[0]);
  }

  public BigDecimal[] getBundlePriceList(Map<Integer, BigDecimal> bundleDetail) {
    return bundleDetail.values().toArray(new BigDecimal[0]);
  }
}
