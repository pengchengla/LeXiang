package www.lexiang.com.lexiang.avtivity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.util.ArrayList;
import java.util.List;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.adapter.Gadgetadapter;
import www.lexiang.com.lexiang.base.BaseActivity;
import www.lexiang.com.lexiang.bean.Gadgetbean;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class GadgetActivity extends BaseActivity {
    private ImageView quwan_img;
    private RecyclerView gadget_recycler;

    List<Gadgetbean> listbean=new ArrayList<>();
    Gadgetbean gadget;
    private SpringView springView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shejiao);
        data();
        initView();
          //加载数据

        gadget_recycler.setLayoutManager(new LinearLayoutManager(this));
        Gadgetadapter adapter=new Gadgetadapter(GadgetActivity.this,listbean);
        gadget_recycler.setAdapter(adapter);
        gadget_recycler.setNestedScrollingEnabled(false);

    }

    private void data() {
        for (int i = 0; i <10 ; i++) {
            gadget=new Gadgetbean();
            gadget.setCount("如果明天的额路你不知该往哪走就留在我身边做我老婆好不好。"+i);
            gadget.setName("凉生"+i);
            gadget.setTime(i+"分钟前");
            listbean.add(gadget);
        }


    }

    private void initView() {
        quwan_img = (ImageView) findViewById(R.id.quwan_img);
        gadget_recycler = (RecyclerView) findViewById(R.id.gadget_recycler);
        springView = (SpringView) findViewById(R.id.springviews);
        springView.setType(SpringView.Type.FOLLOW);
        springView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        data();
                        springView.onFinishFreshAndLoad();
                    }
                }, 1000);
            }

            @Override
            public void onLoadmore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {


                        springView.onFinishFreshAndLoad();
                    }
                }, 1000);
            }
        });
        springView.setHeader(new DefaultHeader(this));
        springView.setFooter(new DefaultFooter(this));


    }
}
