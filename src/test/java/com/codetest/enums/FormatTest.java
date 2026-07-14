package com.codetest.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class FormatTest {

  @Test
  void fromCode_withKnownCode_returnsMatchingFormat() {
    assertEquals(Format.IMG, Format.fromCode("IMG"));
    assertEquals(Format.FLAC, Format.fromCode("flac"));
    assertEquals(Format.VID, Format.fromCode("Vid"));
  }

  @Test
  void fromCode_withUnknownCode_throwsIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Format.fromCode("XYZ"));
  }
}
