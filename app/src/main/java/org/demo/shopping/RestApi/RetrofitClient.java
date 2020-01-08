package org.demo.shopping.RestApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.demo.shopping.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "https://private-anon-cb160a093a-ddshop.apiary-mock.com/";

    private static RetrofitClient mInstance;
    private Retrofit retrofit;
    private RetrofitClient()
    {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG)
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)//third, log at the end
                .build();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit =new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    public static synchronized RetrofitClient getInstance() {
        if (mInstance == null){
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }
    public Api getapi(){
        return retrofit.create(Api.class);
    }
}
