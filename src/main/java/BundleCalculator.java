import com.codetest.dto.BundleBreakdown;
import com.codetest.dto.Post;
import com.codetest.ioprocessors.InputProcessor;
import com.codetest.ioprocessors.OutputProcessor;
import com.codetest.service.OutputConverter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class BundleCalculator {
  public static void main(String[] args) throws IOException {
    InputProcessor inputProcessor = new InputProcessor();
    OutputConverter outputConverter = new OutputConverter();
    OutputProcessor outputProcessor = new OutputProcessor();
    System.out.println("Please input post amount and format, press enter twice to confirm");

    List<String> inputContent = inputProcessor.getInput();
    List<Post> postFields =
        inputContent.stream().map(InputProcessor::postParser).collect(Collectors.toList());
    List<BundleBreakdown> bundleBreakdowns =
        postFields.stream()
            .map(post -> outputConverter.populateBreakdown(post))
            .collect(Collectors.toList());
    bundleBreakdowns.forEach(bundleBreakdown -> outputProcessor.returnResultInfo(bundleBreakdown));
  }
}
