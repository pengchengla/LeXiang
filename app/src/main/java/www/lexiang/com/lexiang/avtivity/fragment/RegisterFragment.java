package www.lexiang.com.lexiang.avtivity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseFragment;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class RegisterFragment extends BaseFragment {
    private EditText edt_phone;
    private EditText edt_yanzheng;
    private TextView tv_getcode;
    private EditText edt_pwd;
    private EditText pwd_true;
    private Button btn_register;
 /*
  加载数据
 */
    @Override
    protected void lazyLoad() {

    }
   /*
     加载布局
    */
    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_register, null);
        edt_phone = (EditText) view.findViewById(R.id.edt_phone);
        edt_yanzheng = (EditText) view.findViewById(R.id.edt_yanzheng);
        tv_getcode = (TextView) view.findViewById(R.id.tv_getcode);
        edt_pwd = (EditText) view.findViewById(R.id.edt_pwd);
        pwd_true = (EditText) view.findViewById(R.id.pwd_true);
        btn_register = (Button) view.findViewById(R.id.btn_register);
        return view;
    }
}
