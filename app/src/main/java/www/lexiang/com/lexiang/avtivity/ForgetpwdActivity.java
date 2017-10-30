package www.lexiang.com.lexiang.avtivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.avtivity.fragment.AffirmpwdActivity;
import www.lexiang.com.lexiang.base.BaseActivity;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class ForgetpwdActivity extends BaseActivity implements View.OnClickListener {
    private ImageView fan;
    private RelativeLayout tv_back;
    private TextView include_zhong;
    private TextView include_right;
    private EditText forget_phone;
    private EditText forget_yanzhengma;
    private TextView tv_getcode;
    private EditText forget_yanzhengma2;
    private TextView tv_getcode2;
    private Button btn_next;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpwd);
        initView();
    }

    private void initView() {
        fan = (ImageView) findViewById(R.id.fan);
        tv_back = (RelativeLayout) findViewById(R.id.tv_back);
        include_zhong = (TextView) findViewById(R.id.include_zhong);
        include_right = (TextView) findViewById(R.id.include_right);
        forget_phone = (EditText) findViewById(R.id.forget_phone);
        forget_yanzhengma = (EditText) findViewById(R.id.forget_yanzhengma);
        tv_getcode = (TextView) findViewById(R.id.tv_getcode);
        forget_yanzhengma2 = (EditText) findViewById(R.id.forget_yanzhengma2);
        tv_getcode2 = (TextView) findViewById(R.id.tv_getcode2);
        btn_next = (Button) findViewById(R.id.btn_next);
        tv_back.setOnClickListener(this);
        btn_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                /*
                  跳转到下一步
                 */
                Intent intent=new Intent(this, AffirmpwdActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.tv_back:
                finish();
                break;
        }
    }

    private void submit() {
        // validate
        String phone = forget_phone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        String yanzhengma = forget_yanzhengma.getText().toString().trim();
        if (TextUtils.isEmpty(yanzhengma)) {
            Toast.makeText(this, "输入验证码", Toast.LENGTH_SHORT).show();
            return;
        }

        String yanzhengma2 = forget_yanzhengma2.getText().toString().trim();
        if (TextUtils.isEmpty(yanzhengma2)) {
            Toast.makeText(this, "输入验证码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
