import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codetest.service.BundleSelector;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BundleSelectorTest {
  BundleSelector bundleSelector = new BundleSelector();

  @Test
  public void totalPriceTest() {
    List<BigDecimal> priceList = Arrays.asList(BigDecimal.ZERO, BigDecimal.valueOf(570), BigDecimal.valueOf(900), BigDecimal.valueOf(1530));
    List<Integer> plan = Arrays.asList(0, 0, 1, 1);
    BigDecimal target = BigDecimal.valueOf(2430);
    assertEquals(target, bundleSelector.totalPriceCalculator(priceList, plan));
  }

  @Test
  public void getBundlePlanTestOnVID11() {
    List<Integer> bundleSizeList = Arrays.asList(0, 3, 5, 9);
    int amount = 11;
    List<Integer> target = Arrays.asList(null, 2, 1, null);
    assertEquals(target, bundleSelector.calculateBundlePlan(bundleSizeList, amount));
  }

  @Test
  public void getBundlePlanWithWhileLoopUsedInPathTraceBack() {
    List<Integer> sizeList = Arrays.asList(0, 3, 5, 9);
    int amount = 13;
    List<Integer> target = Arrays.asList(null, 1, 2, null);
    assertEquals(target, this.bundleSelector.calculateBundlePlan(sizeList, amount));
  }
}
