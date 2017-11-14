package www.lexiang.com.lexiang.Fragment.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseActivity;

public class CreateService5Activity extends BaseActivity implements View.OnClickListener{
    private ImageView iv_back;
    private TextView tv_content;
    private TextView tv_addservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_service3);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_content = (TextView) findViewById(R.id.tv_content);
        tv_content.setText("提交成功");
        tv_addservice = (TextView) findViewById(R.id.tv_addservice);
        tv_addservice.setVisibility(View.VISIBLE);
        tv_addservice.setText("查看详情");
        tv_addservice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_addservice:
                startActivity(new Intent(this, MyServiceDetailActivity.class));
                break;
        }
    }
}
