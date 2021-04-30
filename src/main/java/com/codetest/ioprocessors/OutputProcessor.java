package com.codetest.IOProcess;

import com.codetest.fields.Output;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@RequiredArgsConstructor
public class OutputProcessor {
  public void returnResultInfo(Output output) {
    log.info(output.getPostAmount() + " $" + output.getMinTotalPrice());
    output.getBundleSelectionDetail().stream()
        .filter(str -> str.charAt(0) != '0')
        .forEach(log::info);
  }
}
