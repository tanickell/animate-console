package edu.cnm.deepdive.animate.controller;

import edu.cnm.deepdive.animate.model.Anime;
import edu.cnm.deepdive.animate.service.AnimeService;
import edu.cnm.deepdive.animate.view.AnimeView;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Spec;

/**
 * Uses NASA APOD API to retrieve one or more Astronomy Pictures of the Day, displaying the textual
 * information (by default), and optionally downloading any images.
 */
@Command(name = "apod", requiredOptionMarker = '*', sortSynopsis = false, sortOptions = false)
public class AnimeRetriever implements Callable<Integer> {

  private static final Pattern FILENAME_PATTERN = Pattern.compile("^.*/([^/]+\\.([^/.]+))$");
  private static final String PROVIDED_FILENAME_FORMAT = "%1$s.%2$s";
  private static final String MEDIA_TYPE_WARNING_FORMAT =
      "The APOD for %s is not an image. Downloading video (or any media type other than image) is not supported.%n";

  private final AnimeService service;
  private final AnimeView view;
  private final PrintStream out;

  @Spec
  private CommandSpec spec;

//  @SuppressWarnings("FieldMayBeFinal")
//  @Parameters(
//      index = "0..1",
//      description = "date (in YYYY-MM-DD format) or date range of desired APOD(s)"
//  )
//  private LocalDate[] dates = {LocalDate.now()}; // declaration-with-assignment abbreviation

  @SuppressWarnings("FieldMayBeFinal")
  @Parameters(
      index = "0..1",
      description = "date (in YYYY-MM-DD format) or date range of desired Animes"
  )
  private LocalDate[] dates = {LocalDate.now()}; // declaration-with-assignment abbreviation

  @Option(
      names = {"--name"}, arity = "1", paramLabel = "NAME",
      description = "name of Anime to search"
  )
  private String searchName;

  @Option(
      names = {"--id"}, arity = "1", paramLabel = "ID",
      description = "MyAnimeList id of Anime to retrieve"
  )
  private String searchId;

  @Option(
      names = {"-m", "--mute"},
      description = "flag to mute (silence) display of Astronomy Picture of the Day attributes"
  )
  private boolean mute;

  @Option(
      names = {"--std-def"}, arity = "0..1", paramLabel = "FILE",
      description = "name (without extension) of standard-definition output file"
  )
  private String stdDefOutput;

  @Option(
      names = {"--high-def"}, arity = "0..1", paramLabel = "FILE",
      description = "name (without extension) of high-definition output file"
  )
  private String highDefOutput;

  @Option(
      names = {"-?", "-h", "--help"}, usageHelp = true,
      description = "display this help and exit"
  )
  private boolean help;

  /**
   * Initializes this instance to use the specified {@link AnimeService}, {@link AnimeView}, and
   * {@link PrintStream}.
   *
   * @param service {@code AnimeService} used to communicate with NASA APOD API.
   * @param view    {@code AnimeView} used to render an {@link Anime} instance to a {@code String}.
   * @param out     {@code PrintStream} to which rendered output is sent.
   */
  public AnimeRetriever(AnimeService service, AnimeView view, PrintStream out) {
    this.service = service;
    this.view = view;
    this.out = out;
  }

  /**
   * Retrieves {@link Anime} instance from NASA APOD API, prints its attributes, and optionally
   * downloads the image(s).
   *
   * @return Result code, where zero (0) indicates no error, and non-zero indicates some error
   * condition.
   */
  @Override
  public Integer call() {
    try {
      Anime[] animes = retrieveAnimes();
      displayProperties(animes);
      //downloadImages(animes);
      return 0;
    } catch (IOException e) {
      return 1; // FIXME: 5/29/25 Display more information.
    }
  }

//  private void downloadImages(Anime[] animes) throws IOException {
//    if (stdDefOutput != null || highDefOutput != null) {
//      for (Anime anime : animes) {
//        if (anime.getMediaType() != MediaType.IMAGE) {
//          out.printf(MEDIA_TYPE_WARNING_FORMAT, anime.getDate());
//        } else {
//          downloadImage(stdDefOutput, anime.getUrl());
//          downloadImage(highDefOutput, anime.getHdurl());
//        }
//      }
//    }
//  }

  private void displayProperties(Anime[] animes) {
    if (!mute) {
      for (Anime anime : animes) {
        String representation = view.render(anime);
        out.println(representation);
      }
    }
  }

  // *****APOD VERSION (REFACTORED) -- REWORK LATER*****
//  private Anime[] retrieveAnimes() throws IOException {
//    Anime[] animes;
//    if (dates.length == 1) {
//      animes = new Anime[]{service.getAnime(dates[0])};
//    } else {
//      Arrays.sort(dates);
//      animes = service.getAnimes(dates[0], dates[1]);
//    }
//    return animes;
//  }

  private Anime[] retrieveAnimes() throws IOException {
    Anime[] animes;
    if (dates.length == 0) {
      animes = new Anime[]{service.getAnime(54492)};
    } else if (dates.length == 1){
      //animes = service.getAnimes(dates[0]);                //***** FOR NOW, DO NOTHING *****
      animes = new Anime[]{};
    } else {
      Arrays.sort(dates);
      //animes = service.getAnimes(dates[0], dates[1]);
      animes = new Anime[]{};
    }
    return animes;
  }

//  private void downloadImage(String downloadOption, URL imageUrl) throws IOException {
//    if (downloadOption != null) {
//      Matcher matcher = FILENAME_PATTERN.matcher(imageUrl.toString());
//      if (matcher.matches()) {
//        String filename = (downloadOption.isBlank())
//            ? matcher.group(1)
//            : PROVIDED_FILENAME_FORMAT.formatted(downloadOption, matcher.group(
//                2)); //matcher.replaceAll(stdDefOutput + ".$2"); // stdDefOutput + "." + matcher.group(2)
//        Path output = Paths.get(filename);
//        InputStream input = service.getImageStream(imageUrl);
//        Files.copy(input, output, StandardCopyOption.REPLACE_EXISTING);
//      }
//    }
//  }

}
