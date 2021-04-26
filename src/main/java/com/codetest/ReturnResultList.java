package com.codetest;

import lombok.extern.java.Log;

import java.util.Arrays;

@Log
public class ReturnResultList {
    public void returnResultInfo(ResultInfo resultInfo) {
        log.info(resultInfo.getPostAmount() + " $" + resultInfo.getMinTotalPrice());
        Arrays.stream(resultInfo.getBundleSelectionDetail()).filter(x -> x != null).forEach(log::info);
    }
}
