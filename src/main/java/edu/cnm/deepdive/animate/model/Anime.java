package edu.cnm.deepdive.animate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.net.URL;
import java.time.LocalDate;

public class Anime {

  @Expose(serialize = false, deserialize = true)
  private final String title;

  Anime(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

}
