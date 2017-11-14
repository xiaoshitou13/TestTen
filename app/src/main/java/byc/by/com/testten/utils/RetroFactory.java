package byc.by.com.testten.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fan on 2017/11/8.
 */

public class RetroFactory {

    public  static   String ur ="";

    public RetroFactory(String ur) {

    }

    private static OkHttpClient httpClient = new OkHttpClient.Builder()
            .addInterceptor(new LoggingInterceptor()).connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build();
    private static ApiServer retrofitService = new Retrofit.Builder()
            .baseUrl(ur)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(httpClient)
            .build()
            .create(ApiServer.class);
    //单列模式
    public static ApiServer getInstance() {

        return retrofitService;
    }


}
