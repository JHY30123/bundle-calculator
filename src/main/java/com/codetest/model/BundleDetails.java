package com.codetest.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BundleDetails {
    private int quantity;
    private BigDecimal price;
}
