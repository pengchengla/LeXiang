package www.lexiang.com.lexiang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.bean.Lifebean;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class Recy_grideadapter extends RecyclerView.Adapter<Recy_grideadapter.Mygrideadapter> {

       private Context context;
    private List<Lifebean>list;

    public Recy_grideadapter(Context context, List list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Mygrideadapter onCreateViewHolder(ViewGroup parent, int viewType) {

      Mygrideadapter mygrideadapter=new Mygrideadapter(LayoutInflater.from(context).inflate(R.layout.fragment_recy_gride,parent,false));
        return mygrideadapter;
    }

    @Override
    public void onBindViewHolder(Mygrideadapter holder, int position) {
           holder.life_cout.setText(list.get(position).getCount());//加载数据

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Mygrideadapter extends RecyclerView.ViewHolder{
        TextView life_cout;
        public Mygrideadapter(View itemView) {
            super(itemView);
            life_cout= (TextView) itemView.findViewById(R.id.life_count);
        }
    }
}
