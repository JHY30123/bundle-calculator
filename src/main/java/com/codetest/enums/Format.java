package com.codetest.enums;

import lombok.Getter;

@Getter
public enum Format {
  IMG("IMG"),
  FLAC("FLAC"),
  VID("VID");

  public final String code;

  Format(String code) {
    this.code = code;
  }
}
