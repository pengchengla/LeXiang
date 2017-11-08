package www.lexiang.com.lexiang.avtivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.adapter.NoScrollGridAdapter;
import www.lexiang.com.lexiang.base.BaseActivity;
import www.lexiang.com.lexiang.utils.NoScrollGridView;
import www.lexiang.com.lexiang.view.CircleImageView;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class GadgetDetailActivity extends BaseActivity {

    private CircleImageView gaditemdetai_pho;
    private TextView gaditemdetail_name;
    private TextView gaditemdteail_time;
    private TextView gaditem_looknum;
    private TextView gaditem_count;
    private NoScrollGridView gridview;
    private View line;
    private TextView zan;
    private RecyclerView detai_recycler;
    private TextView detail_all;
    private TextView pin_num;
    private RecyclerView detail_count;
    ArrayList<String> urls_3 = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gadgetdetail);
        //获取资源id
        initView();
    }

    private void initView() {
        gaditemdetai_pho = (CircleImageView) findViewById(R.id.gaditemdetai_pho);
        gaditemdetail_name = (TextView) findViewById(R.id.gaditemdetail_name);
        gaditemdteail_time = (TextView) findViewById(R.id.gaditemdteail_time);
        gaditem_looknum = (TextView) findViewById(R.id.gaditem_looknum);
        gaditem_count = (TextView) findViewById(R.id.gaditem_count);
        gridview = (NoScrollGridView) findViewById(R.id.gridview);
        line = (View) findViewById(R.id.line);
        zan = (TextView) findViewById(R.id.zan);
        detai_recycler = (RecyclerView) findViewById(R.id.detai_recycler);
        detail_all = (TextView) findViewById(R.id.detail_all);
        pin_num = (TextView) findViewById(R.id.pin_num);
        detail_count = (RecyclerView) findViewById(R.id.detail_count);
         //添加数据
        inindata();
    }

    private void inindata() {

        urls_3.add("http://img.my.csdn.net/uploads/201410/19/1413698837_7507.jpg");
        urls_3.add("http://img.my.csdn.net/uploads/201410/19/1413698865_3560.jpg");
        urls_3.add("http://img.my.csdn.net/uploads/201410/19/1413698867_8323.jpg");
        urls_3.add("http://img.my.csdn.net/uploads/201410/19/1413698837_5654.jpg");
        urls_3.add("http://img.my.csdn.net/uploads/201410/19/1413698883_5877.jpg");
        urls_3.add("http://img.my.csdn.net/uploads/201410/19/1413698839_2302.jpg");
        if (urls_3  == null || urls_3 .size() == 0) { // 没有图片资源就隐藏GridView
            gridview.setVisibility(View.GONE);
        } else {
            gridview.setAdapter(new NoScrollGridAdapter(this, urls_3));
        }
          //监听事件
         gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 imageBrower(position, urls_3);
             }
         });
    }
    /**
     * 打开图片查看器
     *
     * @param position
     * @param urls2
     */
    protected void imageBrower(int position, ArrayList<String> urls2) {
        Intent intent = new Intent(this, ImagePagerActivity.class);
        // 图片url,为了演示这里使用常量，一般从数据库中或网络中获取
        intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_URLS, urls2);
        intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_INDEX, position);
        startActivity(intent);
    }
}
