import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codetest.dto.BundleBreakdown;
import com.codetest.dto.Post;
import com.codetest.resources.Format;
import com.codetest.service.OutputConverter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PostAndBundleBreakdownTest {

  @Test
  public void testOutputConverter() {
    Post post = Post.builder().amount(12).format(Format.IMAGE).build();
    OutputConverter outputConverter = new OutputConverter();

    List<String> selectionDetails = Arrays.asList("2* $450.0", "0* $800.0");
    BundleBreakdown bundleBreakdown = outputConverter.populateBreakdown(post);

    BundleBreakdown bundleBreakdownExpect =
        BundleBreakdown.builder()
            .postAmount(12)
            .postFormat(Format.IMAGE)
            .selectionDetail(selectionDetails)
            .minTotalCost(BigDecimal.valueOf(900.0))
            .build();
    assertEquals(bundleBreakdownExpect, bundleBreakdown);
  }
}
