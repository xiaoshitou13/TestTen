package byc.by.com.testten.wode.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import byc.by.com.testten.R;
import byc.by.com.testten.wode.bean.Denglbean;
import byc.by.com.testten.wode.bean.MyShijian;
import byc.by.com.testten.wode.presenter.Perjs;

public class Myzhuce extends AppCompatActivity implements View.OnClickListener , InterView{

    /**
     * 请输入手机号
     */
    private EditText mIphones;
    private EditText mImimas;
    /**
     * 注册
     */
    private Button mZhuces;
    private Perjs perjs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myzhuce);
        initView();
    }

    private void initView() {
        perjs = new Perjs(this);
        mIphones = (EditText) findViewById(R.id.iphones);
        mImimas = (EditText) findViewById(R.id.imimas);
        mZhuces = (Button) findViewById(R.id.zhuces);
        mZhuces.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.zhuces:

                perjs.Zuceya(this);

                EventBus.getDefault().post(new MyShijian(mIphones.getText().toString(),mImimas.getText().toString()));
                break;
        }
    }

    @Override
    public String iphone() {
        return  mIphones.getText().toString();
    }

    @Override
    public String password() {
        return mImimas.getText().toString();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void toMainActivity(Denglbean user) {
        Denglbean z =null;
        EventBus.getDefault().postSticky(new MyShijian(mIphones.getText().toString(),mImimas.getText().toString()));
        Toast.makeText(this, ""+user.getMsg(), Toast.LENGTH_SHORT).show();
        if(user.getMsg().equals("注册成功")){
            finish();
        }
    }

    @Override
    public void showFailedError() {
    }


}
