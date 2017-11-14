package byc.by.com.testten.wode.view;


import byc.by.com.testten.wode.bean.Denglbean;

/**
 * Created by 白玉春 on 2017/10/14.
 */

public interface InterView {

    //获取到手机号 密码
    String iphone();
    String password();

    //注册成功后  显示一下
    void showLoading();

    void hideLoading();

    //注册成功 后提示
    void toMainActivity(Denglbean user);

    void showFailedError();
}
