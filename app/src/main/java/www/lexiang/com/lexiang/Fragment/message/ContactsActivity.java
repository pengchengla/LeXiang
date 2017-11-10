package www.lexiang.com.lexiang.Fragment.message;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseActivity;
import www.lexiang.com.lexiang.base.BaseFragment;

public class ContactsActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TabLayout tabLayout;
    private ViewPager mvp;
    private LinearLayout activity_setting;
    private List<BaseFragment> mBaseFragmentList = new ArrayList<>();
    private TextView tv_jianqun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mvp = (ViewPager) findViewById(R.id.mvp);
        activity_setting = (LinearLayout) findViewById(R.id.activity_setting);
        tv_jianqun= (TextView) findViewById(R.id.tv_jianqun);
        if (mBaseFragmentList.size() <= 0) {
            mBaseFragmentList.add(new GuanZhuFragment());
            mBaseFragmentList.add(new FenSiFragment());
            mBaseFragmentList.add(new QunZuFragment());
            mBaseFragmentList.add(new KeFuFragment());
        }
        ContactsAdapter adapter = new ContactsAdapter(getSupportFragmentManager(), mBaseFragmentList);
        mvp.setAdapter(adapter);
        // 将TabLayout和ViewPager进行关联，让两者联动起来
        tabLayout.setupWithViewPager(mvp);
        mvp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==2){
                    tv_jianqun.setVisibility(View.VISIBLE);
                }else {
                    tv_jianqun.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public class ContactsAdapter extends FragmentStatePagerAdapter {
        private final List<BaseFragment> mFragmentList;
        private String[] title = {"我的关注", "我的粉丝", "群组", "乐享客服"};

        public ContactsAdapter(FragmentManager fm, List<BaseFragment> fragmentList) {
            super(fm);
            this.mFragmentList = fragmentList;
        }

        //别忘了这个方法一定要有
        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }

        @Override//返回position位置的Fragment对象
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return title.length;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
