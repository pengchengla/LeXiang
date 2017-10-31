package www.lexiang.com.lexiang.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.bean.Lifebean;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class LifeAdapter extends RecyclerView.Adapter<LifeAdapter.Mylifeadapter> {

      private Context context;
    private List<Lifebean>list;

    public LifeAdapter(Context context, List<Lifebean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Mylifeadapter onCreateViewHolder(ViewGroup parent, int viewType) {
        Mylifeadapter myViewHolder=new  Mylifeadapter (LayoutInflater.from(context).inflate(R.layout.recy_lifeitem,parent,false));

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(Mylifeadapter holder, int position) {
        //加载数据
        Mylifeadapter holder1=holder;
        holder1.lifetitle.setText(list.get(position).getTitle());//加载数据

        holder1.recyclerView_gride.setLayoutManager(new GridLayoutManager(context,3));
        Recy_grideadapter recy_grideadapter=new Recy_grideadapter(context,list);
       holder1.recyclerView_gride.setAdapter(recy_grideadapter);
        /*
          设置监听
         */

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Mylifeadapter extends RecyclerView.ViewHolder{
        TextView lifetitle;
        RecyclerView recyclerView_gride;
        public Mylifeadapter(View itemView) {
            super(itemView);

            lifetitle= (TextView) itemView.findViewById(R.id.lifetitle);
            recyclerView_gride= (RecyclerView) itemView.findViewById(R.id.itemrecy_grade);

        }
    }
}
