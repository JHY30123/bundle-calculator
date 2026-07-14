package com.codetest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codetest.entities.BundleBreakdown;
import com.codetest.entities.BundleDictionary;
import com.codetest.entities.Post;
import com.codetest.enums.Format;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BreakdownServiceTest {
  private BreakdownService breakdownService;

  @BeforeEach
  void setUp() {
    breakdownService = new BreakdownService(new BundleService(), new BundleDictionary());
  }

  @Test
  void generateBreakdown_withValidPost_returnsCorrectDetails() {
    Post post = Post.builder().amount(10).format(Format.IMG).build();
    List<String> expectedDetails = Arrays.asList("1 x 10 $800.00");
    BundleBreakdown breakdown = breakdownService.generateBreakdown(post);
    assertEquals(expectedDetails, breakdown.getBreakdownDetail());
  }

  @Test
  void generateBreakdown_withValidPost_returnsCorrectBreakdown() {
    Post post = Post.builder().amount(20).format(Format.IMG).build();
    BundleBreakdown breakdown = breakdownService.generateBreakdown(post);
    assertEquals(20, breakdown.getAmount());
    assertEquals(Format.IMG, breakdown.getFormat());
    assertEquals(new BigDecimal("1600.00"), breakdown.getTotalPrice());
    // hardcoded price table
    assertEquals(Arrays.asList("2 x 10 $1600.00"), breakdown.getBreakdownDetail());
  }

  @Test
  void generateBreakdown_withZeroAmount_returnsEmptyBreakdownDetail() {
    Post post = Post.builder().amount(0).format(Format.IMG).build();
    BundleBreakdown breakdown = breakdownService.generateBreakdown(post);
    assertTrue(breakdown.getBreakdownDetail().isEmpty());
  }

  @Test
  void calculatePrice_withValidInputs_returnsCorrectPrice() {
    BigDecimal price = new BigDecimal("5.00");
    int amount = 3;
    BigDecimal expectedPrice = new BigDecimal("15.00");
    BigDecimal actualPrice = breakdownService.calculatePrice(price, amount);
    assertEquals(expectedPrice, actualPrice);
  }
}
