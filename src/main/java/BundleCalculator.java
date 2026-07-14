import com.codetest.entities.BundleBreakdown;
import com.codetest.entities.BundleDictionary;
import com.codetest.entities.Post;
import com.codetest.ioprocessors.BundleProcessor;
import com.codetest.service.BreakdownService;
import com.codetest.service.BundleService;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class BundleCalculator {
  private static final Logger log = Logger.getLogger(BundleCalculator.class.getName());

  public static void main(String[] args) {
    BundleProcessor bundleProcessor = new BundleProcessor();
    BreakdownService breakdownService =
        new BreakdownService(new BundleService(), new BundleDictionary());
    log.info("Please input post number and format, press enter twice to confirm");

    try {
      List<String> inputContent = bundleProcessor.getInput();
      inputContent.stream()
          .map(line -> parseAndBreakdown(line, breakdownService))
          .filter(Objects::nonNull)
          .forEach(bundleBreakdown -> log.info(bundleBreakdown.toString()));
    } catch (IOException e) {
      log.severe("Error reading input");
    }
  }

  private static BundleBreakdown parseAndBreakdown(String line, BreakdownService breakdownService) {
    try {
      Post post = BundleProcessor.postParser(line);
      return breakdownService.generateBreakdown(post);
    } catch (IllegalArgumentException e) {
      log.severe("Skipping invalid line '" + line + "': " + e.getMessage());
      return null;
    }
  }
}
