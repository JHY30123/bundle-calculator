import com.codetest.IOProcess.OutputProcessor;
import com.codetest.converter.OutputConverter;
import com.codetest.fields.Input;
import com.codetest.fields.Output;
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
    List<Input> inputFields =
        inputContent.stream().map(InputProcessor::inputConvert).collect(Collectors.toList());
    List<Output> outputs =
        inputFields.stream()
            .map(input -> outputConverter.setOutputFormat(input))
            .collect(Collectors.toList());
    outputs.forEach(output -> outputProcessor.returnResultInfo(output));
  }
}
