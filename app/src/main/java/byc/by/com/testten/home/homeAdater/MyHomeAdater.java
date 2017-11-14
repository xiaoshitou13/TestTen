package byc.by.com.testten.home.homeAdater;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import byc.by.com.testten.R;
import byc.by.com.testten.home.bean.HomeDatas;

/**
 * Created by 白玉春 on 2017/11/13.
 */

public class MyHomeAdater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<HomeDatas> dataBeen;
    List<String> images = new ArrayList<>();
    public MyHomeAdater(Context context, List<HomeDatas> dataBeen) {
        this.context = context;
        this.dataBeen = dataBeen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType==0){
          return  new HomeTouViewHodler(LayoutInflater.from(parent.getContext()).inflate(R.layout.hometou,parent,false));
        }else if(viewType ==1){
            return new HomeZhong(LayoutInflater.from(parent.getContext()).inflate(R.layout.homeitemzhong,parent,false));
        }else if(viewType==2){
            return new viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.homezitem2,parent,false));
        }
      return  null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
          if(holder instanceof  HomeTouViewHodler){
              for( int  i = 0 ; i< dataBeen.get(0).getData().size() ; i++) {
                  images.add(dataBeen.get(0).getData().get(i).getIcon());
              }
              ((HomeTouViewHodler) holder).banner
                      .setImages(images)
                      .setImageLoader(new GlideImageLoder())
                      .setBannerAnimation(Transformer.DepthPage).isAutoPlay(true)
                      .setDelayTime(1500)
                      .setIndicatorGravity(BannerConfig.CENTER).start();;


          }

          if(holder instanceof  HomeZhong){
              List<HomeDatas.MiaoshaBean> miaoshaBeen= new ArrayList<>();
              miaoshaBeen.add(dataBeen.get(0).getMiaosha());
              MyHomeZhongadater  myHomeZhongadater = new MyHomeZhongadater(miaoshaBeen,context);
              ((HomeZhong) holder).homezhongrecy.setAdapter(myHomeZhongadater);
          }

        if(holder instanceof  viewHolder){
            ((viewHolder) holder).ztext.setText(""+dataBeen.get(0).getTuijian().getList().get(position).getTitle());
             ((viewHolder) holder).ztext2.setText(""+dataBeen.get(0).getTuijian().getList().get(position).getTitle());
            String string = dataBeen.get(0).getTuijian().getList().get(position).getImages();
            String[] str = string.split("\\|");
            for(int  i =0 ; i< str.length; i++) {
                Glide.with(context).load(str[i]).into(((viewHolder) holder).zimage2);
                Glide.with(context).load(str[i]).into(((viewHolder) holder).zimage1);
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataBeen.get(0).getTuijian().getList().size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return 0;
        }else if(position == 1){
            return 1;
        }else if(position ==2){
            return 2;
        }
        return 2;
    }

    class viewHolder extends RecyclerView.ViewHolder{
        ImageView zimage1;
        TextView ztext;
        ImageView zimage2;
        TextView ztext2;
        public viewHolder(View itemView) {
            super(itemView);
            zimage1 = itemView.findViewById(R.id.Homezimages);
            ztext = itemView.findViewById(R.id.Homeztexts);
            zimage2 = itemView.findViewById(R.id.iamge2);
            ztext2 = itemView.findViewById(R.id.Hometext2);
        }
    }
    class HomeZhong extends RecyclerView.ViewHolder{
        RecyclerView homezhongrecy;
        public HomeZhong(View itemView) {
            super(itemView);
            homezhongrecy = itemView.findViewById(R.id.homezhongrecy);
            homezhongrecy.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        }
    }



    class HomeTouViewHodler extends RecyclerView.ViewHolder{

        Banner banner ;
        public HomeTouViewHodler(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }

    class GlideImageLoder extends ImageLoader{

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }
}
