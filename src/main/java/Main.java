import com.codetest.mapper.OutputMapper;
import com.codetest.entities.Input;
import lombok.extern.java.Log;

import java.io.IOException;

@Log
public class Main {

  public static void main(String[] args) throws IOException {
    //    InputProcess inputProcess = new InputProcess();
    //    OutputProcess outputProcess = new OutputProcess();
    //    BundleCalculator bundleCalculator = new BundleCalculator();
    //    System.out.println("Please input posts amount and format, press enter twice to" +
    // "confirm");
    //    List<String> inputContent = inputProcess.getInput();
    //    List<Input> inputFields =
    //
    // inputContent.stream().map(InputProcess::inputFormatConvert).collect(Collectors.toList());
    //    List<Output> resultInfos =
    //        inputFields.stream()
    //            .map(bundleCalculator::getMinBundleSelection)
    //            .collect(Collectors.toList());
    //    resultInfos.forEach(outputProcess::returnResultInfo);
    //  }
    Input input = new Input();
    input.setPostFormat("VID");
    input.setPostAmount(10);
    OutputMapper outputMapper = new OutputMapper();
    System.out.println(outputMapper.getMinBundleSelection(input));
  }
}
