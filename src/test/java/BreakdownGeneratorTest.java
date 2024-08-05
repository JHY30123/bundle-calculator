import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codetest.enums.Format;
import com.codetest.service.BreakdownGenerator;
import com.codetest.vo.BundleBreakdown;
import com.codetest.vo.Post;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BreakdownGeneratorTest {
  private BreakdownGenerator breakdownGenerator = new BreakdownGenerator();
  private Post post;

  @BeforeEach
  void setUp() {
    breakdownGenerator = new BreakdownGenerator();
    post = new Post();
    post.setFormat(Format.valueOf("IMG"));
    post.setAmount(10);
  }

  @Test
  void generateBreakDownDetail_withValidPost_returnsCorrectDetails() {
    List<String> expectedDetails = Arrays.asList("0 x 5 $0.0", "1 x 10 $800.0");
    List<String> actualDetails = breakdownGenerator.generateBreakDownDetail(post);
    assertEquals(expectedDetails, actualDetails);
  }

  @Test
  void generateBreakdownList_withValidPost_returnsCorrectBreakdown() {
    post.setFormat(Format.IMG);
    post.setAmount(20);
    BundleBreakdown breakdown = breakdownGenerator.generateBreakdownList(post);
    assertEquals(20, breakdown.getNumber());
    assertEquals(Format.IMG, breakdown.getFormat());
    assertEquals(BigDecimal.ZERO, breakdown.getTotalPrice());
    // hardcoded price table
    assertEquals(Arrays.asList("0 x 5 $0.0", "2 x 10 $1600.0"), breakdown.getBreakdownDetail());
  }

  @Test
  void generateBreakdownList_withZeroAmount_returnsEmptyBreakdownDetail() {
    post.setAmount(0);
    BundleBreakdown breakdown = breakdownGenerator.generateBreakdownList(post);
    assertTrue(breakdown.getBreakdownDetail().isEmpty());
  }

  @Test
  void calculatePrice_withValidInputs_returnsCorrectPrice() {
    BigDecimal price = new BigDecimal("5.00");
    int amount = 3;
    BigDecimal expectedPrice = new BigDecimal("15.00");
    BigDecimal actualPrice = breakdownGenerator.calculatePrice(price, amount);
    assertEquals(expectedPrice, actualPrice);
  }
}
