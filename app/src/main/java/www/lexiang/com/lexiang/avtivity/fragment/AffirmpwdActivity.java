package www.lexiang.com.lexiang.avtivity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseActivity;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class AffirmpwdActivity extends BaseActivity implements View.OnClickListener {
    private ImageView fan;
    private RelativeLayout tv_back;
    private TextView include_zhong;
    private TextView include_right;
    private EditText alter_pwd;
    private EditText affirm_pwd;
    private Button   btn_finfish;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_ok);
        initView();
    }

    private void initView() {
        fan = (ImageView) findViewById(R.id.fan);
        tv_back = (RelativeLayout) findViewById(R.id.tv_back);
        include_zhong = (TextView) findViewById(R.id.include_zhong);
        include_right = (TextView) findViewById(R.id.include_right);
        alter_pwd = (EditText) findViewById(R.id.alter_pwd);
        affirm_pwd = (EditText) findViewById(R.id.affirm_pwd);
        btn_finfish = (Button) findViewById(R.id.btn_finish);
        tv_back.setOnClickListener(this);
        btn_finfish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_finish:
                finish();

                break;
            case R.id.tv_back:
                finish();
                break;
        }
    }

    private void submit() {
        // validate
        String pwd = alter_pwd.getText().toString().trim();
        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "输入新密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String pwds = affirm_pwd.getText().toString().trim();
        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "确认密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
