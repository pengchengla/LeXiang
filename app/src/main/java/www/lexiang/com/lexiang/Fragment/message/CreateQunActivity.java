package www.lexiang.com.lexiang.Fragment.message;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.view.CircleImageView;

public class CreateQunActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back;
    private CircleImageView iv_head;
    private LinearLayout ll_addhead;
    private EditText edt_name;
    private EditText edt_intro;
    private TextView tv_create;
    private LinearLayout activity_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_qun);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        iv_head = (CircleImageView) findViewById(R.id.iv_head);
        ll_addhead = (LinearLayout) findViewById(R.id.ll_addhead);
        ll_addhead.setOnClickListener(this);
        edt_name = (EditText) findViewById(R.id.edt_name);
        edt_intro = (EditText) findViewById(R.id.edt_intro);
        tv_create = (TextView) findViewById(R.id.tv_create);
        tv_create.setOnClickListener(this);
        activity_setting = (LinearLayout) findViewById(R.id.activity_setting);
    }

    private void submit() {
        // validate
//        String name = edt_name.getText().toString().trim();
//        if (TextUtils.isEmpty(name)) {
//            Toast.makeText(this, "name不能为空", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        String intro = edt_intro.getText().toString().trim();
//        if (TextUtils.isEmpty(intro)) {
//            Toast.makeText(this, "intro不能为空", Toast.LENGTH_SHORT).show();
//            return;
//        }

        startActivity(new Intent(this,QunChatActivity.class));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_addhead:
                break;
            case R.id.tv_create:
                submit();
                break;
        }
    }
}
