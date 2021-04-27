package com.codetest;

import com.codetest.entities.Input;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
public class InputProcess {
  public List<String> getInput() throws IOException {
    List<String> inputList = new ArrayList<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;
    do {
      input = br.readLine();
      inputList.add(input);
    } while (input.length() != 0);

    return inputList.stream().filter(i -> !i.isEmpty()).collect(Collectors.toList());
  }

  public static Input inputFormatConvert(String s) {
    Input inputEntity = new Input();
    String[] input = s.split("\\s+");

    int postAmount = Integer.parseInt(input[0]);
    String postFormat = input[1];

    inputEntity.setPostAmount(postAmount);
    inputEntity.setPostFormat(postFormat);

    return inputEntity;
  }
}
