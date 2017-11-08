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

public class YijianActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_ok;
    private EditText edt_yijian;
    private EditText edt_email;
    private LinearLayout activity_modify_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yijian);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_ok = (TextView) findViewById(R.id.tv_ok);
        tv_ok.setOnClickListener(this);
        edt_yijian = (EditText) findViewById(R.id.edt_yijian);
        edt_email = (EditText) findViewById(R.id.edt_email);
        activity_modify_name = (LinearLayout) findViewById(R.id.activity_modify_name);
    }

    private void submit() {
        // validate
        String yijian = edt_yijian.getText().toString().trim();
        if (TextUtils.isEmpty(yijian)) {
            Toast.makeText(this, "您的意见", Toast.LENGTH_SHORT).show();
            return;
        }

        String email = edt_email.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "以便我们及时回复您的反馈", Toast.LENGTH_SHORT).show();
            return;
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_ok:
                finish();
                break;
        }
    }
}
