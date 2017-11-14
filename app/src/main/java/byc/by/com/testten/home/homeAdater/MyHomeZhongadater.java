package byc.by.com.testten.home.homeAdater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import byc.by.com.testten.R;
import byc.by.com.testten.home.bean.HomeDatas;

/**
 * Created by 白玉春 on 2017/11/13.
 */

public class MyHomeZhongadater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<HomeDatas.MiaoshaBean> miaoshaBeen;
    Context context;

    public MyHomeZhongadater(List<HomeDatas.MiaoshaBean> miaoshaBeen, Context context) {
        this.miaoshaBeen = miaoshaBeen;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.homezitem,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
         if(holder instanceof  viewHolder) {

             ((viewHolder) holder).ztext.setText(miaoshaBeen.get(0).getList().get(position).getTitle());
                String string = miaoshaBeen.get(0).getList().get(position).getImages();
                String[] str = string.split("\\|");
                for(int  i =0 ; i< str.length; i++) {
                    Glide.with(context).load(str[i]).into(((viewHolder) holder).zimage1);
                }
         }
    }

    @Override
    public int getItemCount() {
        return miaoshaBeen.get(0).getList().size();
    }

    class viewHolder extends RecyclerView.ViewHolder{
        ImageView zimage1;
        TextView ztext;
        public viewHolder(View itemView) {
            super(itemView);
            zimage1 = itemView.findViewById(R.id.Homezimage);
            ztext  = itemView.findViewById(R.id.Homeztext);


        }
    }
}
