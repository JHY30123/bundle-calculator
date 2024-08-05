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

  public static boolean isValid(String format) {
    return Arrays.stream(Format.values())
            .anyMatch(fmt -> fmt.code.equals(format));
  }
}
