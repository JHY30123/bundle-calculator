package com.codetest.fields;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Input {
  private int postAmount;
  private String postFormat;
}
