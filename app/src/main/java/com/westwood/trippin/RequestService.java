package com.westwood.trippin;

/**
 * Created by Westwood on 3/4/17.
 */

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RequestService {

    @GET("requests")
    Call<List<Request>> all();

    @GET("trips/1/events/{location}")
    Call<Request> get(@Path("location") String location);

    @POST("trips/1/events/{request}")
    Call<Request> create(@Body Request request);

}
