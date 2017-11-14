package byc.by.com.testten.utils;

import okhttp3.Request;

/**
 * Created by 白玉春 on 2017/10/14.
 */

public interface Icalect<T> {

    public   void Result(T response);
    public  void onError(Request request, Exception e);

}
