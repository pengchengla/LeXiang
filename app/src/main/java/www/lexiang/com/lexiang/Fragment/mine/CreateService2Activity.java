package www.lexiang.com.lexiang.Fragment.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseActivity;
import www.lexiang.com.lexiang.view.BaseDialog;

public class CreateService2Activity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private EditText edt_name;
    private EditText edt_shenfencard;
    private EditText edt_shuoming;
    private TextView tv_looksample;
    private ImageView iv_card1;
    private TextView tv_looksample2;
    private ImageView iv_card2;
    private TextView tv_looksample3;
    private ImageView iv_card3;
    private TextView tv_submit,tv_title;
    private LinearLayout activity_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_service2);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        edt_name = (EditText) findViewById(R.id.edt_name);
        edt_shenfencard = (EditText) findViewById(R.id.edt_shenfencard);
        edt_shuoming = (EditText) findViewById(R.id.edt_shuoming);
        tv_looksample = (TextView) findViewById(R.id.tv_looksample);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_looksample.setOnClickListener(this);
        iv_card1 = (ImageView) findViewById(R.id.iv_card1);
        iv_card1.setOnClickListener(this);
        tv_looksample2 = (TextView) findViewById(R.id.tv_looksample2);
        tv_looksample2.setOnClickListener(this);
        iv_card2 = (ImageView) findViewById(R.id.iv_card2);
        iv_card2.setOnClickListener(this);
        tv_looksample3 = (TextView) findViewById(R.id.tv_looksample3);
        tv_looksample3.setOnClickListener(this);
        iv_card3 = (ImageView) findViewById(R.id.iv_card3);
        iv_card3.setOnClickListener(this);
        tv_submit = (TextView) findViewById(R.id.tv_submit);
        tv_submit.setOnClickListener(this);
        activity_setting = (LinearLayout) findViewById(R.id.activity_setting);
    }

    private void submit() {
        // validate
//        String name = edt_name.getText().toString().trim();
//        if (TextUtils.isEmpty(name)) {
//            Toast.makeText(this, "请输入真实姓名", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        String shenfencard = edt_shenfencard.getText().toString().trim();
//        if (TextUtils.isEmpty(shenfencard)) {
//            Toast.makeText(this, "请输入身份证号码", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        String shuoming = edt_shuoming.getText().toString().trim();
//        if (TextUtils.isEmpty(shuoming)) {
//            Toast.makeText(this, "该说明只用于审核不对外显示", Toast.LENGTH_SHORT).show();
//            return;
//        }
        startActivity(new Intent(this,CreateService3Activity.class));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_looksample:
                showDialog(Gravity.CENTER, R.style.Alpah_aniamtion);
                break;
            case R.id.tv_looksample2:
                showDialog(Gravity.CENTER, R.style.Alpah_aniamtion);
                break;
            case R.id.tv_looksample3:
                showDialog(Gravity.CENTER, R.style.Alpah_aniamtion);
                break;
            case R.id.iv_card1:
                break;
            case R.id.iv_card2:
                break;
            case R.id.iv_card3:
                break;
            case R.id.tv_submit:
                submit();
                break;
        }
    }

    private void showDialog(int grary, int animationStyle) {
        BaseDialog.Builder builder = new BaseDialog.Builder(this);
        final BaseDialog dialog = builder.setViewId(R.layout.dialog_card)
                //设置dialogpadding
                .setPaddingdp(10, 0, 10, 0)
                //设置显示位置
                .setGravity(grary)
                //设置动画
                .setAnimation(animationStyle)
                //设置dialog的宽高
                .setWidthHeightpx(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                //设置触摸dialog外围是否关闭
                .isOnTouchCanceled(true)
                //设置监听事件
                .builder();
        dialog.show();
    }
}
