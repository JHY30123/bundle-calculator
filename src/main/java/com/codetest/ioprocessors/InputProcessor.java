package com.codetest.ioprocessors;

import com.codetest.fields.Input;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class InputProcessor {
  public static Input inputConvert(String s) {
    String[] inputContext = s.split("\\s+");
    Input inputFields =
        Input.builder()
            .postAmount(Integer.parseInt(inputContext[0]))
            .postFormat(inputContext[1])
            .build();
    return inputFields;
  }

  public List<String> getInput() throws IOException {
    //    List<String> inputList = new ArrayList<>();
    //    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //    String input;
    //    do {
    //      input = br.readLine();
    //      inputList.add(input);
    //    } while (input.length() != 0);
    //    return inputList.stream().filter(i -> !i.isEmpty()).collect(Collectors.toList());
    List<String> inputList = new ArrayList<>();
    BufferedReader br = null;
    try {
      br = new BufferedReader(new InputStreamReader(System.in));
      String input;
      do {
        input = br.readLine();
        inputList.add(input);
      } while (input.length() != 0);
    } finally {
      if (br == null)
        ;
      br.close();
    }
    return inputList.stream().filter(i -> !i.isEmpty()).collect(Collectors.toList());
  }
}
