package www.lexiang.com.lexiang.Fragment.message;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseFragment;
import www.lexiang.com.lexiang.view.CircleImageView;

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

    private TextView tv_msg;
    private TextView tv_contacts;
    private TextView tv_zhoubian;
    private CircleImageView iv_person1;
    private CircleImageView iv_person2;
    private CircleImageView iv_person3;
    private TextView tv_person_count;
    private ImageView iv_arrow;
    private RecyclerView recycler_chat;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_message, null);
        tv_msg = (TextView) view.findViewById(R.id.tv_msg);
        tv_contacts = (TextView) view.findViewById(R.id.tv_contacts);
        tv_zhoubian = (TextView) view.findViewById(R.id.tv_zhoubian);
        iv_person1 = (CircleImageView) view.findViewById(R.id.iv_person1);
        iv_person2 = (CircleImageView) view.findViewById(R.id.iv_person2);
        iv_person3 = (CircleImageView) view.findViewById(R.id.iv_person3);
        tv_person_count = (TextView) view.findViewById(R.id.tv_person_count);
        iv_arrow = (ImageView) view.findViewById(R.id.iv_arrow);
        recycler_chat = (RecyclerView) view.findViewById(R.id.recycler_chat);
        return view;
    }
}
