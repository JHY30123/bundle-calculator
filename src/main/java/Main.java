import com.codetest.IOProcess.InputProcess;
import com.codetest.IOProcess.OutputProcess;
import com.codetest.converter.OutputConverter;
import com.codetest.fields.Input;
import com.codetest.fields.Output;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.java.Log;

@Log
public class Main {
  public static void main(String[] args) throws IOException {
    InputProcess inputProcess = new InputProcess();
    OutputConverter outputConverter = new OutputConverter();
    OutputProcess outputProcess = new OutputProcess();
    System.out.println("Please input posts amount and format, press enter twice to confirm");

    List<String> inputContent = inputProcess.getInput();
    List<Input> inputFields =
        inputContent.stream().map(InputProcess::inputConvert).collect(Collectors.toList());
    List<Output> outputs =
        inputFields.stream()
            .map(input -> outputConverter.setOutputFormat(input))
            .collect(Collectors.toList());
    outputs.forEach(output -> outputProcess.returnResultInfo(output));
  }
}
