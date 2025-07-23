package edu.cnm.deepdive.animate.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;

public class Anime {

  @Expose(serialize = false, deserialize = true)
  private Images images;

  @Expose(serialize = false, deserialize = true)
  private String title;


  Anime(String title) {
    this.title = title;
  }


  public Images getImages() {
    return images;
  }

  public void setImages(Images images) {
    this.images = images;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public static class Images {

    @Expose(serialize = false, deserialize = true)
    private Jpg jpg;

    @Expose(serialize = false, deserialize = true)
    private Webp webp;


    public Jpg getJpg() {
      return jpg;
    }

    public void setJpg(Jpg jpg) {
      this.jpg = jpg;
    }

    public Webp getWebp() {
      return webp;
    }

    public void setWebp(Webp webp) {
      this.webp = webp;
    }


    public static class Jpg {

      @Expose(serialize = false, deserialize = true)
      @SerializedName("image_url")
      private String imageUrl;

      @Expose(serialize = false, deserialize = true)
      @SerializedName("small_image_url")
      private String smallImageUrl;

      @Expose(serialize = false, deserialize = true)
      @SerializedName("large_image_url")
      private String largeImageUrl;


      public String getImageUrl() {
        return imageUrl;
      }

      public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
      }

      public String getSmallImageUrl() {
        return smallImageUrl;
      }

      public void setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
      }

      public String getLargeImageUrl() {
        return largeImageUrl;
      }

      public void setLargeImageUrl(String largeImageUrl) {
        this.largeImageUrl = largeImageUrl;
      }

    }

    public static class Webp {

      @Expose(serialize = false, deserialize = true)
      @SerializedName("image_url")
      private String imageUrl;

      @Expose(serialize = false, deserialize = true)
      @SerializedName("small_image_url")
      private String smallImageUrl;

      @Expose(serialize = false, deserialize = true)
      @SerializedName("large_image_url")
      private String largeImageUrl;


      public String getImageUrl() {
        return imageUrl;
      }

      public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
      }

      public String getSmallImageUrl() {
        return smallImageUrl;
      }

      public void setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
      }

      public String getLargeImageUrl() {
        return largeImageUrl;
      }

      public void setLargeImageUrl(String largeImageUrl) {
        this.largeImageUrl = largeImageUrl;
      }

    }

  }


  public static class InstanceWrapper {

    @Expose(serialize = false, deserialize = true)
    private Anime data;


    public Anime getData() {
      return data;
    }

    public void setData(Anime data) {
      this.data = data;
    }

  }


  public static class ListWrapper {

    @Expose(serialize = false, deserialize = true)
    private Pagination pagination;

    @Expose(serialize = false, deserialize = true)
    private List<Anime> data;


    public Pagination getPagination() {
      return pagination;
    }

    public void setPagination(Pagination pagination) {
      this.pagination = pagination;
    }

    public List<Anime> getData() {
      return data;
    }

    public void setData(List<Anime> data) {
      this.data = data;
    }


    public static class Pagination {

      @Expose(serialize = false, deserialize = true)
      @SerializedName("last_visible_page")
      private int lastVisiblePage;

      @Expose(serialize = false, deserialize = true)
      @SerializedName("has_next_page")
      private boolean hasNextPage;

      @Expose(serialize = false, deserialize = true)
      @SerializedName("current_page")
      private int currentPage;

      @Expose(serialize = false, deserialize = true)
      private Items items;


      public int getLastVisiblePage() {
        return lastVisiblePage;
      }

      public void setLastVisiblePage(int lastVisiblePage) {
        this.lastVisiblePage = lastVisiblePage;
      }

      public boolean isHasNextPage() {
        return hasNextPage;
      }

      public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
      }

      public int getCurrentPage() {
        return currentPage;
      }

      public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
      }

      public Items getItems() {
        return items;
      }

      public void setItems(Items items) {
        this.items = items;
      }


      public static class Items {

        @Expose(serialize = false, deserialize = true)
        private int count;

        @Expose(serialize = false, deserialize = true)
        private int total;

        @Expose(serialize = false, deserialize = true)
        @SerializedName("per_page")
        private int perPage;


        public int getCount() {
          return count;
        }

        public void setCount(int count) {
          this.count = count;
        }

        public int getTotal() {
          return total;
        }

        public void setTotal(int total) {
          this.total = total;
        }

        public int getPerPage() {
          return perPage;
        }

        public void setPerPage(int perPage) {
          this.perPage = perPage;
        }

      }

    }

  }

}
