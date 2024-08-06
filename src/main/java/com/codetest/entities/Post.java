package com.codetest.entities;

import com.codetest.enums.Format;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(builderClassName = "PostBuilder",buildMethodName = "build")
@AllArgsConstructor
@NoArgsConstructor
public class Post {
  private int amount;
  private Format format;

  public static class PostBuilder {
    private int amount;
    private Format format;

    public PostBuilder amount(int amount) {
      if (amount <= 0) {
        throw new IllegalArgumentException("Amount must be greater than zero");
      }
      this.amount = amount;
      return this;
    }

    public PostBuilder format(Format format) {
      if (format == null) {
        throw new IllegalArgumentException("Format cannot be null");
      }
      this.format = format;
      return this;
    }

    public Post build() {
      return new Post(amount, format);
    }
  }
}
