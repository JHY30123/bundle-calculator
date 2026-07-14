package com.codetest.ioprocessors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.codetest.entities.Post;
import com.codetest.enums.Format;
import org.junit.jupiter.api.Test;

public class BundleProcessorTest {

  @Test
  void postParser_withValidLine_returnsPost() {
    Post post = BundleProcessor.postParser("10 IMG");
    assertEquals(10, post.getAmount());
    assertEquals(Format.IMG, post.getFormat());
  }

  @Test
  void postParser_withExtraWhitespace_returnsPost() {
    Post post = BundleProcessor.postParser("  15   flac  ");
    assertEquals(15, post.getAmount());
    assertEquals(Format.FLAC, post.getFormat());
  }

  @Test
  void postParser_withWrongTokenCount_throwsIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> BundleProcessor.postParser("10 IMG extra"));
  }

  @Test
  void postParser_withNonNumericAmount_throwsIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> BundleProcessor.postParser("ten IMG"));
  }

  @Test
  void postParser_withUnknownFormatCode_throwsIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> BundleProcessor.postParser("10 XYZ"));
  }

  @Test
  void postParser_withNullLine_throwsNullPointerException() {
    assertThrows(NullPointerException.class, () -> BundleProcessor.postParser(null));
  }
}
