package www.lexiang.com.lexiang.Fragment.fragment;

import android.view.View;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseFragment;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class BlockFragment extends BaseFragment {
    @Override
    protected void lazyLoad() {

    }

    @Override
    protected View initView() {
        View view=View.inflate(mContext, R.layout.fragment_xiaoqu,null);
        return view;
    }
}
