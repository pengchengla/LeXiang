package www.lexiang.com.lexiang.Fragment.message;

import android.view.View;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseFragment;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class MessageFragment extends BaseFragment {
    @Override
    protected void lazyLoad() {
        /*
          加载数据
         */

    }

    @Override
    protected View initView() {
        View view=View.inflate(mContext, R.layout.fragment_message,null);
        return view;
    }
}
