package edu.cnm.deepdive.animate;

import edu.cnm.deepdive.animate.controller.AnimeRetriever;
import edu.cnm.deepdive.animate.service.AnimeService;
import edu.cnm.deepdive.animate.view.AnimeView;
import java.io.IOException;
import picocli.CommandLine;

public class Main {

  public static void main(String[] args) throws IOException {
    new CommandLine(
        new AnimeRetriever(new AnimeService(), new AnimeView(), System.out)).execute(args);
  }

}
