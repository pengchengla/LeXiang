package www.lexiang.com.lexiang.Fragment.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseActivity;

public class MyDongTaiActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_qwsj;
    private TextView tv_locallife;
    private TextView tv_dajiabang;
    private TextView tv_bianminfuwu;
    private TextView tv_tongcheng;
    private TextView tv_tancheng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dong_tai);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_qwsj = (TextView) findViewById(R.id.tv_qwsj);
        tv_qwsj.setOnClickListener(this);
        tv_locallife = (TextView) findViewById(R.id.tv_locallife);
        tv_locallife.setOnClickListener(this);
        tv_dajiabang = (TextView) findViewById(R.id.tv_dajiabang);
        tv_dajiabang.setOnClickListener(this);
        tv_bianminfuwu = (TextView) findViewById(R.id.tv_bianminfuwu);
        tv_bianminfuwu.setOnClickListener(this);
        tv_tongcheng = (TextView) findViewById(R.id.tv_tongcheng);
        tv_tongcheng.setOnClickListener(this);
        tv_tancheng = (TextView) findViewById(R.id.tv_tancheng);
        tv_tancheng.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_qwsj:
                break;
            case R.id.tv_locallife:
                break;
            case R.id.tv_dajiabang:
                break;
            case R.id.tv_bianminfuwu:
                break;
            case R.id.tv_tongcheng:
                break;
            case R.id.tv_tancheng:
                break;
        }
    }
}
