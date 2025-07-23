package edu.cnm.deepdive.animate.service;

import edu.cnm.deepdive.animate.model.Anime;
import java.time.LocalDate;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface AnimeProxy {

  @GET("planetary/apod")
  Call<Anime> get(@Query("date") LocalDate date, @Query("api_key") String apiKey); // get "black box" to send across the wire; include data in request

  @GET("planetary/apod")
  Call<Anime[]> get(
      @Query("start_date") LocalDate startDate, @Query("end_date") LocalDate endDate,
      @Query("api_key") String apiKey);

  @GET()
  Call<ResponseBody> download(@Url String url);

}
