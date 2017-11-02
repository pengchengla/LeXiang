package www.lexiang.com.lexiang.Fragment.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.view.CircleImageView;

public class MyDongTaiActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back;
    private CircleImageView iv_head;
    private TextView tv_nicheng;
    private TextView tv_dengji;
    private TextView tv_guanzhu_count;
    private TextView tv_fensi_count;
    private TextView tv_qianming;
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
        iv_head = (CircleImageView) findViewById(R.id.iv_head);
        iv_head.setOnClickListener(this);
        tv_nicheng = (TextView) findViewById(R.id.tv_nicheng);
        tv_dengji = (TextView) findViewById(R.id.tv_dengji);
        tv_guanzhu_count = (TextView) findViewById(R.id.tv_guanzhu_count);
        tv_fensi_count = (TextView) findViewById(R.id.tv_fensi_count);
        tv_qianming = (TextView) findViewById(R.id.tv_qianming);
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
            case R.id.iv_head:
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
