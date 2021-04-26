package com.codetest;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultInfo {
    private int postAmount;
    private String postFormat;
    private double minTotalPrice;
    private String[] bundleSelectionDetail;
}
