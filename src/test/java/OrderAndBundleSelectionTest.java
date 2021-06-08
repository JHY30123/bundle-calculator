import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codetest.converter.OutputConverter;
import com.codetest.model.BundleSelection;
import com.codetest.model.Order;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class OrderAndBundleSelectionTest {

  @Test
  public void testOutputConverter() {
    Order order = Order.builder().postAmount(12).postFormat("IMG").build();
    OutputConverter outputConverter = new OutputConverter();

    List<String> selectionDetails = Arrays.asList("2* $450.0", "0* $800.0");
    BundleSelection bundleSelection = outputConverter.setOutputFormat(order);

    BundleSelection bundleSelectionExpect =
        BundleSelection.builder()
            .postAmount(12)
            .postFormat("IMG")
            .bundleSelectionDetail(selectionDetails)
            .minTotalPrice(BigDecimal.valueOf(900.0))
            .build();
    assertEquals(bundleSelectionExpect, bundleSelection);
  }
}
