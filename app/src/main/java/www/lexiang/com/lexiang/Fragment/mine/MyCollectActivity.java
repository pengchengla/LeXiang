package www.lexiang.com.lexiang.Fragment.mine;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseActivity;

public class MyCollectActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private RecyclerView recycler_collect;
    private LinearLayout activity_black_name;
    private List<String> mList;
    private CollectAdapter mCollectAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collect);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        recycler_collect = (RecyclerView) findViewById(R.id.recycler_collect);
        recycler_collect.setLayoutManager(new LinearLayoutManager(this));
        activity_black_name = (LinearLayout) findViewById(R.id.activity_black_name);
        mList = new ArrayList<>();
        mList.add("");
        mList.add("");
        mList.add("");
        mCollectAdapter = new CollectAdapter(R.layout.item_collect, mList);
        recycler_collect.setAdapter(mCollectAdapter);
    }

    private class CollectAdapter extends BaseQuickAdapter<String,BaseViewHolder>{

        public CollectAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(final BaseViewHolder helper, String item) {
            helper.getView(R.id.right).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mList.remove(helper.getAdapterPosition());
                    notifyDataSetChanged();
                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
