package com.codetest.service;

import com.codetest.entities.BundleBreakdown;
import com.codetest.entities.Post;
import com.codetest.entities.BundleDictionary;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class BreakdownService {
    BundleService bundleService = new BundleService();
    BundleDictionary bundleDictionary = new BundleDictionary();

    // TODO: Calculate the total price in a better way
    BigDecimal totalPrice = BigDecimal.ZERO;

    private List<Integer> calculateBundlePlan(Post post) {
        List<Integer> bundleSizeList = bundleDictionary.getBundleSizeList(post.getFormat());
        return bundleService.generateSelection(bundleSizeList, post.getAmount());
    }

    public List<String> generateBreakDownDetail(Post post) {
        List<String> bundleDetail = new ArrayList<>();
        List<Integer> selectionList = calculateBundlePlan(post);
        Map<Integer, BigDecimal> bundleDetailMap = new TreeMap<>(bundleDictionary.getBundle(post.getFormat()));
        List<Entry<Integer, BigDecimal>> entryList = new ArrayList<>(bundleDetailMap.entrySet());

        for(int i = 0; i < selectionList.size(); i++) {
            bundleDetail.add(selectionList.get(i) + " x " + entryList.get(i).getKey() + " $" + calculatePrice(entryList.get(i).getValue(), selectionList.get(i)));
        }
        return bundleDetail;
    }

    public BundleBreakdown generateBreakdownList(Post post) {
        List<String> breakdownDetail = generateBreakDownDetail(post);
        BundleBreakdown bundleBreakdown = BundleBreakdown.builder()
                .number(post.getAmount())
                .format(post.getFormat())
                .totalPrice(totalPrice)
                .breakdownDetail(breakdownDetail)
                .build();
        return bundleBreakdown;
    }

    public BigDecimal calculatePrice(BigDecimal price, int amount) {
        return price.multiply(new BigDecimal(amount));
    }
}
