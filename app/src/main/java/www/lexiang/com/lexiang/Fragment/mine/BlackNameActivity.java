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

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseActivity;
import www.lexiang.com.lexiang.view.BaseDialog;

public class BlackNameActivity extends BaseActivity {

    private ImageView iv_back;
    private RecyclerView recycler_black;
    private List<String> mList;
    private BlackAdapter mBlackAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_name);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        recycler_black = (RecyclerView) findViewById(R.id.recycler_black);
        recycler_black.setLayoutManager(new LinearLayoutManager(this));
        mList = new ArrayList<>();
        mList.add("");
        mList.add("");
        mList.add("");
        mBlackAdapter = new BlackAdapter(R.layout.item_black, mList);
        recycler_black.setAdapter(mBlackAdapter);
        mBlackAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                showDialog(Gravity.CENTER, R.style.Alpah_aniamtion,position);
                return false;
            }
        });
    }

    private class BlackAdapter extends BaseQuickAdapter<String,BaseViewHolder>{

        public BlackAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(final BaseViewHolder helper, String item) {

        }
    }

    private void showDialog(int grary, int animationStyle, final int position) {
        BaseDialog.Builder builder =  new BaseDialog.Builder(this);
        final BaseDialog dialog = builder.setViewId(R.layout.dialog_black)
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
                mList.remove(position);
                mBlackAdapter.notifyDataSetChanged();
            }
        });
    }
}
