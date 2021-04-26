package com.codetest;

import lombok.Data;
import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.HashMap;

@Data
@Log
public class BundleCalculator {
    AllBundleInfo allBundleInfo = new AllBundleInfo();

    public ResultInfo minPriceCalculator(BundleInfo bundleInfo) {
        ResultInfo resultInfo = new ResultInfo();
        if(bundleInfo.getPostAmount() == 0) return resultInfo;

        HashMap<Integer, Double> priceTable = new HashMap<Integer, Double>(allBundleInfo.getBundle(bundleInfo.getPostFormat()));

        //Knapsack liked variables claim way
        double[][] pricePath = new double[priceTable.size()][bundleInfo.getPostAmount() + 1];
        for(double[] row: pricePath)
            Arrays.fill(row, Double.POSITIVE_INFINITY);

        int[] bundleSize =  priceTable.keySet().stream().sorted().mapToInt(x -> Integer.valueOf(x)).toArray();
        double[] bundlePrice = priceTable.values().stream().sorted().mapToDouble(x -> Double.valueOf(x)).toArray();

        // dp process of Reversed Knapsack Problem
        for(int i = 1; i <= priceTable.size() - 1; i ++) {
            for(int j = 1; j <= bundleInfo.getPostAmount(); j ++) {
                pricePath[i][j] = Math.min(pricePath[i][j],pricePath[i - 1][j]);
                if(j <= bundleSize[i]) pricePath[i][j] = Math.min(pricePath[i][j], bundlePrice[i]);
                else pricePath[i][j] = Math.min(pricePath[i][j], pricePath[i][j - bundleSize[i]] + bundlePrice[i]);
            }
        }
        resultInfo.setMinTotalPrice(pricePath[priceTable.size() - 1][bundleInfo.getPostAmount()]);

        //Decoding best solution
        int vol = bundleInfo.getPostAmount();
        String[] bundleDetails = new String[priceTable.size()];
        for(int i = priceTable.size() - 1; i >= 1; i --) {
            int count = 0;
            if(pricePath[i][vol] != pricePath[i - 1][vol]) {
                vol -= bundleSize[i];
                bundleDetails[i] = (++ count + "* $" + bundlePrice[i]);
                while(vol >= bundleSize[i] && pricePath[i][vol] != pricePath[i - 1][vol]) {
                    bundleDetails[i] = (++ count + "* $" + bundlePrice[i]);
                    vol -= bundleSize[i];
                }
            }
        }

        resultInfo.setPostFormat(bundleInfo.getPostFormat());
        resultInfo.setPostAmount(bundleInfo.getPostAmount());
        resultInfo.setBundleSelectionDetail(bundleDetails);
        return resultInfo;
    }
}
