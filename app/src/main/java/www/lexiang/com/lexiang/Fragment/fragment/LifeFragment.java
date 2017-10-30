package www.lexiang.com.lexiang.Fragment.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseFragment;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class LifeFragment extends BaseFragment {

    private RecyclerView recy_lifeview;

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected View initView() {
        View view=View.inflate(mContext, R.layout.fragment_life,null);
        recy_lifeview = (RecyclerView) view.findViewById(R.id.recy_lifeview);
        recy_lifeview.setLayoutManager(new LinearLayoutManager(getActivity()));
        //recy_lifeview.setAdapter();

        return view;
    }
}
