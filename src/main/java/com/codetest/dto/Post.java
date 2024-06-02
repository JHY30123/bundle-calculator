package com.codetest.dto;

import com.codetest.resources.Format;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Post {
  private int amount;
  private Format format;
}
