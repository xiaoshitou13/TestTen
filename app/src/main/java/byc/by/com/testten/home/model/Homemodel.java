package byc.by.com.testten.home.model;

import byc.by.com.testten.home.bean.HomeDatas;
import byc.by.com.testten.home.view.IHomeview;
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
 * Created by 白玉春 on 2017/11/13.
 */

public class Homemodel implements IHomemodel {
    @Override
    public void HomeDatass(final IHomeview iHomeview) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Nets.BANNER)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();

        ApiServer apiServer =    retrofit.create(ApiServer.class);

        Observable<HomeDatas> denglbean = apiServer.getHomeDatas();

        denglbean.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeDatas>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(HomeDatas homeDatas1) {
                         iHomeview.HomeDatas(homeDatas1);
                    }
                });
    }
}
