package www.lexiang.com.lexiang.Fragment.message;

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

public class zhouBianActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_person;
    private View view_person;
    private TextView tv_shop;
    private View view_shop;
    private RecyclerView recyler_zhoubian;
    private LinearLayout activity_setting;
    private PersonAdapter mPersonAdapter;
    private List<String> mList;
    private ShopAdapter mShopAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhou_bian);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_person = (TextView) findViewById(R.id.tv_person);
        tv_person.setOnClickListener(this);
        view_person = (View) findViewById(R.id.view_person);
        tv_shop = (TextView) findViewById(R.id.tv_shop);
        tv_shop.setOnClickListener(this);
        view_shop = (View) findViewById(R.id.view_shop);
        recyler_zhoubian = (RecyclerView) findViewById(R.id.recyler_zhoubian);
        recyler_zhoubian.setLayoutManager(new LinearLayoutManager(this));
        activity_setting = (LinearLayout) findViewById(R.id.activity_setting);
        mList = new ArrayList<>();
        mList.add("");
        mList.add("");
        mList.add("");
        mPersonAdapter = new PersonAdapter(R.layout.item_zhoubian_person, mList);
        mShopAdapter = new ShopAdapter(R.layout.item_zhoubian_shop, mList);
        recyler_zhoubian.setAdapter(mPersonAdapter);
    }

    private class PersonAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public PersonAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {

        }
    }

    private class ShopAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public ShopAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
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
            case R.id.tv_person:
                view_person.setVisibility(View.VISIBLE);
                view_shop.setVisibility(View.GONE);
                recyler_zhoubian.setAdapter(mPersonAdapter);
                break;
            case R.id.tv_shop:
                view_person.setVisibility(View.GONE);
                view_shop.setVisibility(View.VISIBLE);
                recyler_zhoubian.setAdapter(mShopAdapter);
                break;
        }
    }
}
