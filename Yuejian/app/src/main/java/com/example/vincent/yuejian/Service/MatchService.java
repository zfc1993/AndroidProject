package com.example.vincent.yuejian.Service;

import com.example.vincent.yuejian.Bean.MatchSimpbean;
import com.example.vincent.yuejian.Bean.Matchbean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/10/9 0009.
 */

public interface MatchService {

    @GET("Game/gamelist")
    Call<List<Matchbean>> getMatchlist(
            @Query("page") String page
    );

    @GET("Game/gamedetail")
    Call<MatchSimpbean> getMatchsimp(
            @Query("gid") String gid
    );

}
