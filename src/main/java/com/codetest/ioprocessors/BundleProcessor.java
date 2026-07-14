package com.codetest.ioprocessors;

import com.codetest.entities.Post;
import com.codetest.enums.Format;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BundleProcessor {
  public static Post postParser(String line) {
    Objects.requireNonNull(line, "line");
    String[] tokenArray = line.trim().split("\\s+");
    if (tokenArray.length != 2) {
      throw new IllegalArgumentException("Expected '<amount> <format>' but got: '" + line + "'");
    }
    try {
      return Post.builder()
              .amount(Integer.parseInt(tokenArray[0]))
              .format(Format.fromCode(tokenArray[1]))
              .build();
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Amount is not a valid integer: '" + tokenArray[0] + "'", e);
    }
  }

  public List<String> getInput() throws IOException {
    List<String> inputList = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      String input;
      while ((input = br.readLine()) != null && !input.isEmpty()) {
        inputList.add(input);
      }
    }
    return inputList;
  }
}
