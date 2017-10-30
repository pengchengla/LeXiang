package www.lexiang.com.lexiang.Fragment.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.adapter.Bianminadapter;
import www.lexiang.com.lexiang.base.BaseFragment;
import www.lexiang.com.lexiang.bean.Bianminbean;
import www.lexiang.com.lexiang.utils.DividerGridItemDecoration;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class BianminFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private List<Bianminbean> list=new ArrayList<>();
    private Bianminbean bianbean;

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected View initView() {
        View view=View.inflate(mContext, R.layout.fragment_bianmin,null);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_bianmin);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),4));
        //添加数据
        indata();
         //设置适配器
        Bianminadapter bianminadapter=new Bianminadapter(getActivity(),list);
        recyclerView.setAdapter(bianminadapter);
        recyclerView.addItemDecoration(new DividerGridItemDecoration(getActivity()));
        return view;
    }

    private void indata() {
        /*
          添加数据
         */
         int [] image={R.drawable.bianmin_daijia,R.drawable.bianmin_picture,R.drawable.bianmin_kuaidi
       ,R.drawable.bianmin_banjia,R.drawable.bianmin_water,
      R.drawable.bianmin_washer,R.drawable.bianmin_yanghu,R.drawable.bianmin_injecting,R.drawable.bianmin_waimai,
    R.drawable.bianmin_jiadian,R.drawable.bianmin_jiazheng,R.drawable.bianmin_nanny,R.drawable.bianmin_shuilongtou
         ,R.drawable.bianmin_computer,R.drawable.bianmin_dianmuan,R.drawable.bianmin_zuankong,R.drawable.bianmin_kaisuo
         ,R.drawable.bianmin_weixiu,R.drawable.bianmin_paotui};
        String[] count={
                "代驾","快照/复印","快递","搬家","桶装水","洗衣/洗鞋","皮具养护","上门打针","外卖订餐"
                ,"家电清洗","家政服务","保姆/月嫂","疏通管道","电脑维修","水暖维修","钻孔打眼","开锁换锁"
                ,"家电维修","跑腿"
        };
        for (int i = 0; i <image.length ; i++) {
            bianbean = new Bianminbean(image[i],count[i]);
            list.add(bianbean);
        }

    }
}
