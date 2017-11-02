package www.lexiang.com.lexiang.Fragment.mine;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import www.lexiang.com.lexiang.R;

public class BlackNameActivity extends AppCompatActivity {

    private ImageView iv_back;
    private RecyclerView recycler_black;

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
        List<String> list=new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        BlackAdapter blackAdapter = new BlackAdapter(R.layout.item_black,list);
        recycler_black.setAdapter(blackAdapter);
    }

    private class BlackAdapter extends BaseQuickAdapter<String,BaseViewHolder>{

        public BlackAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {

        }
    }
}
