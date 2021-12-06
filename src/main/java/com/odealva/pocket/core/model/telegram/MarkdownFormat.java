package com.odealva.pocket.core.model.telegram;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MarkdownFormat {
  private final String title;
  private final String url;
  private final LocalDateTime timeAdded;
  private final int wordCount;

  private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  private MarkdownFormat(MarkdownBuilder builder) {
    this.title = builder.title;
    this.url = builder.url;
    this.timeAdded = builder.timeAdded;
    this.wordCount = builder.wordCount;
  }

  public String compile() {
    StringBuilder sb = new StringBuilder();
    String markdownTitle = String.format("*%s*", this.title);
    String markdownURL = String.format("_Read Here:_ [URL](%s)", this.url);
    String markdownDate = String.format("*Time Added:* %s", formatter.format(this.timeAdded));
    String markdownCount = String.format("*Word Count:* %d", wordCount);
    sb.append(markdownTitle);
    sb.append("\n");
    sb.append(markdownURL);
    sb.append("\n");
    sb.append(markdownDate);
    sb.append("\n");
    sb.append(markdownCount);
    sb.append("\n");
    return sb.toString();
  }

  public static class MarkdownBuilder {

    private String title = "";
    private String url = "";
    private LocalDateTime timeAdded = LocalDateTime.now();
    private int wordCount = -1;

    public MarkdownBuilder setTitle(String title) {
      this.title = title;
      return this;
    }

    public MarkdownBuilder setUrl(String url) {
      this.url = url;
      return this;
    }

    public MarkdownBuilder setTimeAdded(LocalDateTime timeAdded) {
      this.timeAdded = timeAdded;
      return this;
    }

    public MarkdownBuilder setWordCount(int wordCount) {
      this.wordCount = wordCount;
      return this;
    }

    public MarkdownFormat build() {
      return new MarkdownFormat(this);
    }
  }
}
