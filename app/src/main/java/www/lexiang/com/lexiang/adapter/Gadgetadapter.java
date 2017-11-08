package www.lexiang.com.lexiang.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.bean.Gadgetbean;
import www.lexiang.com.lexiang.bean.Imagebean;
import www.lexiang.com.lexiang.utils.divider.RecyclerViewSpaceItemDecoration;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class Gadgetadapter extends RecyclerView.Adapter<Gadgetadapter.Myadapter> {

      private Context context;
      private List<Gadgetbean> list;
    private RecyclerView.ItemDecoration mCurrentItemDecoration;
    //添加数据
    List<Imagebean> lists=new ArrayList<>();
    private String[] mUrls = new String[]{"http://d.hiphotos.baidu.com/image/h%3D200/sign=201258cbcd80653864eaa313a7dca115/ca1349540923dd54e54f7aedd609b3de9c824873.jpg",
            "http://img3.fengniao.com/forum/attachpics/537/165/21472986.jpg",
            "http://d.hiphotos.baidu.com/image/h%3D200/sign=ea218b2c5566d01661199928a729d498/a08b87d6277f9e2fd4f215e91830e924b999f308.jpg",
            "http://img4.imgtn.bdimg.com/it/u=3445377427,2645691367&fm=21&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=2644422079,4250545639&fm=21&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=1444023808,3753293381&fm=21&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=882039601,2636712663&fm=21&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=4119861953,350096499&fm=21&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=2437456944,1135705439&fm=21&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=3251359643,4211266111&fm=21&gp=0.jpg",
            "http://img4.duitang.com/uploads/item/201506/11/20150611000809_yFe5Z.jpeg",
            "http://img5.imgtn.bdimg.com/it/u=1717647885,4193212272&fm=21&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=2024625579,507531332&fm=21&gp=0.jpg"};

    public Gadgetadapter(Context context, List<Gadgetbean> list) {
        this.context = context;
        this.list = list;
        data();
    }

    @Override
    public Myadapter onCreateViewHolder(ViewGroup parent, int viewType) {

          Myadapter myadapter=new Myadapter(LayoutInflater.from(context).inflate(R.layout.gadget_recycleritem,parent,false));
           return myadapter;
    }

    @Override
    public void onBindViewHolder(Myadapter holder, int position) {

        holder.name.setText(list.get(position).getName());
        holder.time.setText(list.get(position).getTime());
        holder.count.setText(list.get(position).getCount());
        holder.recy_grade.setLayoutManager(new GridLayoutManager(context,3));
        holder.recy_grade.setAdapter(new Recygradeadapter(context,lists));
        if (mCurrentItemDecoration != null)
            holder.recy_grade.removeItemDecoration(mCurrentItemDecoration);
      //  RecyclerViewStyleHelper.toGridView(mRecyclerView, 4);
        mCurrentItemDecoration = new RecyclerViewSpaceItemDecoration.Builder(context)
                //if horizontal and vertical spacing is the same size,just use margin(int size)
//                .margin(10)
                .marginHorizontal(10)
                .marginVertical(20)
                .create();
        holder.recy_grade.addItemDecoration(mCurrentItemDecoration);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myadapter extends RecyclerView.ViewHolder {
           TextView name,count,time;
           RecyclerView recy_grade;

        public Myadapter(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.gaditem_name);
            count= (TextView) itemView.findViewById(R.id.gaditem_count);
            time= (TextView) itemView.findViewById(R.id.gaditem_time);
            recy_grade= (RecyclerView) itemView.findViewById(R.id.recy_grade);
        }
    }
    private void data() {
        Imagebean imagebean4;
        for (int i = 0; i <6; i++) {
            imagebean4=new Imagebean();
            imagebean4.setImage(mUrls[i]);
            lists.add(imagebean4);
        }

    }


}
