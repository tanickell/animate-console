package edu.cnm.deepdive.animate.view;

import edu.cnm.deepdive.animate.model.Anime;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ResourceBundle;

public class AnimeView {

  private static final String BUNDLE_NAME = "strings";
  private static final String ATTRIBUTES_FORMAT_KEY = "attributes_format_animate";
  private static final String NO_CONTENT_KEY = "no_content";

  private final String attributesFormat;
  private final String noContent;

  public AnimeView() {
    ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);
    attributesFormat = bundle.getString(ATTRIBUTES_FORMAT_KEY);
    noContent = bundle.getString(NO_CONTENT_KEY);
  }

  public String render(Anime anime) {
    return attributesFormat.formatted(
        OffsetDateTime.parse(anime.getAired().getFrom().toString()).toLocalDate(),
        ifNullStrip(anime.getTitle(), noContent),
        ifNullStrip(anime.getSynopsis(), noContent),
        ifNull(anime.getType(), noContent),
        ifNull(anime.getImages().getJpg().getImageUrl(), noContent),
        ifNull(anime.getImages().getJpg().getLargeImageUrl(), noContent),                                 //         ifNull(anime.getUrl(), noContent), ifNull(anime.getHdurl(), noContent)
        anime.getSeason() != null ? anime.getSeason().strip() + " " + anime.getYear() : noContent                      //        ((String) ifNull(anime.getCopyright(), noContent)).strip()
    );
  }

  private static Object ifNull(Object preferred, Object alternative) {
    return (preferred != null) ? preferred : alternative;
  }

  private static String ifNullStrip(String preferred, String alternative) {
    return (preferred != null) ? preferred.strip() : alternative;
  }

}
