package byc.by.com.testten.wode.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import byc.by.com.testten.R;
import byc.by.com.testten.wode.bean.Denglbean;
import byc.by.com.testten.wode.bean.MyShijian;
import byc.by.com.testten.wode.presenter.Perjs;

public class MyLogin extends AppCompatActivity implements View.OnClickListener , InterView {
    Perjs per ;
    /**
     * 请输入手机号
     */
    private EditText mIphone;
    private EditText mImima;
    /**
     * 登录
     */
    private Button mLogin;
    /**
     * 注册
     */
    private Button mZhuche;
    private SharedPreferences sp ;
    private SharedPreferences.Editor ed;
    private boolean b = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_login);
        EventBus.getDefault().register(this);
        initView();
    }

    private void initView() {
        mIphone = (EditText) findViewById(R.id.iphone);
        mImima = (EditText) findViewById(R.id.imima);
        per = new Perjs(this);
        sp = getSharedPreferences("jilu",MODE_PRIVATE);
        ed = sp.edit();
        mLogin = (Button) findViewById(R.id.login);
        mLogin.setOnClickListener(this);
        mZhuche = (Button) findViewById(R.id.zhuche);
        mZhuche.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.login:
                per.Login(this);

                break;
            case R.id.zhuche:

                startActivity(new Intent(this,Myzhuce.class));
                break;
        }
    }

    @Override
    public String iphone() {
        return mIphone.getText().toString();
    }

    @Override
    public String password() {
        return mImima.getText().toString();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void toMainActivity(Denglbean user) {
        if(user.getMsg().equals("登录成功")) {
            Toast.makeText(this, "" + user.getMsg(), Toast.LENGTH_SHORT).show();
             b =true;
            ed.putBoolean("denglu",b).commit();
            EventBus.getDefault().post(new MyShijian(mIphone.getText().toString(), mImima.getText().toString()));

            finish();
        }else{
            b =false;
            ed.putBoolean("denglu",b).commit();
            Toast.makeText(this, ""+user.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showFailedError() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void onDataSynEvent(MyShijian event) {
         mIphone.setText(event.getName());
         mImima.setText(event.getPassworld());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
