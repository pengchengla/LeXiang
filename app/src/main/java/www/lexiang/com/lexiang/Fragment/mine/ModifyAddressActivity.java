package www.lexiang.com.lexiang.Fragment.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import www.lexiang.com.lexiang.R;

public class ModifyAddressActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_ok;
    private TextView tv_address;
    private EditText edt_detail_address;
    private LinearLayout activity_modify_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_address);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        tv_ok = (TextView) findViewById(R.id.tv_ok);
        iv_back.setOnClickListener(this);
        tv_ok.setOnClickListener(this);
        tv_address = (TextView) findViewById(R.id.tv_address);
        tv_address.setOnClickListener(this);
        edt_detail_address = (EditText) findViewById(R.id.edt_detail_address);
        activity_modify_address = (LinearLayout) findViewById(R.id.activity_modify_address);
    }

    private void submit() {
        // validate
        String address = edt_detail_address.getText().toString().trim();
        if (TextUtils.isEmpty(address)) {
            Toast.makeText(this, "请输入详细地址", Toast.LENGTH_SHORT).show();
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
            case R.id.tv_address:
                break;
        }
    }
}
