package www.lexiang.com.lexiang.Fragment.mine;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseActivity;

public class ModifyPswActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private EditText edt_psw;
    private EditText edt_psw2;
    private EditText edt_psw3;
    private TextView tv_submit;
    private LinearLayout activity_modify_psw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_psw);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        edt_psw = (EditText) findViewById(R.id.edt_psw);
        edt_psw2 = (EditText) findViewById(R.id.edt_psw2);
        edt_psw3 = (EditText) findViewById(R.id.edt_psw3);
        tv_submit = (TextView) findViewById(R.id.tv_submit);
        tv_submit.setOnClickListener(this);
        activity_modify_psw = (LinearLayout) findViewById(R.id.activity_modify_psw);
    }

    private void submit() {
        // validate
        String psw = edt_psw.getText().toString().trim();
        if (TextUtils.isEmpty(psw)) {
            Toast.makeText(this, "输入旧密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String psw2 = edt_psw2.getText().toString().trim();
        if (TextUtils.isEmpty(psw2)) {
            Toast.makeText(this, "输入新密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String psw3 = edt_psw3.getText().toString().trim();
        if (TextUtils.isEmpty(psw3)) {
            Toast.makeText(this, "确认新密码", Toast.LENGTH_SHORT).show();
            return;
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_submit:
                submit();
                break;
        }
    }
}
