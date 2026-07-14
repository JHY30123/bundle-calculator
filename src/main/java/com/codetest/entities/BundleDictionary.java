package com.codetest.entities;

import com.codetest.enums.Format;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lombok.Data;

/** Hard coded bundle dictionary key - format code value - Map(number, price) */
@Data
public class BundleDictionary {

  private final Map<Integer, BigDecimal> imageBundleMap =
      new TreeMap<>(
          Map.of(
              5, new BigDecimal("450.00"),
              10, new BigDecimal("800.00")));

  private final Map<Integer, BigDecimal> audioBundleMap =
      new TreeMap<>(
          Map.of(
              3, new BigDecimal("427.50"),
              6, new BigDecimal("810.00"),
              9, new BigDecimal("1147.50")));

  private final Map<Integer, BigDecimal> videoBundleMap =
      new TreeMap<>(
          Map.of(
              3, new BigDecimal("570.00"),
              5, new BigDecimal("900.00"),
              9, new BigDecimal("1530.00")));

  private final Map<String, Map<Integer, BigDecimal>> bundleCollection =
      Map.of(
          Format.IMG.code, imageBundleMap,
          Format.FLAC.code, audioBundleMap,
          Format.VID.code, videoBundleMap);

  public Map<Integer, BigDecimal> getBundle(Format format) {
    return bundleCollection.get(format.getCode());
  }

  public List<Integer> getBundleSizeList(Format format) {
    return new ArrayList<>(bundleCollection.get(format.getCode()).keySet());
  }
}
