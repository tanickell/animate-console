package edu.cnm.deepdive.animate.view;

import edu.cnm.deepdive.animate.model.Anime;
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
//        anime.getDate(),
        anime.getTitle().strip(),
//        anime.getExplanation().strip(),
//        anime.getMediaType(),
        ifNull(anime.getImages().getJpg().getImageUrl(), noContent),
        ifNull(anime.getImages().getJpg().getLargeImageUrl(), noContent)                                 //         ifNull(anime.getUrl(), noContent), ifNull(anime.getHdurl(), noContent)
//        ((String) ifNull(anime.getCopyright(), noContent)).strip()
    );
  }

  private static Object ifNull(Object preferred, Object alternative) {
    return (preferred != null) ? preferred : alternative;
  }

}
