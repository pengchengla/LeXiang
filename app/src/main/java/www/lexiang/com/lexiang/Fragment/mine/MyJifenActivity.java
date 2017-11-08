package www.lexiang.com.lexiang.Fragment.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseActivity;
import www.lexiang.com.lexiang.view.BaseDialog;

public class MyJifenActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_jifenjilu;
    private TextView tv_myjifencount;
    private TextView tv_buy;
    private LinearLayout activity_my_jifen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_jifen);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_jifenjilu = (TextView) findViewById(R.id.tv_jifenjilu);
        tv_jifenjilu.setOnClickListener(this);
        tv_myjifencount = (TextView) findViewById(R.id.tv_myjifencount);
        tv_buy = (TextView) findViewById(R.id.tv_buy);
        tv_buy.setOnClickListener(this);
        activity_my_jifen = (LinearLayout) findViewById(R.id.activity_my_jifen);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_buy:
                showDialog(Gravity.CENTER, R.style.Alpah_aniamtion);
                break;
            case R.id.tv_jifenjilu:
                startActivity(new Intent(this,JifenJiluActivity.class));
                break;
        }
    }

    private void showDialog(int grary, int animationStyle) {
        BaseDialog.Builder builder = new BaseDialog.Builder(this);
        final BaseDialog dialog = builder.setViewId(R.layout.dialog_buyjifen)
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
