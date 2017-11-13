package www.lexiang.com.lexiang.Fragment.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseActivity;
import www.lexiang.com.lexiang.view.BaseDialog;

public class SettingActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private RelativeLayout rl_yijian;
    private TextView tv_cache_m, tv_loginout;
    private RelativeLayout rl_cache;
    private RelativeLayout rl_aboutus;
    private RelativeLayout rl_version;
    private LinearLayout activity_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        rl_yijian = (RelativeLayout) findViewById(R.id.rl_yijian);
        rl_yijian.setOnClickListener(this);
        tv_cache_m = (TextView) findViewById(R.id.tv_cache_m);
        rl_cache = (RelativeLayout) findViewById(R.id.rl_cache);
        rl_cache.setOnClickListener(this);
        rl_aboutus = (RelativeLayout) findViewById(R.id.rl_aboutus);
        rl_aboutus.setOnClickListener(this);
        rl_version = (RelativeLayout) findViewById(R.id.rl_version);
        rl_version.setOnClickListener(this);
        activity_setting = (LinearLayout) findViewById(R.id.activity_setting);
        tv_loginout = (TextView) findViewById(R.id.tv_loginout);
        tv_loginout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_yijian:
                startActivity(new Intent(this, YijianActivity.class));
                break;
            case R.id.rl_cache:
                break;
            case R.id.rl_aboutus:
                startActivity(new Intent(this, AboutUSActivity.class));
                break;
            case R.id.rl_version:
                showAppVersionDialog(Gravity.CENTER, R.style.Alpah_aniamtion);
                break;
            case R.id.tv_loginout:
                showLoginOutDialog(Gravity.CENTER, R.style.Alpah_aniamtion);
                break;
        }
    }

    private void showAppVersionDialog(int grary, int animationStyle) {
        BaseDialog.Builder builder = new BaseDialog.Builder(this);
        final BaseDialog dialog = builder.setViewId(R.layout.dialog_appversion)
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
        dialog.getView(R.id.tv_canel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.getView(R.id.tv_yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(SettingActivity.this, "正在下载...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showLoginOutDialog(int grary, int animationStyle) {
        BaseDialog.Builder builder = new BaseDialog.Builder(this);
        final BaseDialog dialog = builder.setViewId(R.layout.dialog_loginout)
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
        dialog.getView(R.id.tv_canel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.getView(R.id.tv_yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                finish();
            }
        });
    }
}
