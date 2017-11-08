package www.lexiang.com.lexiang.Fragment.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseActivity;
import www.lexiang.com.lexiang.view.CircleImageView;

public class MyServiceDetailActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private ImageView iv_share;
    private CircleImageView iv_head;
    private TextView tv_name;
    private TextView tv_time;
    private TextView tv_title, tv_reedit;
    private TextView tv_content;
    private TextView tv_dianzancount;
    private ImageView iv_dianzan;
    private RecyclerView recycler_dianzan;
    private TextView tv_msg_count;
    private RecyclerView recycler_comment;
    private DianZanAdapter mDianZanAdapter;
    private CommentAdapter mCommentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service_detail);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_reedit = (TextView) findViewById(R.id.tv_reedit);
        tv_reedit.setOnClickListener(this);
        iv_share = (ImageView) findViewById(R.id.iv_share);
        iv_share.setOnClickListener(this);
        iv_head = (CircleImageView) findViewById(R.id.iv_head);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_time = (TextView) findViewById(R.id.tv_time);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_content = (TextView) findViewById(R.id.tv_content);
        tv_dianzancount = (TextView) findViewById(R.id.tv_dianzancount);
        iv_dianzan = (ImageView) findViewById(R.id.iv_dianzan);
        iv_dianzan.setOnClickListener(this);
        recycler_dianzan = (RecyclerView) findViewById(R.id.recycler_dianzan);
        recycler_dianzan.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recycler_dianzan.setNestedScrollingEnabled(false);
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        mDianZanAdapter = new DianZanAdapter(R.layout.item_dianzan, list);
        recycler_dianzan.setAdapter(mDianZanAdapter);
        tv_msg_count = (TextView) findViewById(R.id.tv_msg_count);
        recycler_comment = (RecyclerView) findViewById(R.id.recycler_comment);
        recycler_comment.setLayoutManager(new LinearLayoutManager(this));
        recycler_comment.setNestedScrollingEnabled(false);
        mCommentAdapter = new CommentAdapter(R.layout.item_service_comment, list);
        recycler_comment.setAdapter(mCommentAdapter);
    }

    private class DianZanAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public DianZanAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            Glide.with(mContext).load(R.drawable.defaulthead).into((ImageView) helper.getView(R.id.iv_head));
        }
    }

    private class CommentAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public CommentAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_share:
                break;
            case R.id.iv_dianzan:
                break;
            case R.id.tv_reedit:
                Intent intent = new Intent(this, CreateService2Activity.class);
                intent.putExtra("edit", "edit");
                startActivity(intent);
                break;
        }
    }
}
