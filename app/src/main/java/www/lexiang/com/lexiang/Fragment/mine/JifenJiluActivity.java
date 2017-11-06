package www.lexiang.com.lexiang.Fragment.mine;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import www.lexiang.com.lexiang.R;

public class JifenJiluActivity extends AppCompatActivity {

    private ImageView iv_back;
    private RecyclerView recycler_jifen;
    private LinearLayout activity_jifen_jilu;
    private List<String> mList;
    private JIfenAdapter mJIfenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jifen_jilu);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        recycler_jifen = (RecyclerView) findViewById(R.id.recycler_jifen);
        recycler_jifen.setLayoutManager(new LinearLayoutManager(this));
        activity_jifen_jilu = (LinearLayout) findViewById(R.id.activity_jifen_jilu);
        mList = new ArrayList<>();
        mList.add("");
        mList.add("");
        mList.add("");
        mJIfenAdapter = new JIfenAdapter(R.layout.item_jifenjilu,mList);
        recycler_jifen.setAdapter(mJIfenAdapter);
    }

    private class JIfenAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public JIfenAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {

        }
    }
}
