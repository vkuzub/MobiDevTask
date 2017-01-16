package com.mobidevtask.network;

import com.mobidevtask.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public final class ServiceGenerator {

    public static final int TIMEOUT = 60;

    private ServiceGenerator() {
    }

    public static final String DEBUG_API_BASE_URL = "http://pokeapi.co/api/v2/";
    public static final String DEBUG_API_BASE_URL_FOR_IMAGES = "http://pokeapi.co/api/v2/";
    public static final String PRODUCTION_API_BASE_URL = "";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private static Retrofit retrofit;

    private static Retrofit.Builder builder = getBuilder();


    public static <S> S createService(Class<S> serviceClass) {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        if (BuildConfig.DEBUG)
            httpClient.addInterceptor(logging);

        httpClient.connectTimeout(TIMEOUT, TimeUnit.SECONDS);
        httpClient.readTimeout(TIMEOUT, TimeUnit.SECONDS);
        httpClient.writeTimeout(TIMEOUT, TimeUnit.SECONDS);

        retrofit = builder
                .client(httpClient.build())
                .build();

        return retrofit.create(serviceClass);
    }

    public static Retrofit getRetrofit() {
        if (retrofit != null)
            return retrofit;
        return builder.client(httpClient.build()).build();
    }

    private static Retrofit.Builder getBuilder() {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(PRODUCTION_API_BASE_URL);
        if (BuildConfig.DEBUG) {
            builder.baseUrl(DEBUG_API_BASE_URL);
        }
        builder.addConverterFactory(GsonConverterFactory.create());
        builder.addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        return builder;
    }
}
