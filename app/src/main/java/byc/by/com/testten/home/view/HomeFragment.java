package byc.by.com.testten.home.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.xys.libzxing.zxing.activity.CaptureActivity;

import java.util.ArrayList;
import java.util.List;

import byc.by.com.testten.R;
import byc.by.com.testten.home.bean.HomeDatas;
import byc.by.com.testten.home.homeAdater.MyHomeAdater;
import byc.by.com.testten.home.presenter.Homepre;


public class HomeFragment extends Fragment implements View.OnClickListener , IHomeview {

    private View view;
    private ImageView mHomelefticon;
    private ImageView mHomerighticon;
    private RelativeLayout mHometou;
    private RecyclerView mHomerecy;
    private SwipeRefreshLayout mHomeswipe;
    private EditText meditText;
    private Homepre homepre;
    private List<HomeDatas> dataBeen = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        initView(v);

        return v;
    }


    private void initView(View v) {
        homepre  = new Homepre(getContext(),this);
        homepre.HomeBanner();
        meditText = v.findViewById(R.id.HomeEd);
        meditText.setOnClickListener(this);
        mHomelefticon = (ImageView) v.findViewById(R.id.Homelefticon);
        mHomelefticon.setOnClickListener(this);
        mHomerighticon = (ImageView) v.findViewById(R.id.Homerighticon);
        mHomerighticon.setOnClickListener(this);
        mHometou = (RelativeLayout) v.findViewById(R.id.Hometou);
        mHometou.setOnClickListener(this);
        mHomerecy = (RecyclerView) v.findViewById(R.id.Homerecy);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mHomerecy.setLayoutManager(linearLayoutManager);   //布局管理器
        mHomeswipe = (SwipeRefreshLayout) v.findViewById(R.id.Homeswipe);
        mHomeswipe.setOnClickListener(this);
        meditText.setKeyListener(null);

        mHomeswipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                           homepre.HomeBanner();

                        Toast.makeText(getContext(), "更新好了", Toast.LENGTH_SHORT).show();
                        mHomeswipe.setRefreshing(false);
                    }
                },2000);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.HomeEd:
                startActivity(new Intent(getActivity(),HomeSousuo.class));
                break;
            case R.id.Homelefticon:
                startActivityForResult(new Intent(getActivity(), CaptureActivity.class),0);
                break;
            case R.id.Homerighticon:

                break;
            case R.id.Hometou:
                break;
            case R.id.Homeswipe:
                break;
        }
    }

    @Override
    public void HomeDatas(HomeDatas homeDatas) {

        dataBeen.add(homeDatas);
        MyHomeAdater myHomeAdater = new MyHomeAdater(getContext(),dataBeen);
        mHomerecy.setAdapter(myHomeAdater);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(getActivity(), "傻了吧  哼", Toast.LENGTH_SHORT).show();
    }
}
