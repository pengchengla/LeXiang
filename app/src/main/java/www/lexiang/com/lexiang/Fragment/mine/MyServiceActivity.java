package www.lexiang.com.lexiang.Fragment.mine;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import www.lexiang.com.lexiang.R;

public class MyServiceActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_content;
    private TextView tv_create;
    private LinearLayout activity_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_create = (TextView) findViewById(R.id.tv_create);
        tv_content = (TextView) findViewById(R.id.tv_content);
        tv_create.setOnClickListener(this);
        activity_setting = (LinearLayout) findViewById(R.id.activity_setting);
        SpannableString spannableString = new SpannableString("在我的服务中您可以填写基于您的技能、特长提供的服务，如：教人弹吉他；" +
                "辅导初高中数学、物理；上门制作美食；上门美甲、穴位按摩、洗车等。您也可以根据自有资源提供相应的服务，" +
                "如：您有一辆小货车可以做货运服务；您有其他城市或海外的关系可以提供代购服务；您在某个行业或领域内能提供" +
                "更快捷的办理服务等。有需要服务的人可以在【乐享服务】板块中通过关键字搜索到您提供的服务，" +
                "通过“乐享身边”平台我们给您提供一个可发挥您能力与资源的创收渠道。您有本事您就来！当然您也可以" +
                "发挥您天马行空的想象，只要您认为有人对您提供的服务有需求。小编就看过一部电影有人提供帮助解决恋人分手问题的服务   ");
        Drawable drawable = getResources().getDrawable(R.drawable.smileface);
        drawable.setBounds(0, 0, 42, 42);
        ImageSpan imageSpan = new ImageSpan(drawable);
        spannableString.setSpan(imageSpan, 281, 282,
                Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv_content.setText(spannableString);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_create:
                startActivity(new Intent(this, CreateServiceActivity.class));
                break;
        }
    }
}
