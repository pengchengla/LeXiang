package www.lexiang.com.lexiang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import www.lexiang.com.lexiang.R;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class LifeAdapter extends RecyclerView.Adapter<LifeAdapter.Mylifeadapter> {

      private Context context;
    @Override
    public Mylifeadapter onCreateViewHolder(ViewGroup parent, int viewType) {
        Mylifeadapter myViewHolder=new  Mylifeadapter (LayoutInflater.from(context).inflate(R.layout.recy_lifeitem,parent,false));

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(Mylifeadapter holder, int position) {
        //加载数据
        Mylifeadapter holder1=holder;
        holder1.lifetitle.setText("");//加载数据

    }

    @Override
    public int getItemCount() {
        return 0;
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
