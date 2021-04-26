package com.codetest;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor()
public class AllBundleInfo {
    private final HashMap<String, HashMap<Integer, Double>> allBundleInfo = new HashMap<String, HashMap<Integer, Double>>() {
        {
            put("IMG", new HashMap<Integer, Double>(){{put(0, 0.0); put(5, 450.0); put(10, 800.0); }});
            put("Flac", new HashMap<Integer, Double>(){{put(0, 0.0); put(3, 427.50); put(6, 810.0); put(9, 1147.50);}});
            put("VID", new HashMap<Integer, Double>(){{put(0, 0.0); put(3, 570.0); put(5, 900.0); put(9, 1530.0);}});
        }
    };

    public HashMap<Integer, Double> getBundle(String postFormat) {
        return allBundleInfo.get(postFormat);
    }
}
