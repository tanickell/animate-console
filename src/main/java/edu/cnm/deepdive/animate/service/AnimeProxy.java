package edu.cnm.deepdive.animate.service;

import edu.cnm.deepdive.animate.model.Anime;
import edu.cnm.deepdive.animate.model.Anime.InstanceWrapper;
import edu.cnm.deepdive.animate.model.Anime.ListWrapper;
import java.time.LocalDate;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface AnimeProxy {

  @GET("anime/{id}")
  Call<InstanceWrapper> get(@Path("id") int malId);

  @GET("anime")
  Call<ListWrapper> get(@Query("q") String name, @Query("sfw") Boolean sfw); // get "black box" to send across the wire; include data in request

  @GET("seasons/now")
  Call<ListWrapper> get(@Query("sfw") Boolean sfw);

  @GET()
  Call<ResponseBody> download(@Url String url);

}
