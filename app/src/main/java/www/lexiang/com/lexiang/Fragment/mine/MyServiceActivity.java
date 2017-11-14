package www.lexiang.com.lexiang.Fragment.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseActivity;
import www.lexiang.com.lexiang.view.BaseDialog;

public class MyServiceActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_add;
    private RecyclerView recycler_service;
    private LinearLayout activity_modify_name;
    private ServiceAdapter mServiceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_add = (TextView) findViewById(R.id.tv_add);
        tv_add.setOnClickListener(this);
        recycler_service = (RecyclerView) findViewById(R.id.recycler_service);
        activity_modify_name = (LinearLayout) findViewById(R.id.activity_modify_name);
        recycler_service.setLayoutManager(new LinearLayoutManager(this));
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        mServiceAdapter = new ServiceAdapter(R.layout.item_myservice, list);
        recycler_service.setAdapter(mServiceAdapter);
        mServiceAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(MyServiceActivity.this, MyServiceDetailActivity.class));
            }
        });
    }

    private class ServiceAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public ServiceAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            helper.getView(R.id.tv_refresh_time).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showRefreshDialog(Gravity.CENTER, R.style.Alpah_aniamtion);
                }
            });
        }
    }

    private void showRefreshDialog(int grary, int animationStyle) {
        BaseDialog.Builder builder = new BaseDialog.Builder(this);
        final BaseDialog dialog = builder.setViewId(R.layout.dialog_jifen)
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
        TextView tv_content = dialog.getView(R.id.tv_content);
        TextView tv_canel = dialog.getView(R.id.tv_canel);
        tv_canel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //关闭dialog
                dialog.close();
            }
        });
        TextView tv_yes = dialog.getView(R.id.tv_yes);
        tv_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //关闭dialog
                dialog.close();
                showRefreshDialog(Gravity.CENTER, R.style.Alpah_aniamtion);
            }
        });
    }

    private void showAddJIfenDialog(int grary, int animationStyle) {
        BaseDialog.Builder builder = new BaseDialog.Builder(this);
        final BaseDialog dialog = builder.setViewId(R.layout.dialog_jifen)
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
        TextView tv_content = dialog.getView(R.id.tv_content);
        tv_content.setText("积分不够是否联系客服购买积分?");
        TextView tv_canel = dialog.getView(R.id.tv_canel);
        tv_canel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //关闭dialog
                dialog.close();
            }
        });
        TextView tv_yes = dialog.getView(R.id.tv_yes);
        tv_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //关闭dialog
                dialog.close();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_add:
                Intent intent = new Intent(this, ServiceAddActivity.class);
                startActivity(intent);
                break;
        }
    }
}
