package byc.by.com.testten.home.presenter;

import android.content.Context;

import byc.by.com.testten.home.bean.HomeDatas;
import byc.by.com.testten.home.model.Homemodel;
import byc.by.com.testten.home.view.HomeFragment;
import byc.by.com.testten.home.view.IHomeview;

/**
 * Created by 白玉春 on 2017/11/13.
 */

public class Homepre  {
    Context context;
    Homemodel homemodel;
    IHomeview iHomeview;

    public Homepre(Context context, IHomeview iHomeview) {
        this.context = context;
        this.iHomeview = iHomeview;
        this.homemodel = new Homemodel();
    }




    public void HomeBanner(){
        homemodel.HomeDatass(new IHomeview() {
            @Override
            public void HomeDatas(HomeDatas homeDatas) {
                iHomeview.HomeDatas(homeDatas);
            }
        });
    }
}
