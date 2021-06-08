package com.codetest.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
  private int postAmount;
  private String postFormat;
}
