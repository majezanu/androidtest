package com.dacodes.venadostest.Views.IO;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VenadosApiAdapter {
    private static VenadosApiService API_SERVICE;
    private static final String BASE_URL = "https://venados.dacodes.mx/api/";
    public static VenadosApiService getApiService()
    {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        if (API_SERVICE == null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build()) // <-- usamos el log level
                    //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            API_SERVICE = retrofit.create(VenadosApiService.class);
        }

        return API_SERVICE;
    }
}
