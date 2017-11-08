package www.lexiang.com.lexiang.Fragment.mine;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseActivity;
import www.lexiang.com.lexiang.bean.HangyeBean;

public class ServiceAddActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private EditText edt_title;
    private EditText edt_content;
    private LinearLayout ll_addphoto_sample;
    private LinearLayout ll_addphoto;
    private EditText edt_mobile;
    private RadioButton rb_goservice_yes;
    private RadioButton rb_goservice_no;
    private RadioGroup rgp_goservice;
    private RadioButton rb_jineng_yes;
    private RadioButton rb_jineng_no;
    private RadioGroup rgp_jineng;
    private RecyclerView recycler_hangye;
    private TextView tv_submit;
    private LinearLayout activity_setting;
    private List<HangyeBean> mStringList = new ArrayList<>();
    private HangyeAdapter mHangyeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_add);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        edt_title = (EditText) findViewById(R.id.edt_title);
        edt_content = (EditText) findViewById(R.id.edt_content);
        ll_addphoto_sample = (LinearLayout) findViewById(R.id.ll_addphoto_sample);
        ll_addphoto_sample.setOnClickListener(this);
        ll_addphoto = (LinearLayout) findViewById(R.id.ll_addphoto);
        ll_addphoto.setOnClickListener(this);
        edt_mobile = (EditText) findViewById(R.id.edt_mobile);
        rb_goservice_yes = (RadioButton) findViewById(R.id.rb_goservice_yes);
        rb_goservice_no = (RadioButton) findViewById(R.id.rb_goservice_no);
        rgp_goservice = (RadioGroup) findViewById(R.id.rgp_goservice);
        rb_jineng_yes = (RadioButton) findViewById(R.id.rb_jineng_yes);
        rb_jineng_no = (RadioButton) findViewById(R.id.rb_jineng_no);
        rgp_jineng = (RadioGroup) findViewById(R.id.rgp_jineng);
        recycler_hangye = (RecyclerView) findViewById(R.id.recycler_hangye);
        recycler_hangye.setLayoutManager(new GridLayoutManager(this, 3));
        tv_submit = (TextView) findViewById(R.id.tv_submit);
        tv_submit.setOnClickListener(this);
        activity_setting = (LinearLayout) findViewById(R.id.activity_setting);
        mStringList.add(new HangyeBean("技能传授"));
        mStringList.add(new HangyeBean("匠人工艺"));
        mStringList.add(new HangyeBean("培训辅导"));
        mStringList.add(new HangyeBean("代办代购"));
        mStringList.add(new HangyeBean("技能服务"));
        mStringList.add(new HangyeBean("奇思妙想"));
        mStringList.add(new HangyeBean("情感解压"));
        mStringList.add(new HangyeBean("行业咨询"));
        mStringList.add(new HangyeBean("其他"));
        mStringList.get(0).setChecked(true);
        mHangyeAdapter = new HangyeAdapter(R.layout.item_hangye, mStringList);
        recycler_hangye.setAdapter(mHangyeAdapter);
    }

    private class HangyeAdapter extends BaseQuickAdapter<HangyeBean, BaseViewHolder> {

        public HangyeAdapter(@LayoutRes int layoutResId, @Nullable List<HangyeBean> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(final BaseViewHolder helper, HangyeBean item) {
            helper.setText(R.id.tv_title, item.getContent());
            if (item.isChecked()) {
                Glide.with(mContext).load(R.drawable.icon_duihao).into((ImageView) helper.getView(R.id.iv_ischeck));
            } else {
                Glide.with(mContext).load("").into((ImageView) helper.getView(R.id.iv_ischeck));
            }
            helper.getView(R.id.fl_root_view).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int i = 0; i < mStringList.size(); i++) {
                        if (i == helper.getAdapterPosition()) {
                            mStringList.get(i).setChecked(true);
                        } else {
                            mStringList.get(i).setChecked(false);
                        }
                    }
                    mHangyeAdapter.setNewData(mStringList);
                    mHangyeAdapter.notifyDataSetChanged();
                }
            });
        }
    }

    private void submit() {
        // validate
        String title = edt_title.getText().toString().trim();
        if (TextUtils.isEmpty(title)) {
            Toast.makeText(this, "会员怎么开", Toast.LENGTH_SHORT).show();
            return;
        }

        String content = edt_content.getText().toString().trim();
        if (TextUtils.isEmpty(content)) {
            Toast.makeText(this, "请输入内容", Toast.LENGTH_SHORT).show();
            return;
        }

        String mobile = edt_mobile.getText().toString().trim();
        if (TextUtils.isEmpty(mobile)) {
            Toast.makeText(this, "mobile不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_addphoto_sample://添加图片
                break;
            case R.id.ll_addphoto://添加进来的图片的容器
                break;
            case R.id.tv_submit:
                submit();
                break;
        }
    }
}
