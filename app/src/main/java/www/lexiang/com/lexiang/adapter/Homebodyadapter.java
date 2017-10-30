package www.lexiang.com.lexiang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.bean.Homebean;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class Homebodyadapter extends BaseAdapter {
     private Context context;

    private List<Homebean> list;
    public Homebodyadapter(Context context,List<Homebean> list) {
        this.context = context;
        this.list=list;

    }


    @Override
    public int getCount() {
        return list!=null?list.size():0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         ViewHolder holder =null;
        if(convertView==null){
             holder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.listhome_item,null);
            holder.home_title= (TextView) convertView.findViewById(R.id.homeitem_title);
            holder.home_image= (ImageView) convertView.findViewById(R.id.homeitem_img);
            convertView.setTag(holder);

        }else {
           holder= (ViewHolder) convertView.getTag();
        }
                //添加数据
        holder.home_title.setText(list.get(position).getTitle());
        holder.home_image.setImageResource(list.get(position).getImage());
        return convertView;
    }

      class ViewHolder{
          TextView home_title;
          ImageView home_image;
      }
}
