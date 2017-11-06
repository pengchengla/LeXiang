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

public class ReleaseAdapter extends RecyclerView.Adapter<ReleaseAdapter.Myadapter> {
    private OnItemClickListener mOnItemClickListener = null;
       private Context context;
    private List<Bianminbean> list;
    //Type
    private int TYPE_NORMAL = 1000;
    private int TYPE_FOOTER = 1002;
    public ReleaseAdapter(Context context, List<Bianminbean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Myadapter onCreateViewHolder(ViewGroup parent, int viewType) {
           if(viewType==TYPE_FOOTER){
             //  return new Myadapter();

           }
        else {
               Myadapter myadapter = new Myadapter(LayoutInflater.from(context).inflate(R.layout.release_recyitem, parent, false));

               return myadapter;
           }
         return null;
    }

    @Override
    public void onBindViewHolder( final Myadapter holder, int position) {
          if(mOnItemClickListener!=null){

              holder.itemView.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      int layoutPosition = holder.getLayoutPosition();
                      mOnItemClickListener.onItemClick(holder.itemView,layoutPosition);
                  }
              });


          }
           holder.release_img.setImageResource(list.get(position).getImage());
           holder.release_text.setText(list.get(position).getCount());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myadapter extends RecyclerView.ViewHolder {
          private ImageView release_img ;
                  private TextView release_text;
        public Myadapter(View itemView) {
            super(itemView);
            release_img= (ImageView) itemView.findViewById(R.id.release_img);
           release_text= (TextView) itemView.findViewById(R.id.release_dis);

        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view , int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}
