package www.lexiang.com.lexiang.Fragment.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseActivity;
import www.lexiang.com.lexiang.view.BaseDialog;
import www.lexiang.com.lexiang.view.CircleImageView;

public class MyZiLiaoActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private CircleImageView iv_head;
    private RelativeLayout rl_head;
    private RelativeLayout rl_nichegn;
    private RelativeLayout rl_intro;
    private RelativeLayout rl_address;
    private TextView tv_dengji;
    private RelativeLayout rl_psw;
    private LinearLayout activity_my_zi_liao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_zi_liao);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        iv_head = (CircleImageView) findViewById(R.id.iv_head);
        rl_head = (RelativeLayout) findViewById(R.id.rl_head);
        rl_head.setOnClickListener(this);
        rl_nichegn = (RelativeLayout) findViewById(R.id.rl_nichegn);
        rl_nichegn.setOnClickListener(this);
        rl_intro = (RelativeLayout) findViewById(R.id.rl_intro);
        rl_intro.setOnClickListener(this);
        rl_address = (RelativeLayout) findViewById(R.id.rl_address);
        rl_address.setOnClickListener(this);
        tv_dengji = (TextView) findViewById(R.id.tv_dengji);
        tv_dengji.setOnClickListener(this);
        rl_psw = (RelativeLayout) findViewById(R.id.rl_psw);
        rl_psw.setOnClickListener(this);
        activity_my_zi_liao = (LinearLayout) findViewById(R.id.activity_my_zi_liao);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_head:
                showphotoDialog(Gravity.BOTTOM, R.style.Bottom_Top_aniamtion);
                break;
            case R.id.rl_nichegn:
                startActivity(new Intent(this,ModifyNameActivity.class));
                break;
            case R.id.rl_intro:
                startActivity(new Intent(this,PersonIntroActivity.class));
                break;
            case R.id.rl_address:
                startActivity(new Intent(this,ModifyAddressActivity.class));
                break;
            case R.id.rl_psw:
                startActivity(new Intent(this,ModifyPswActivity.class));
                break;
            case R.id.tv_dengji:
                startActivity(new Intent(this,MyDengjiActivity.class));
                break;
        }
    }

    private void showphotoDialog(int grary, int animationStyle) {
        BaseDialog.Builder builder = new BaseDialog.Builder(this);
        final BaseDialog dialog = builder.setViewId(R.layout.dialog_photo)
                //设置dialogpadding
                .setPaddingdp(10, 0, 10, 0)
                //设置显示位置
                .setGravity(grary)
                //设置动画
                .setAnimation(animationStyle)
                //设置dialog的宽高
                .setWidthHeightpx(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                //设置触摸dialog外围是否关闭
                .isOnTouchCanceled(true)
                //设置监听事件
                .builder();
        dialog.getView(R.id.tv_paizhao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.getView(R.id.tv_local).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}
