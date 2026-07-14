package com.codetest.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Format {
  IMG("IMG"),
  FLAC("FLAC"),
  VID("VID");

  public final String code;

  Format(String code) {
    this.code = code;
  }

  public static Format fromCode(String code) {
    return Arrays.stream(values())
            .filter(f -> f.code.equalsIgnoreCase(code))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Unknown format code: '" + code + "'"));
  }
}
