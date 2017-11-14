package byc.by.com.testten.wode.model;

import android.content.Context;

import java.io.File;

/**
 * Created by 白玉春 on 2017/10/14.
 */

public interface Denglu {
    void login(Context context, String mobile, String password, IcalResult icalResult);

    void Zc(Context context, String moblie, String password, IcalResult icalResult);

}
