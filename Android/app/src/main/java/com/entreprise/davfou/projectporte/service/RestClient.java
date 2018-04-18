package com.entreprise.davfou.projectporte.service;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by davidfournier on 04/06/2017.
 */

public  class RestClient {

    public RestClient() {
    }


    private static Gson gson = new GsonBuilder()
            .create();


    private static  HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient client = new OkHttpClient.Builder().
            addInterceptor(interceptor).build();




    private static Retrofit.Builder retrofit = new Retrofit.Builder()
            .baseUrl(ApiService.ENDPOINT)
            .client(client)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson));


    synchronized public static <S> S createService(Class<S> serviceClass) {
        return retrofit.build().create(serviceClass);
    }


}
