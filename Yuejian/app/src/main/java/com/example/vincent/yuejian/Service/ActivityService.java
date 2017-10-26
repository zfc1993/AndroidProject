package com.example.vincent.yuejian.Service;

import com.example.vincent.yuejian.Bean.ActSimpbean;
import com.example.vincent.yuejian.Bean.Actbean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/10/6 0006.
 */

public interface ActivityService {
    @GET("Act/actlist")
    Call<List<Actbean>> getactlist(
            @Query("page") String page
    );

    @GET("Act/simpact")
    Call<ActSimpbean> getactsimp(
            @Query("actid") String actid
    );
}
