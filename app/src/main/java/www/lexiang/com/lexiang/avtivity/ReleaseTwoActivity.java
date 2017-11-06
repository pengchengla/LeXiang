package www.lexiang.com.lexiang.avtivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.adapter.ReleaseAdapter;
import www.lexiang.com.lexiang.base.BaseActivity;
import www.lexiang.com.lexiang.bean.Bianminbean;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class ReleaseTwoActivity extends BaseActivity {
    private List<Bianminbean> list=new ArrayList<>();

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.release_add);
        recyclerView = (RecyclerView)findViewById(R.id.release_recycle);
        recyclewview();
    }

    public void recyclewview(){

        int[] release_img={R.drawable.release_social,R.drawable.release_social,R.drawable.release_social,R.drawable.release_social,
                R.drawable.release_social,R.drawable.release_social,R.drawable.release_social,R.drawable.release_social,
                R.drawable.release_social,R.drawable.release_social,R.drawable.release_social,R.drawable.release_social,
                R.drawable.release_social,R.drawable.release_social,R.drawable.release_social,R.drawable.release_social,};
        String[] release_dis={"社交频道","便民服务","生活服务","市政厅","小区论坛","发现美食","品物寻店","玩转同城","旅游周边","寻人寻物","公益"
                ,"生活大爆炸","信息快递","解难问答","身边爆料","乐享达人"};

        for (int i = 0; i <release_img.length ; i++) {
            Bianminbean bianmiebean= new Bianminbean(release_img[i],release_dis[i]);

            list.add(bianmiebean);
        }
        recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        recyclerView.setNestedScrollingEnabled(false);
        ReleaseAdapter releaseAdapter=new ReleaseAdapter(this,list);
        recyclerView.setAdapter(releaseAdapter);

    }
}
