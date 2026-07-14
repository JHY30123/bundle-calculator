package com.codetest.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.codetest.enums.Format;
import org.junit.jupiter.api.Test;

public class PostTest {

  @Test
  void builder_withValidValues_buildsPost() {
    Post post = Post.builder().amount(10).format(Format.IMG).build();
    assertEquals(10, post.getAmount());
    assertEquals(Format.IMG, post.getFormat());
  }

  @Test
  void builder_withNegativeAmount_throwsIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Post.builder().amount(-1));
  }

  @Test
  void builder_withNullFormat_throwsIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Post.builder().format(null));
  }
}
