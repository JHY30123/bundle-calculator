package com.codetest.resources;

import lombok.Getter;

@Getter
public enum Format {
  IMAGE("IMG"),
  AUDIO("Flac"),
  VIDEO("VID");
  public final String code;

  Format(String code) {
    this.code = code;
  }
}
