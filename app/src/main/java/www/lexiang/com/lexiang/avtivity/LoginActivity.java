package www.lexiang.com.lexiang.avtivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.zackratos.ultimatebar.UltimateBar;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.avtivity.fragment.LoginFragment;
import www.lexiang.com.lexiang.avtivity.fragment.RegisterFragment;
import www.lexiang.com.lexiang.base.BaseActivity;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private ImageView register_img,head_img;
    private TextView register;
    private TextView login;
    private LinearLayout liner;
    private FrameLayout frag_register;
    private ImageView login_img;
    private Fragment currentf;
    private LoginFragment loginFragment;
    private RegisterFragment registerFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
       addFragments(new LoginFragment());
    }

    /*
        隐藏状态栏
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            UltimateBar ultimateBar = new UltimateBar(this);
            ultimateBar.setHintBar();

        }
    }

    private void initView() {
        register_img = (ImageView) findViewById(R.id.register_img);
        head_img = (ImageView) findViewById(R.id.head_img);
        register = (TextView) findViewById(R.id.register);
        login = (TextView) findViewById(R.id.login);
        liner = (LinearLayout) findViewById(R.id.liner);
        frag_register = (FrameLayout) findViewById(R.id.frag_register);
        login_img = (ImageView) findViewById(R.id.login_img);
        register.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register:
                register_img.setVisibility(View.VISIBLE);
                login_img.setVisibility(View.GONE);
                 if(registerFragment==null){
                     registerFragment=new RegisterFragment();

                 }
                addFragments(registerFragment);
                break;
            case R.id.login:
                register_img.setVisibility(View.GONE);
                login_img.setVisibility(View.VISIBLE);
                if(loginFragment==null){
                    loginFragment=new LoginFragment();

                }
                addFragments(loginFragment);
                break;
        }
    }
    /*
      开启fragment
     */
    private void addFragments(Fragment f) {
        // 第一步：得到fragment管理类
        FragmentManager manager = getSupportFragmentManager();
        // 第二步：开启一个事务
        FragmentTransaction transaction = manager.beginTransaction();

        if (currentf != null) {
            //每次把前一个fragment给隐藏了
            transaction.hide(currentf);
        }

        //isAdded:判断当前的fragment对象是否被加载过
        if (!f.isAdded()) {
            // 第三步：调用添加fragment的方法 第一个参数：容器的id 第二个参数：要放置的fragment的一个实例对象
            transaction.add(R.id.frag_register, f);
        }
        //显示当前的fragment
        transaction.show(f);

        // 第四步：提交
        transaction.commit();

        currentf = f;
    }
}
