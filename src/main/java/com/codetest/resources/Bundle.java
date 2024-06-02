package com.codetest.resources;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class Bundle {
  private final HashMap<String, HashMap<Integer, BigDecimal>> bundleCollection =
      new HashMap<>() {
        {
          put(Format.IMAGE.code, imageBundleMap);
          put(Format.AUDIO.code, audioBundleMap);
          put(Format.VIDEO.code, videoBundleMap);
        }
      };

  private final HashMap<Integer, BigDecimal> imageBundleMap =
      new HashMap<>() {
        {
          put(0, BigDecimal.valueOf(0.0));
          put(5, BigDecimal.valueOf(450.0));
          put(10, BigDecimal.valueOf(800.0));
        }
      };
  private final HashMap<Integer, BigDecimal> audioBundleMap =
      new HashMap<>() {
        {
          put(0, BigDecimal.valueOf(0.0));
          put(3, BigDecimal.valueOf(427.50));
          put(6, BigDecimal.valueOf(810.0));
          put(9, BigDecimal.valueOf(1147.50));
        }
      };
  private final HashMap<Integer, BigDecimal> videoBundleMap =
      new HashMap<>() {
        {
          put(0, BigDecimal.valueOf(0.0));
          put(3, BigDecimal.valueOf(570.0));
          put(5, BigDecimal.valueOf(900.0));
          put(9, BigDecimal.valueOf(1530.0));
        }
      };

    public HashMap<Integer, BigDecimal> getBundle(Format formatCode) {
      return bundleCollection.get(formatCode.name());
    }

    public List<Integer> getBundleSizeList(Map<Integer, BigDecimal> bundleDetail) {
      return new ArrayList<>(bundleDetail.keySet());
    }

    public List<BigDecimal> getBundlePriceList(Map<Integer, BigDecimal> bundleDetail) {
      return new ArrayList<>(bundleDetail.values());
    }
}
