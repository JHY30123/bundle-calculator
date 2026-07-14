import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codetest.entities.BundleBreakdown;
import com.codetest.entities.Post;
import com.codetest.enums.Format;
import com.codetest.service.BreakdownService;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BreakdownServiceTest {
  private BreakdownService breakdownService = new BreakdownService();
  private Post post;

  @BeforeEach
  void setUp() {
    breakdownService = new BreakdownService();

  }

  @Test
  void generateBreakdownList_withValidPost_returnsCorrectDetails() {
    Post post = Post.builder().amount(10).format(Format.IMG).build();
    List<String> expectedDetails = Arrays.asList("1 x 10 $800.0");
    BundleBreakdown breakdown = breakdownService.generateBreakdownList(post);
    assertEquals(expectedDetails, breakdown.getBreakdownDetail());
  }

  @Test
  void generateBreakdownList_withValidPost_returnsCorrectBreakdown() {
    Post post = Post.builder().amount(20).format(Format.IMG).build();
    BundleBreakdown breakdown = breakdownService.generateBreakdownList(post);
    assertEquals(20, breakdown.getNumber());
    assertEquals(Format.IMG, breakdown.getFormat());
    assertEquals(BigDecimal.valueOf(1600.0), breakdown.getTotalPrice());
    // hardcoded price table
    assertEquals(Arrays.asList("2 x 10 $1600.0"), breakdown.getBreakdownDetail());
  }

  @Test
  void generateBreakdownList_withZeroAmount_returnsEmptyBreakdownDetail() {
    Post post = Post.builder().amount(0).format(Format.IMG).build();
    BundleBreakdown breakdown = breakdownService.generateBreakdownList(post);
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
