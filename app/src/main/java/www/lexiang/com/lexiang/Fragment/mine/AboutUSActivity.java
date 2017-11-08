package www.lexiang.com.lexiang.Fragment.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseActivity;

public class AboutUSActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private ImageView iv_share;
    private LinearLayout activity_modify_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        iv_share = (ImageView) findViewById(R.id.iv_share);
        activity_modify_name = (LinearLayout) findViewById(R.id.activity_modify_name);
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
