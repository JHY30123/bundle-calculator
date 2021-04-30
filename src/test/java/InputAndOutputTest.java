import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codetest.converter.OutputConverter;
import com.codetest.fields.Input;
import com.codetest.fields.Output;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InputAndOutputTest {

  @Test
  public void testOutputConverter() {
    Input input = Input.builder().postAmount(12).postFormat("IMG").build();
    OutputConverter outputConverter = new OutputConverter();

    List<String> selectionDetails = Arrays.asList("2* $450.0", "0* $800.0");
    Output output = outputConverter.setOutputFormat(input);

    Output outputExpect =
        Output.builder()
            .postAmount(12)
            .postFormat("IMG")
            .bundleSelectionDetail(selectionDetails)
            .minTotalPrice(BigDecimal.valueOf(900.0))
            .build();
    assertEquals(outputExpect, output);
  }
}
