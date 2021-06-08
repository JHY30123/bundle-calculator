import com.codetest.IOProcess.OutputProcessor;
import com.codetest.converter.OutputConverter;
import com.codetest.model.BundleSelection;
import com.codetest.model.Order;
import com.codetest.ioprocessors.InputProcessor;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.java.Log;

@Log
public class Main {
  public static void main(String[] args) throws IOException {
    InputProcessor inputProcessor = new InputProcessor();
    OutputConverter outputConverter = new OutputConverter();
    OutputProcessor outputProcessor = new OutputProcessor();
    System.out.println("Please input posts amount and format, press enter twice to confirm");

    List<String> inputContent = inputProcessor.getInput();
    List<Order> orderFields =
        inputContent.stream().map(InputProcessor::inputConvert).collect(Collectors.toList());
    List<BundleSelection> bundleSelections =
        orderFields.stream()
            .map(order -> outputConverter.setOutputFormat(order))
            .collect(Collectors.toList());
    bundleSelections.forEach(bundleSelection -> outputProcessor.returnResultInfo(bundleSelection));
  }
}
