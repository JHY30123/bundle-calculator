package com.codetest.vo;

import com.codetest.enums.Format;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
  private int amount;
  private Format format;
}
