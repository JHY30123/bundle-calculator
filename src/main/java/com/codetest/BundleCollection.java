package com.codetest;

import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
public class BundleCollection {
  private final Map<String, Map<Integer, BigDecimal>> BundleCollection =
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
}
