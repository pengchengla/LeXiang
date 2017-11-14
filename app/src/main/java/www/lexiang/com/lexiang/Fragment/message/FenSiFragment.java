package www.lexiang.com.lexiang.Fragment.message;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseFragment;
import www.lexiang.com.lexiang.view.BaseDialog;

/**
 * Created by Administrator on 2017/11/10.
 */
public class FenSiFragment extends BaseFragment {
    private RecyclerView recycler_fensi;

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_guanzhu, null);
        recycler_fensi = (RecyclerView) view.findViewById(R.id.recycler_guanzhu);
        recycler_fensi.setLayoutManager(new LinearLayoutManager(mContext));
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        FensiAdapter fensiAdapter = new FensiAdapter(R.layout.item_fensi, list);
        recycler_fensi.setAdapter(fensiAdapter);
        return view;
    }

    private void showDialog(int grary, int animationStyle, final TextView tv_guanzhu) {
        BaseDialog.Builder builder = new BaseDialog.Builder(mContext);
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

    class FensiAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

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
                        showDialog(Gravity.CENTER, R.style.Alpah_aniamtion, tv_guanzhu);
                    }
                }
            });
        }
    }
}
