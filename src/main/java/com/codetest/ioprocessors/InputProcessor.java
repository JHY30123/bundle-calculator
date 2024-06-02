package com.codetest.ioprocessors;

import com.codetest.dto.Post;
import com.codetest.resources.Format;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InputProcessor {
  public static Post postParser(String s) {
    String[] intput = s.split("\\s+");
    Post post =
        Post.builder()
            .amount(Integer.parseInt(intput[0]))
            .format(Format.valueOf(intput[1]))
            .build();
    return post;
  }

  public List<String> getInput() throws IOException {
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
      if (br == null) {
        br.close();
      }
    }
    return inputList.stream().filter(i -> !i.isEmpty()).collect(Collectors.toList());
  }
}
