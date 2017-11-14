package byc.by.com.testten.utils;

import java.util.Map;

import byc.by.com.testten.wode.bean.Denglbean;
import byc.by.com.testten.home.bean.HomeDatas;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by fan on 2017/11/8.
 */

public interface ApiServer {

    @POST
    Observable<Denglbean> getHome(@Url String url, @QueryMap Map<String,String> map);

    @GET("ad/getAd")
    Observable<HomeDatas> getHomeDatas();

}
