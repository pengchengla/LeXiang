package www.lexiang.com.lexiang.Fragment.message;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseActivity;

public class QunIntroActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_name;
    private TextView tv_intro;
    private TextView tv_qun_count;
    private TextView tv_join;
    private LinearLayout activity_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qun_intro);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_intro = (TextView) findViewById(R.id.tv_intro);
        tv_qun_count = (TextView) findViewById(R.id.tv_qun_count);
        tv_join = (TextView) findViewById(R.id.tv_join);
        tv_join.setOnClickListener(this);
        activity_setting = (LinearLayout) findViewById(R.id.activity_setting);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_join:
                break;
        }
    }
}
