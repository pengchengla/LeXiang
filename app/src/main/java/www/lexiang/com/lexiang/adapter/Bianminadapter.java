package www.lexiang.com.lexiang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.bean.Bianminbean;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class Bianminadapter extends RecyclerView.Adapter<Bianminadapter.MyViewHolder>{

    private Context context;
     private List<Bianminbean> list;

    public Bianminadapter(Context context, List<Bianminbean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         MyViewHolder myViewHolder=new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.bianmin_item,parent,false));

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //加载数据
        MyViewHolder holder1=holder;
        holder1.bian_count.setText(list.get(position).getCount());
        holder1.bian_img.setImageResource(list.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

     class MyViewHolder extends RecyclerView.ViewHolder {
          //findbyid
           TextView bian_count;
         ImageView bian_img;
         public MyViewHolder(View itemView) {
             super(itemView);
             bian_count= (TextView) itemView.findViewById(R.id.bian_count);
             bian_img= (ImageView) itemView.findViewById(R.id.bian_img);
         }
     }
}
