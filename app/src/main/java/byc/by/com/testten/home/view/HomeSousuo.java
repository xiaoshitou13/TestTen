package byc.by.com.testten.home.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import byc.by.com.testten.R;
import byc.by.com.testten.frag.Shoppingcars;

public class HomeSousuo extends AppCompatActivity {
    List<String> SSlist = new ArrayList<>();
    private SearchView mSearchView;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_sousuo);
        initView();
    }

    private void initView() {
        mSearchView = (SearchView) findViewById(R.id.searchView);
        mListView = (ListView) findViewById(R.id.listView);

        SSlist.add("haha");

        mListView.setAdapter(new Myadater());
        mListView.setTextFilterEnabled(true);

        // 设置搜索文本监听
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // 当点击搜索按钮时触发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                SSlist.add(query);
                return false;
            }

            // 当搜索内容改变时触发该方法
            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)){
                   mListView.setFilterText(newText);
                }else{
                    mListView.clearTextFilter();
                }
                return false;
            }
        });

    }


    class  Myadater extends BaseAdapter{
        @Override
        public int getCount() {
            return SSlist.size();
        }

        @Override
        public Object getItem(int i) {
            return SSlist.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ShouSuoHolder shouSuoHolder = null;

            if(view == null){
                shouSuoHolder = new ShouSuoHolder();
                view = LayoutInflater.from(HomeSousuo.this).inflate(R.layout.homeitensousuo,null);
                shouSuoHolder.textView = (TextView) view.findViewById(R.id.homesousou);

                view.setTag(shouSuoHolder);
            }else{
                shouSuoHolder = (ShouSuoHolder) view.getTag();
            }

            shouSuoHolder.textView.setText(""+SSlist.get(i).toString());



            return view;
        }

        class ShouSuoHolder{
            TextView textView;
        }
    }
}
