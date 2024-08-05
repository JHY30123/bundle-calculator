package com.codetest.ioprocessors;

import com.codetest.enums.Format;
import com.codetest.entities.Post;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InputProcessor {
  public static Post postParser(String s) {
    String[] intput = s.split("\\s+");
    String format = intput[1].toUpperCase();
    if(!Format.isValid(format)) {
      throw new IllegalArgumentException("Invalid format");
    }
    Post post =
        Post.builder()
            .amount(Integer.parseInt(intput[0]))
            .format(Format.valueOf(format))
            .build();
    return post;
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
