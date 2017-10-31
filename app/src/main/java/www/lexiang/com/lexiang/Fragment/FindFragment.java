package www.lexiang.com.lexiang.Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import www.lexiang.com.lexiang.Fragment.fragment.BianminFragment;
import www.lexiang.com.lexiang.Fragment.fragment.BlockFragment;
import www.lexiang.com.lexiang.Fragment.fragment.LifeFragment;
import www.lexiang.com.lexiang.Fragment.fragment.PhoneFragment;
import www.lexiang.com.lexiang.Fragment.fragment.ShizhengFragment;
import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseFragment;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class FindFragment extends BaseFragment implements View.OnClickListener {

    private TextView text_life;
    private TextView text_block;
    private TextView text_person;
    private TextView text_phone;
    private TextView text_town;
    private View v1, v2, v3, v4, v5;
    private Fragment currentf;
    private BianminFragment bianminFragment;
    private BlockFragment blockFragment;
    private LifeFragment lifeFragment;
    private PhoneFragment phoneFragment;
    private ShizhengFragment shizhengFragment;
    private ImageView find_img;

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_find, null);
        text_life = (TextView) view.findViewById(R.id.text_life);
        text_block = (TextView) view.findViewById(R.id.text_block);
        text_person = (TextView) view.findViewById(R.id.text_person);
        text_phone = (TextView) view.findViewById(R.id.text_phone);
        text_town = (TextView) view.findViewById(R.id.text_town);
        find_img = (ImageView) view.findViewById(R.id.find_img);
        v1 = view.findViewById(R.id.v1);
        v2 = view.findViewById(R.id.v2);
        v3 = view.findViewById(R.id.v3);
        v4 = view.findViewById(R.id.v4);
        v5 = view.findViewById(R.id.v5);
        text_life.setOnClickListener(this);
        text_block.setOnClickListener(this);
        text_person.setOnClickListener(this);
        text_phone.setOnClickListener(this);
        text_town.setOnClickListener(this);
        lifeFragment = new LifeFragment();
        addFragments(lifeFragment);

        return view;
    }

    private void inindata() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_life:
                if (lifeFragment == null) {
                    lifeFragment = new LifeFragment();
                }
                addFragments(lifeFragment);
                v1.setVisibility(View.VISIBLE);
                v2.setVisibility(View.GONE);
                v3.setVisibility(View.GONE);
                v4.setVisibility(View.GONE);
                v5.setVisibility(View.GONE);
                find_img.setImageResource(R.drawable.findimg1);
                break;
            case R.id.text_block:
                if (blockFragment == null) {
                    blockFragment = new BlockFragment();

                }
                addFragments(blockFragment);
                v1.setVisibility(View.GONE);
                v2.setVisibility(View.GONE);
                v3.setVisibility(View.VISIBLE);
                v4.setVisibility(View.GONE);
                v5.setVisibility(View.GONE);
                find_img.setImageResource(R.drawable.home_body);
                break;
            case R.id.text_phone:
                if (phoneFragment == null) {
                    phoneFragment = new PhoneFragment();

                }
                addFragments(phoneFragment);
                v5.setVisibility(View.VISIBLE);
                v2.setVisibility(View.GONE);
                v3.setVisibility(View.GONE);
                v4.setVisibility(View.GONE);
                v1.setVisibility(View.GONE);
                find_img.setImageResource(R.drawable.home_body2);
                break;
            case R.id.text_person:
                if (bianminFragment == null) {
                    bianminFragment = new BianminFragment();


                }
                addFragments(bianminFragment);
                v2.setVisibility(View.VISIBLE);
                v3.setVisibility(View.GONE);
                v4.setVisibility(View.GONE);
                v1.setVisibility(View.GONE);
                v5.setVisibility(View.GONE);
                find_img.setImageResource(R.drawable.home_body4);
                break;
            case R.id.text_town:
                if (shizhengFragment == null) {
                    shizhengFragment = new ShizhengFragment();
                }
                addFragments(shizhengFragment);
                v4.setVisibility(View.VISIBLE);
                v1.setVisibility(View.GONE);
                v5.setVisibility(View.GONE);
                v2.setVisibility(View.GONE);
                v3.setVisibility(View.GONE);
                find_img.setImageResource(R.drawable.home_body);
                break;

        }
    }

    private void addFragments(Fragment f) {
        // 第一步：得到fragment管理类
        FragmentManager manager = getChildFragmentManager();
        // 第二步：开启一个事务
        FragmentTransaction transaction = manager.beginTransaction();

        if (currentf != null) {
            //每次把前一个fragment给隐藏了
            transaction.hide(currentf);
        }

        //isAdded:判断当前的fragment对象是否被加载过
        if (!f.isAdded()) {
            // 第三步：调用添加fragment的方法 第一个参数：容器的id 第二个参数：要放置的fragment的一个实例对象
            transaction.add(R.id.find_layout, f);
        }
        //显示当前的fragment
        transaction.show(f);

        // 第四步：提交
        transaction.commit();

        currentf = f;
    }

}
