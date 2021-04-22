package com.codetest;

import java.util.HashMap;

public class Bundle {

    private String format;
    private int quantity;
    private final HashMap<String, HashMap<Integer, Double>> formatAndPackage = new HashMap<String, HashMap<Integer, Double>>() {
        {
            put("IMG", new HashMap<Integer, Double>(){{put(5, 450.0); put(10, 800.0); }});
            put("Flac", new HashMap<Integer, Double>(){{put(3, 427.50); put(6, 810.0); put(9, 1147.50);}});
            put("VID", new HashMap<Integer, Double>(){{put(3, 570.0); put(5, 900.0); put(9, 1530.0);}});
        }
    };

    public Bundle(int quantity, String format) {
        this.quantity = quantity;
        this.format = format;
    }

    private HashMap<Integer, Double> getPriceTable() {
        return formatAndPackage.get(this.format);
    }

    private Double bundleCalculator() {
        HashMap<Integer, Double> priceTable = getPriceTable();

        //Knapsack liked variables claim
        double[][] price = new double[priceTable.size() + 1][priceTable.size() + 1];

        int[] volume =  priceTable.keySet().stream().mapToInt(x -> Integer.valueOf(x)).toArray();
        double[] weight = priceTable.values().stream().mapToDouble(x -> Double.valueOf(x)).toArray();

        // Core Algorithm of Reversed Knapsack Problem
        // TODO:
        // 1. How to handle the case the array starts from 0 instead of 1.
        // 2. How to maintain best selection array.
        // 3. How to reverse knapsack problem.

//        for(int i = 1; i <= priceTable.size(); i ++){
//            for(int j = 1; j <= quantity; j ++){
//                f[i][j] = f[i -1][j];
//                if(j <= v[i]) f[i][j] =
//            }
//        }
        return price[priceTable.size()][quantity];
    }
}
