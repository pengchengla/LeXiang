package www.lexiang.com.lexiang.Fragment.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import www.lexiang.com.lexiang.R;

public class PersonIntroActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView iv_back;
    private TextView tv_ok;
    private EditText edt_intro;
    private TextView tv_currtextsize;
    private LinearLayout activity_modify_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_intro);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        tv_ok = (TextView) findViewById(R.id.tv_ok);
        iv_back.setOnClickListener(this);
        tv_ok.setOnClickListener(this);
        edt_intro = (EditText) findViewById(R.id.edt_intro);
        tv_currtextsize = (TextView) findViewById(R.id.tv_currtextsize);
        activity_modify_name = (LinearLayout) findViewById(R.id.activity_modify_name);
    }

    private void submit() {
        String intro = edt_intro.getText().toString().trim();
        if (TextUtils.isEmpty(intro)) {
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
                submit();
                break;
        }
    }
}
