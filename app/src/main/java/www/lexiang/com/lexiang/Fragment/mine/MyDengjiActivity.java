package www.lexiang.com.lexiang.Fragment.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseActivity;
import www.lexiang.com.lexiang.view.CircleImageView;

public class MyDengjiActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private CircleImageView iv_head;
    private TextView tv_nicheng;
    private TextView tv_dengji;
    private TextView tv_jingyanzhi;
    private TextView tv_curr_jingyanzhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dengji);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        iv_head = (CircleImageView) findViewById(R.id.iv_head);
        tv_nicheng = (TextView) findViewById(R.id.tv_nicheng);
        tv_dengji = (TextView) findViewById(R.id.tv_dengji);
        tv_jingyanzhi = (TextView) findViewById(R.id.tv_jingyanzhi);
        tv_curr_jingyanzhi = (TextView) findViewById(R.id.tv_curr_jingyanzhi);
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
