package com.example.vincent.yuejian.Service;

import com.example.vincent.yuejian.Bean.MasterSimpbean;
import com.example.vincent.yuejian.Bean.MasterBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Vincent on 2017/10/24.
 */

public interface MasterService {
    @GET("Mm/mmlist")
    Call<List<MasterBean>> getmmlist(
            @Query("page") String page
    );

    // Mm/simpact 用于获取单个对象
    @GET("Mm/mmdetil")
    Call<MasterSimpbean> getmmdetil(
            @Query("mid") String mid
    );
}
