package www.lexiang.com.lexiang.Fragment.mine;

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

public class MyFensiActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_fensi_count;
    private RecyclerView recycler_fensi;
    private LinearLayout activity_modify_psw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fensi);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_fensi_count = (TextView) findViewById(R.id.tv_fensi_count);
        recycler_fensi = (RecyclerView) findViewById(R.id.recycler_fensi);
        activity_modify_psw = (LinearLayout) findViewById(R.id.activity_modify_psw);
        recycler_fensi.setLayoutManager(new LinearLayoutManager(this));
        ArrayList mList = new ArrayList<>();
        mList.add("");
        mList.add("");
        mList.add("");
        FensiAdapter fensiAdapter = new FensiAdapter(R.layout.item_fensi, mList);
        recycler_fensi.setAdapter(fensiAdapter);
    }

    private class FensiAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public FensiAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            final TextView tv_guanzhu = helper.getView(R.id.tv_guanzhu);
            tv_guanzhu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (tv_guanzhu.getText().toString().equals("互相关注")) {
                        tv_guanzhu.setText("已关注");
                    } else {
                        showDialog(Gravity.CENTER, R.style.Alpah_aniamtion,tv_guanzhu);
                    }
                }
            });
        }
    }

    private void showDialog(int grary, int animationStyle, final TextView tv_guanzhu) {
        BaseDialog.Builder builder = new BaseDialog.Builder(this);
        final BaseDialog dialog = builder.setViewId(R.layout.dialog_guanzhu)
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
        dialog.getView(R.id.tv_canel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.getView(R.id.tv_yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                tv_guanzhu.setText("互相关注");
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

}
