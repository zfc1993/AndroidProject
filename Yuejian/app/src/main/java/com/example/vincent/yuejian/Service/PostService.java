package com.example.vincent.yuejian.Service;

import com.example.vincent.yuejian.Bean.ActSimpbean;
import com.example.vincent.yuejian.Bean.PostBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Vincent on 2017/10/31.
 */

public interface PostService {
    @GET("Post/postlist")
    Call<List<PostBean>> getpostlist(
            @Query("page") String page
    );
    // 未修改
    @GET("Act/simpact")
    Call<ActSimpbean> getactsimp(
            @Query("actid") String actid
    );

}
