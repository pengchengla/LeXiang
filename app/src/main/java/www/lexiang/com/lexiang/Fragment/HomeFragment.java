package www.lexiang.com.lexiang.Fragment;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import www.lexiang.com.lexiang.MainActivity;
import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.adapter.Homebodyadapter;
import www.lexiang.com.lexiang.base.BaseFragment;
import www.lexiang.com.lexiang.bean.Homebean;
import www.lexiang.com.lexiang.utils.MyListview;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener {
    public View rootView;
    public TextView home_Social;
    public TextView home_bighelp;
    public TextView home_City;
    public TextView home_expedition;
    public TextView home_expert;
    MyListview list_home;
    private ArrayList<Homebean> list;
    @Override
    protected void lazyLoad() {



    }

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_home, null);

      home_Social = (TextView)  view.findViewById(R.id.home_Social);
      home_bighelp = (TextView) view.findViewById(R.id.home_bighelp);
       home_City = (TextView) view.findViewById(R.id.home_City);
      home_expedition = (TextView)  view.findViewById(R.id.home_expedition);
     home_expert = (TextView)  view.findViewById(R.id.home_expert);
       list_home = (MyListview)  view.findViewById(R.id.list_home);
         home_Social.setOnClickListener(this);
        home_bighelp.setOnClickListener(this);
        home_City.setOnClickListener(this);
        home_expedition.setOnClickListener(this);
        home_expert.setOnClickListener(this);
        inint();
        Homebodyadapter homebodyadapter=new Homebodyadapter(getActivity(),list);
        list_home.setAdapter(homebodyadapter);



        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_Social:
                break;
            case R.id.home_bighelp:
                break;
            case R.id.home_City:
                break;
            case  R.id.home_expedition:
                break;
            case R.id.home_expert:
                break;

        }

    }
    //初始化数据
    private void inint() {
       list=new ArrayList<>();
        Homebean homebean=new Homebean("生活大爆炸",R.drawable.home_body );
        list.add(homebean);
        Homebean homebean1=new Homebean("身边材料",R.drawable.home_body1);
        list.add(homebean1);
        Homebean homebean2=new Homebean("信息快递",R.drawable.home_body2);
        list.add(homebean2);
        Homebean homebean3=new Homebean("乐享达人",R.drawable.home_body3);
        list.add(homebean3);
        Homebean homebean4=new Homebean("解难问答",R.drawable.home_body4);
        list.add(homebean4);


    }
}
