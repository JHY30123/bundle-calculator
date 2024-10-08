import com.codetest.entities.BundleBreakdown;
import com.codetest.entities.Post;
import com.codetest.ioprocessors.BundleProcessor;
import com.codetest.service.BreakdownService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class BundleCalculator {
  private static final Logger log = Logger.getLogger(BundleCalculator.class.getName());

  public static void main(String[] args) {
    BundleProcessor bundleProcessor = new BundleProcessor();
    BreakdownService breakdownService = new BreakdownService();
    log.info("Please input post number and format, press enter twice to confirm");

    try {
      List<String> inputContent = bundleProcessor.getInput();
      List<Post> postList =
          inputContent.stream().map(BundleProcessor::postParser).collect(Collectors.toList());
      List<BundleBreakdown> bundleBreakdownList =
          postList.stream()
              .map(breakdownService::generateBreakdownList)
              .collect(Collectors.toList());
      bundleBreakdownList.forEach(bundleBreakdown -> log.info(bundleBreakdown.toString()));
    } catch (IOException e) {
      log.severe("Error reading input");
    } catch (IllegalArgumentException e) {
      log.severe("Invalid format");
    }
  }

}
