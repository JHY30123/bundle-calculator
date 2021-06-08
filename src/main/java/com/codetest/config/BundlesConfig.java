package com.codetest.config;

import com.codetest.model.Bundles;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paranamer.ParanamerModule;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BundlesConfig {
    private Map<String, Bundles> bundlesMap;

    public Map<String, Bundles> getBundlesMap() throws IOException {
        if (bundlesMap == null) {
            bundlesMap = load();
        }
        return bundlesMap;
    }

    //  public Integer[] getBundleSizeList(Map<Integer, BigDecimal> bundleDetail) {
//    return bundleDetail.keySet().toArray(new Integer[0]);
//  }

    private Map<String, Bundles> load() throws IOException {
        String fileName = "bundles.json";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        String content = new String(Files.readAllBytes(file.toPath()));

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new ParanamerModule());

        List<Bundles> bundlesList = mapper.readValue(content, new TypeReference<>() {});

        return bundlesList.stream()
                .collect(Collectors.toMap(Bundles::getFormatCode, bundles -> bundles));

    }
}
