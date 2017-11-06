package www.lexiang.com.lexiang.Fragment.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import www.lexiang.com.lexiang.R;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back;
    private RelativeLayout rl_yijian;
    private TextView tv_cache_m;
    private RelativeLayout rl_cache;
    private RelativeLayout rl_aboutus;
    private RelativeLayout rl_version;
    private LinearLayout activity_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        rl_yijian = (RelativeLayout) findViewById(R.id.rl_yijian);
        rl_yijian.setOnClickListener(this);
        tv_cache_m = (TextView) findViewById(R.id.tv_cache_m);
        rl_cache = (RelativeLayout) findViewById(R.id.rl_cache);
        rl_cache.setOnClickListener(this);
        rl_aboutus = (RelativeLayout) findViewById(R.id.rl_aboutus);
        rl_aboutus.setOnClickListener(this);
        rl_version = (RelativeLayout) findViewById(R.id.rl_version);
        rl_version.setOnClickListener(this);
        activity_setting = (LinearLayout) findViewById(R.id.activity_setting);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_yijian:
                startActivity(new Intent(this,YijianActivity.class));
                break;
            case R.id.rl_cache:
                break;
            case R.id.rl_aboutus:
                startActivity(new Intent(this,AboutUSActivity.class));
                break;
            case R.id.rl_version:
                break;
        }
    }
}
