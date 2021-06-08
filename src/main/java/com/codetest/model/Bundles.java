package com.codetest.model;

import lombok.Data;

import java.util.List;

@Data
public class Bundles {
    private String formatCode;
    private List<BundleDetails> bundles;

}
