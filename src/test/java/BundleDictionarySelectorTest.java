import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codetest.service.BundleSelector;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BundleDictionarySelectorTest {
  BundleSelector bundleSelector = new BundleSelector();

  @Test
  void calculateBundle_ReturnsCorrectBundlePlan_ForValidNumber() {
    List<Integer> bundleSizeList = Arrays.asList(1, 2, 3);
    int amount = 5;
    List<Integer> result = bundleSelector.generateSelection(bundleSizeList, amount);
    assertEquals(Arrays.asList(0, 1, 1), result); // 2 bundles of size 2 and 1 bundle of size 1
  }

  @Test
  void calculateBundle_ReturnsEmptyList_ForEmptyBundleSizeList() {
    List<Integer> bundleSizeList = Arrays.asList();
    int amount = 5;
    List<Integer> result = bundleSelector.generateSelection(bundleSizeList, amount);
    assertEquals(Arrays.asList(), result);
  }

  @Test
  void calculateBundle_ReturnsCorrectBundlePlan_ForLargeAmount() {
    List<Integer> bundleSizeList = Arrays.asList(1, 2, 3, 5, 10);
    int amount = 23;
    List<Integer> result = bundleSelector.generateSelection(bundleSizeList, amount);
    assertEquals(Arrays.asList(0, 0, 1, 0, 2), result); // 2 bundles of size 10 and 1 bundle of size 3
  }
}
