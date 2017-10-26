package com.example.vincent.yuejian.Service;

import com.example.vincent.yuejian.Bean.ClubSimpbean;
import com.example.vincent.yuejian.Bean.Clubbean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/10/14 0014.
 */

public interface ClubService {
    @GET("Club/clublist")
    Call<List<Clubbean>> getClublist(
            @Query("page") String page
    );

    @GET("Club/clubdetil")
    Call<ClubSimpbean> getClubsimp(
            @Query("clubid") String clubid
    );
}
