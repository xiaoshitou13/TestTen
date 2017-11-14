package byc.by.com.testten.frag;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import byc.by.com.testten.R;
import byc.by.com.testten.wode.bean.MyShijian;
import byc.by.com.testten.wode.view.MyLogin;


public class WodeFragment extends Fragment {

    private View view;
    private ImageView mImage;
    /**
     * TextView
     */
    private TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_wode, container, false);
        EventBus.getDefault().register(this);
        initView(v);
        return v;
    }

    private void initView(View v) {
        mImage = (ImageView) v.findViewById(R.id.image);
        mTextView = (TextView) v.findViewById(R.id.textView);
        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyLogin.class);
                startActivity(intent);
            }
        });

    }

    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void onDataSynEvent(MyShijian event) {
       mTextView.setText(event.getName());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
