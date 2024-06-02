package com.codetest.ioprocessors;

import com.codetest.dto.BundleBreakdown;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@RequiredArgsConstructor
public class OutputProcessor {
  public void returnResultInfo(BundleBreakdown bundleBreakdown) {
    log.info(bundleBreakdown.getPostAmount() + " $" + bundleBreakdown.getMinTotalCost());
    bundleBreakdown.getSelectionDetail().stream()
        .filter(str -> str.charAt(0) != '0')
        .forEach(log::info);
  }
}
