package byc.by.com.testten.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.Window;

/**
 * Created by 白玉春 on 2017/10/2.
 */

public class Cengjing {

    public Cengjing(Build build , Activity a, ActionBar actionBar){
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = a.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            a.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

    //    actionBar.hide();
    }



}
