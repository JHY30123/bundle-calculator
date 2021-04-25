package com.codetest;

//import lombok.extern.java.Log;

import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.HashMap;

@Log
public class Bundle {

    private String format;
    private int quantity;

    private final HashMap<String, HashMap<Integer, Double>> formatAndPackage = new HashMap<String, HashMap<Integer, Double>>() {
        {
            put("IMG", new HashMap<Integer, Double>(){{put(0, Double.POSITIVE_INFINITY); put(5, 450.0); put(10, 800.0); }});
            put("Flac", new HashMap<Integer, Double>(){{put(0, Double.POSITIVE_INFINITY); put(3, 427.50); put(6, 810.0); put(9, 1147.50);}});
            put("VID", new HashMap<Integer, Double>(){{put(0, Double.POSITIVE_INFINITY); put(3, 570.0); put(5, 900.0); put(9, 1530.0);}});
        }
    };

    private HashMap<Integer, Double> getPriceTable() {
        return formatAndPackage.get(this.format);
    }

    public Bundle(int quantity, String format) {
        this.quantity = quantity;
        this.format = format;
    }

    public Double totalPriceCalculator() {
        if(this.quantity == 0) return 0.0;

        HashMap<Integer, Double> priceTable = getPriceTable();
        int[] state = new int[priceTable.size()];

        //Knapsack liked variables claim way
        double[][] price = new double[priceTable.size()][this.quantity + 1];
        for(double[] row: price)
            Arrays.fill(row, Double.POSITIVE_INFINITY);

        int[] volume =  priceTable.keySet().stream().mapToInt(x -> Integer.valueOf(x)).toArray();
        double[] weight = priceTable.values().stream().mapToDouble(x -> Double.valueOf(x)).toArray();

        // dp process of Reversed Knapsack Problem
        for(int i = 1; i <= priceTable.size() - 1; i ++) {
            for(int j = 1; j <= quantity; j ++) {
                price[i][j] = Math.min(price[i][j],price[i - 1][j]);
                if(j <= volume[i]) price[i][j] = Math.min(price[i][j], weight[i]);
                else price[i][j] = Math.min(price[i][j], price[i][j - volume[i]] + weight[i]);
            }
        }
        //Decoding best solution
        int vol = quantity;
        for(int i = priceTable.size() - 1; i >= 1; i --) {
            double priceOld = price[i][vol];
            if(price[i][vol] != price[i - 1][vol]) {
                vol -= volume[i];
                if(price[i][vol] == priceOld) log.info(i - 1 + " * $" + weight[i]);
                else log.info(i + "* $ " + weight[i]);
            }
        }
        return price[priceTable.size() - 1][quantity];
    }
}
