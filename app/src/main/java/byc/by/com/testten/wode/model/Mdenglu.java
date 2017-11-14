package byc.by.com.testten.wode.model;

import android.content.Context;
import android.os.Handler;


import java.util.HashMap;
import java.util.Map;

import byc.by.com.testten.wode.bean.Denglbean;
import byc.by.com.testten.utils.ApiServer;
import byc.by.com.testten.utils.Nets;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 白玉春 on 2017/10/14.
 */

public class Mdenglu implements Denglu{

    private Handler handler = new Handler();
    @Override
    public void login(Context context , final String mobile, final String password, final IcalResult icalResult) {

        Map<String,String> map = new HashMap<String, String>();
        map.put("mobile",mobile);
        map.put("password",password);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Nets.log)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();

       ApiServer apiServer =    retrofit.create(ApiServer.class);

       Observable<Denglbean> denglbean = apiServer.getHome("user/login",map);

        denglbean.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Denglbean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Denglbean denglbean) {
                        icalResult.Success(denglbean);
                    }
                });
    }

    @Override
    public void Zc(final Context context , final String moblie, final String password, final IcalResult icalResult) {

        Map<String,String> map = new HashMap<String, String>();
        map.put("mobile",moblie);
        map.put("password",password);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Nets.zc)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();

        ApiServer apiServer =    retrofit.create(ApiServer.class);

        Observable<Denglbean> denglbean = apiServer.getHome("user/reg",map);

        denglbean.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Denglbean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Denglbean denglbean) {
                        icalResult.Success(denglbean);
                    }
                });

   }
}
