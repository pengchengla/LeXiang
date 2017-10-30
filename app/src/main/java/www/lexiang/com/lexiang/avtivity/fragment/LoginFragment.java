package www.lexiang.com.lexiang.avtivity.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import www.lexiang.com.lexiang.MainActivity;
import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.avtivity.ForgetpwdActivity;
import www.lexiang.com.lexiang.base.BaseFragment;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class LoginFragment extends BaseFragment implements View.OnClickListener {
    public View rootView;
    public EditText login_phone;
    public EditText login_pwd;
    public Button btn_login;
    public TextView forgetpwd;
    public TextView goregister;
    public ImageView iv_qq;
    public ImageView iv_weixin;
    public ImageView iv_weibo;
    @Override
    protected void lazyLoad() {

    }

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_login, null);
        login_phone = (EditText) view.findViewById(R.id.login_phone);
        login_pwd = (EditText) view.findViewById(R.id.login_pwd);
        btn_login = (Button) view.findViewById(R.id.btn_login);
       forgetpwd = (TextView) view.findViewById(R.id.forgetpwd);
       goregister = (TextView) view.findViewById(R.id.goregister);
       iv_qq = (ImageView) view.findViewById(R.id.iv_qq);
     iv_weixin = (ImageView) view.findViewById(R.id.iv_weixin);
        iv_weibo = (ImageView) view.findViewById(R.id.iv_weibo);
        forgetpwd.setOnClickListener(this);//设置监听
        btn_login.setOnClickListener(this);
        iv_qq.setOnClickListener(this);
        iv_weibo.setOnClickListener(this);
        iv_weixin.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.forgetpwd://忘记密码
                Intent inten=new Intent(getActivity(), ForgetpwdActivity.class);
                startActivity(inten);
                break;
            //跳登录
            case R.id.btn_login:
                 Intent it=new Intent(getActivity(), MainActivity.class);
                startActivity(it);
                break;
            case R.id.iv_qq:
                break;
            case R.id.iv_weixin:
                break;
            case R.id.iv_weibo:
                break;
        }
    }
}
