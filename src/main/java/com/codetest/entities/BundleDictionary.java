package com.codetest.entities;

import com.codetest.enums.Format;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lombok.Data;

/** Hard coded bundle dictionary key - format code value - Map(number, price) */
@Data
public class BundleDictionary {

  private final Map<Integer, BigDecimal> imageBundleMap =
      new TreeMap<>() {
        {
          put(5, BigDecimal.valueOf(450.0));
          put(10, BigDecimal.valueOf(800.0));
        }
      };

  private final Map<Integer, BigDecimal> audioBundleMap =
      new TreeMap<>() {
        {
          put(3, BigDecimal.valueOf(427.50));
          put(6, BigDecimal.valueOf(810.0));
          put(9, BigDecimal.valueOf(1147.50));
        }
      };
  private final Map<Integer, BigDecimal> videoBundleMap =
      new TreeMap<>() {
        {
          put(3, BigDecimal.valueOf(570.0));
          put(5, BigDecimal.valueOf(900.0));
          put(9, BigDecimal.valueOf(1530.0));
        }
      };

  private final Map<String, Map<Integer, BigDecimal>> bundleCollection =
      new HashMap<>() {
        {
          put(Format.IMG.code, imageBundleMap);
          put(Format.FLAC.code, audioBundleMap);
          put(Format.VID.code, videoBundleMap);
        }
      };

  public Map<Integer, BigDecimal> getBundle(Format formatCode) {
    return bundleCollection.get(formatCode.name());
  }

  public List<Integer> getBundleSizeList(Format format) {
    return new ArrayList<>(bundleCollection.get(format.getCode()).keySet());
  }
}
