package www.lexiang.com.lexiang.Fragment.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseActivity;

public class CreateService3Activity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_content;
    private TextView tv_addservice;
    private LinearLayout activity_create_service3;

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
        tv_addservice = (TextView) findViewById(R.id.tv_addservice);
        startActivity(new Intent(this,CreateService4Activity.class));
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
