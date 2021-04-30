import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codetest.BundleCalculator;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class BundleCalculatorTest {
  BundleCalculator bundleCalculator = new BundleCalculator();

  @Test
  public void totalPriceTest() {
    BigDecimal[] priceList = {
      BigDecimal.ZERO, BigDecimal.valueOf(570), BigDecimal.valueOf(900), BigDecimal.valueOf(1530)
    };
    int[] plan = {0, 0, 1, 1};
    BigDecimal target = BigDecimal.valueOf(2430);
    assertEquals(target, this.bundleCalculator.totalPriceCalculator(priceList, plan));
  }

  @Test
  public void getBundlePlanTestOnVID11() {
    Integer[] bundleSizeList = {0, 3, 5, 9};
    int amount = 11;
    int[] target = {0, 2, 1, 0};
    assertArrayEquals(target, this.bundleCalculator.getBundlePlan(bundleSizeList, amount));
  }

  @Test
  public void getBundlePlanWithWhileLoopUsedInPathTraceBack() {
    Integer[] sizeList = {0, 3, 5, 9};
    int amount = 13;
    int[] target = {0, 1, 2, 0};
    assertArrayEquals(target, this.bundleCalculator.getBundlePlan(sizeList, amount));
  }
}
