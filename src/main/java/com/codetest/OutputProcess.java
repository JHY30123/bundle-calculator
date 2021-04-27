package com.codetest;

import com.codetest.entities.Output;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import java.util.Arrays;

@Log
@RequiredArgsConstructor
public class OutputProcess {

  public void returnResultInfo(Output output) {
    log.info(output.getPostAmount() + " $" + output.getMinTotalPrice());
    Arrays.stream(output.getBundleSelectionDetail())
        .filter(x -> x != null)
        .forEach(log::info);
  }
}
