package com.codetest.IOProcess;

import com.codetest.model.BundleSelection;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@RequiredArgsConstructor
public class OutputProcessor {
  public void returnResultInfo(BundleSelection bundleSelection) {
    log.info(bundleSelection.getPostAmount() + " $" + bundleSelection.getMinTotalPrice());
    bundleSelection.getBundleSelectionDetail().stream()
        .filter(str -> str.charAt(0) != '0')
        .forEach(log::info);
  }
}
