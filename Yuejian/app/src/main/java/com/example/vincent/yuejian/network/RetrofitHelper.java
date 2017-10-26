package com.example.vincent.yuejian.network;

import com.example.vincent.yuejian.Utils.Data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/10/1 0001.
 */

public class RetrofitHelper {

        private  static Retrofit retrofit;
        public  <T> T  builder(Class<T> service)
        {

            retrofit=new Retrofit.Builder()
                    .baseUrl(Data.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit.create(service);
        }

    }
