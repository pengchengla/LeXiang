package www.lexiang.com.lexiang.Fragment.message;

import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseFragment;
import www.lexiang.com.lexiang.view.BaseDialog;
import www.lexiang.com.lexiang.view.CircleImageView;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class MessageFragment extends BaseFragment implements View.OnClickListener {

    private List<String> mList;
    private ChatAdapter mChatAdapter;

    @Override
    protected void lazyLoad() {

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
    private RelativeLayout rl_wholookme;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_message, null);
        tv_msg = (TextView) view.findViewById(R.id.tv_msg);
        tv_msg.setOnClickListener(this);
        tv_contacts = (TextView) view.findViewById(R.id.tv_contacts);
        tv_contacts.setOnClickListener(this);
        tv_zhoubian = (TextView) view.findViewById(R.id.tv_zhoubian);
        tv_zhoubian.setOnClickListener(this);
        iv_person1 = (CircleImageView) view.findViewById(R.id.iv_person1);
        iv_person2 = (CircleImageView) view.findViewById(R.id.iv_person2);
        iv_person3 = (CircleImageView) view.findViewById(R.id.iv_person3);
        tv_person_count = (TextView) view.findViewById(R.id.tv_person_count);
        iv_arrow = (ImageView) view.findViewById(R.id.iv_arrow);
        recycler_chat = (RecyclerView) view.findViewById(R.id.recycler_chat);
        recycler_chat.setLayoutManager(new LinearLayoutManager(mContext));
        rl_wholookme = (RelativeLayout) view.findViewById(R.id.rl_wholookme);
        rl_wholookme.setOnClickListener(this);
        /*
          加载数据
         */
        mList = new ArrayList<>();
        mList.add("");
        mList.add("");
        mList.add("");
        mList.add("");
        mChatAdapter = new ChatAdapter(R.layout.item_chat, mList);
        recycler_chat.setAdapter(mChatAdapter);
        mChatAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                showDialog(Gravity.CENTER, R.style.Alpah_aniamtion, position);
                return false;
            }
        });
        return view;
    }

    private void showDialog(int grary, int animationStyle, final int position) {
        BaseDialog.Builder builder = new BaseDialog.Builder(mContext);
        final BaseDialog dialog = builder.setViewId(R.layout.dialog_chat)
                //设置dialogpadding
                .setPaddingdp(10, 0, 10, 0)
                //设置显示位置
                .setGravity(grary)
                //设置动画
                .setAnimation(animationStyle)
                //设置dialog的宽高
                .setWidthHeightpx(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                //设置触摸dialog外围是否关闭
                .isOnTouchCanceled(true)
                //设置监听事件
                .builder();
        dialog.show();
        dialog.getView(R.id.tv_zhiding).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.getView(R.id.tv_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                mList.remove(position);
                mChatAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_msg:
                break;
            case R.id.tv_contacts:
                startActivity(new Intent(mContext, ContactsActivity.class));
                break;
            case R.id.tv_zhoubian:
                startActivity(new Intent(mContext, zhouBianActivity.class));
                break;
            case R.id.rl_wholookme:
                startActivity(new Intent(mContext, WhoLookMeActivity.class));
                break;
        }
    }

    private class ChatAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public ChatAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {

        }
    }
}
