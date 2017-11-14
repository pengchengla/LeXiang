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
    private RecyclerView recycler_tupian;
    private RecyclerView recycler_comment;
    private PhotoAdapter mPhotoAdapter;
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
        recycler_tupian = (RecyclerView) findViewById(R.id.recycler_tupian);
        recycler_tupian.setLayoutManager(new LinearLayoutManager(this));
        recycler_tupian.setNestedScrollingEnabled(false);
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        mPhotoAdapter = new PhotoAdapter(R.layout.item_photo, list);
        recycler_tupian.setAdapter(mPhotoAdapter);
        recycler_comment = (RecyclerView) findViewById(R.id.recycler_comment);
        recycler_comment.setLayoutManager(new LinearLayoutManager(this));
        recycler_comment.setNestedScrollingEnabled(false);
        mCommentAdapter = new CommentAdapter(R.layout.item_service_comment, list);
        recycler_comment.setAdapter(mCommentAdapter);
    }

    private class PhotoAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public PhotoAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            Glide.with(mContext).load(R.drawable.home_title).into((ImageView) helper.getView(R.id.iv_head));
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
            case R.id.tv_reedit:
                Intent intent = new Intent(this, ServiceAddActivity.class);
                startActivity(intent);
                break;
        }
    }
}
