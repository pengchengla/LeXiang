package www.lexiang.com.lexiang.Fragment.fragment;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.adapter.LifeAdapter;
import www.lexiang.com.lexiang.base.BaseFragment;
import www.lexiang.com.lexiang.bean.Bianminbean;
import www.lexiang.com.lexiang.bean.Lifebean;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class LifeFragment extends BaseFragment {

    private RecyclerView recy_lifeview;
    private Lifebean lifebean;
    private List<Lifebean> list=new ArrayList<>();

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected View initView() {
        View view=View.inflate(mContext, R.layout.fragment_life,null);
        recy_lifeview = (RecyclerView) view.findViewById(R.id.recy_lifeview);
        recy_lifeview.setLayoutManager(new LinearLayoutManager(getActivity()));

          inindata();
        LifeAdapter lifeAdapter=new LifeAdapter(getActivity(),list);
        recy_lifeview.setAdapter(lifeAdapter);
        scrollToFirst(false);



        return view;
    }
      private void inindata(){
          String [] title={
                          "求职招聘","房屋出租","二手淘淘","信息快递","装修建材","商务服务"
          };
          String []count={"求职","招聘","出租","出售","求组","出兑","求购","求售","义乌市场"
          ,"提供","需求","家装服务","工装服务","建房/翻修改造","建材","家具","家纺家饰","工商注册","投资担保"};

          for (int i = 0; i < title.length; i++) {

                  Lifebean lifebean=new Lifebean(title[i],count[i]);
                         list.add(lifebean);
          }

      }
    public void scrollToFirst(boolean isSmooth) {
        if ( recy_lifeview == null) {
            return;
        }
        if (isSmooth) {
            recy_lifeview.smoothScrollToPosition(0);
        } else {
            recy_lifeview.scrollToPosition(0);
        }
    }


}
