package www.lexiang.com.lexiang.Fragment.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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

public class MyServiceActivity extends AppCompatActivity implements View.OnClickListener {

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
        List<String> list=new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        mServiceAdapter = new ServiceAdapter(R.layout.item_myservice,list);
        recycler_service.setAdapter(mServiceAdapter);
        mServiceAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(MyServiceActivity.this,MyServiceDetailActivity.class));
            }
        });
    }

    private class ServiceAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public ServiceAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
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
            case R.id.tv_add:
                Intent intent = new Intent(this, CreateService2Activity.class);
                intent.putExtra("edit","edit");
                startActivity(intent);
                break;
        }
    }
}
