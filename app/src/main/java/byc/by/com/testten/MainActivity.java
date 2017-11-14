package byc.by.com.testten;

import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.hjm.bottomtabbar.BottomTabBar;

import byc.by.com.testten.frag.MeFragment;
import byc.by.com.testten.frag.Shoppingcars;
import byc.by.com.testten.frag.TansuoFragment;
import byc.by.com.testten.frag.WodeFragment;
import byc.by.com.testten.home.view.HomeFragment;
import byc.by.com.testten.utils.Cengjing;
import byc.by.com.testten.utils.NetUtils;

public class MainActivity extends AppCompatActivity {

    private BottomTabBar mBottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);  //取消状态栏
        setContentView(R.layout.activity_main);
//        Build build = new Build();
//        Cengjing cengjing = new Cengjing(build,this,getSupportActionBar());


        if(NetUtils.isAvailable(this)) {
            InitView();
        }else{
            AlertDialog.Builder builder  = new AlertDialog.Builder(this);
            builder.setTitle("没有网哦小哥哥");
            builder.setPositiveButton("开网", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    NetUtils.openWirelessSettings(MainActivity.this);
                }
            });
            builder.setNegativeButton("不要了",null);
            builder.show();
        }
    }

    private void InitView() {

        mBottomTabBar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);
        mBottomTabBar.init(getSupportFragmentManager())
                .addTabItem("首页", R.mipmap.ic_nav_home_press, R.mipmap.ic_nav_home, HomeFragment.class)
                .addTabItem("探索", R.mipmap.ic_nav_class_press,R.mipmap.ic_nav_class, TansuoFragment.class)
                .addTabItem("购物车", R.mipmap.ic_nav_cart_press,R.mipmap.ic_nav_cart, Shoppingcars.class)
                .addTabItem("我的", R.mipmap.ic_nav_user_press,R.mipmap.ic_nav_user ,WodeFragment.class);
    }
}
