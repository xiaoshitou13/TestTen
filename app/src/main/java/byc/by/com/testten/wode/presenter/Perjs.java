package byc.by.com.testten.wode.presenter;

import android.content.Context;


import byc.by.com.testten.wode.bean.Denglbean;
import byc.by.com.testten.wode.model.IcalResult;
import byc.by.com.testten.wode.model.Mdenglu;
import byc.by.com.testten.wode.view.InterView;


/**
 * Created by 白玉春 on 2017/10/14.
 */

public class Perjs  {


    private InterView interView;
    private Mdenglu mdenglu;


    public Perjs(InterView interView) {
        this.interView = interView;
        this.mdenglu = new Mdenglu();
    }

    /**
     *  登录
     */

    public void Login(Context context){

        mdenglu.login(context, interView.iphone(), interView.password(), new IcalResult() {
            @Override
            public void Success(Denglbean users) {
                interView.toMainActivity(users);
            }

            @Override
            public void Erooy() {

            }
        });
    }


    /**
     *  注册
     * @param context
     */
    public void Zuceya(Context context){

            mdenglu.Zc(context, interView.iphone(), interView.password(), new IcalResult() {
                @Override
                public void Success(Denglbean users) {
                    interView.toMainActivity(users);
                }

                @Override
                public void Erooy() {
                     interView.showFailedError();
                }
            });
    }




}
