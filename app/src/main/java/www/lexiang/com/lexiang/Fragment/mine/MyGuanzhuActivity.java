package www.lexiang.com.lexiang.Fragment.mine;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

public class MyGuanzhuActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_fensi_count;
    private RecyclerView recycler_guanzhu;
    private LinearLayout activity_modify_psw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_guanzhu);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_fensi_count = (TextView) findViewById(R.id.tv_fensi_count);
        recycler_guanzhu = (RecyclerView) findViewById(R.id.recycler_guanzhu);
        activity_modify_psw = (LinearLayout) findViewById(R.id.activity_modify_psw);
        recycler_guanzhu.setLayoutManager(new LinearLayoutManager(this));
        ArrayList mList = new ArrayList<>();
        mList.add("");
        mList.add("");
        mList.add("");
        GuanZhuAdapter fensiAdapter = new GuanZhuAdapter(R.layout.item_fensi, mList);
        recycler_guanzhu.setAdapter(fensiAdapter);
    }

    private class GuanZhuAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public GuanZhuAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
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
        }
    }
}
