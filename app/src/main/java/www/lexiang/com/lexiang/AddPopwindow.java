package www.lexiang.com.lexiang;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import www.lexiang.com.lexiang.adapter.ReleaseAdapter;
import www.lexiang.com.lexiang.avtivity.ReleaseTwoActivity;
import www.lexiang.com.lexiang.bean.Bianminbean;
import www.lexiang.com.lexiang.utils.KickBackAnimator;
import www.lexiang.com.lexiang.utils.ScreenUtils;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class AddPopwindow extends PopupWindow implements View.OnClickListener {

          private View rootView;
          private Activity mContext;
         private RelativeLayout contentView;

    private TextView release_text,release_baoliao,release_food,release_life,release_photo
            ,release_shejiao,release_title,release_all;
    private RelativeLayout relativeLayout;
    private List<Bianminbean> list=new ArrayList<>();

    private RecyclerView recyclerView;
    private ScrollView relsease_scroll;

    public AddPopwindow( Activity mContext) {
        this.mContext = mContext;
    }
    public void showMoreWindow(View anchor) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rootView = inflater.inflate(R.layout.pop_fragadd, null);
        int h = mContext.getWindowManager().getDefaultDisplay().getHeight();
        int w = mContext.getWindowManager().getDefaultDisplay().getWidth();
        setContentView(rootView);
        this.setWidth(w);
        this.setHeight(h - ScreenUtils.getStatusHeight(mContext));

        contentView = (RelativeLayout) rootView.findViewById(R.id.contentView);
        RelativeLayout close = (RelativeLayout) rootView.findViewById(R.id.r_close);
        /*
          寻找控件
         */
        release_text = (TextView) rootView.findViewById(R.id.release_text);
        release_text.setOnClickListener(this);
        release_baoliao = (TextView) rootView.findViewById(R.id.release_baoliao);
        release_baoliao.setOnClickListener(this);
        release_food = (TextView) rootView.findViewById(R.id.release_food);
        release_food.setOnClickListener(this);
        release_life = (TextView) rootView.findViewById(R.id.release_life);
        release_life.setOnClickListener(this);
        release_photo = (TextView) rootView.findViewById(R.id.release_photo);
        release_photo.setOnClickListener(this);
        release_shejiao = (TextView) rootView.findViewById(R.id.release_shejiao);
        release_shejiao.setOnClickListener(this);
        release_title = (TextView) rootView.findViewById(R.id.release_title);
        release_title.setOnClickListener(this);
        release_all = (TextView) rootView.findViewById(R.id.release_all);
        release_all.setOnClickListener(this);

        close.setBackgroundColor(0xFFFFFFFF);
        close.setOnClickListener(this);
        showAnimation(contentView);
        setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.translucence_with_white));
        setOutsideTouchable(true);
        setFocusable(true);
        showAtLocation(anchor, Gravity.BOTTOM, 0, 0);
    }

    /**
     * 显示进入动画效果
     * @param layout
     */
    private void showAnimation(ViewGroup layout) {
        //遍历根试图下的一级子试图
        for (int i = 0; i < layout.getChildCount(); i++) {
            final View child = layout.getChildAt(i);
            //忽略关闭组件
            if (child.getId() == R.id.r_close) {
                continue;
            }
            //设置所有一级子试图的点击事件
            child.setOnClickListener(this);
            child.setVisibility(View.INVISIBLE);
            //延迟显示每个子试图(主要动画就体现在这里)
            Observable.timer(i * 0, TimeUnit.MILLISECONDS)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Long>() {
                        @Override
                        public void accept(@NonNull Long aLong) throws Exception {
                            child.setVisibility(View.VISIBLE);
                            ValueAnimator fadeAnim = ObjectAnimator.ofFloat(child, "translationY", 600, 0);
                            // fadeAnim.setDuration(300);
                            KickBackAnimator kickAnimator = new KickBackAnimator();
                            kickAnimator.setDuration(150);
                            fadeAnim.setEvaluator(kickAnimator);
                            fadeAnim.start();
                        }

                    });
        }

    }
    /**
     * 关闭动画效果
     * @param layout
     */
    private void closeAnimation(ViewGroup layout) {
        for (int i = 0; i < layout.getChildCount(); i++) {
            final View child = layout.getChildAt(i);
            if (child.getId() == R.id.r_close) {
                continue;
            }
            Observable.timer((layout.getChildCount() - i - 1) * 30, TimeUnit.MILLISECONDS)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Long>() {
                        @Override
                        public void accept(@NonNull Long aLong) throws Exception {
                            child.setVisibility(View.VISIBLE);
                            ValueAnimator fadeAnim = ObjectAnimator.ofFloat(child, "translationY", 0, 600);
                            fadeAnim.setDuration(200);
                            KickBackAnimator kickAnimator = new KickBackAnimator();
                            kickAnimator.setDuration(100);
                            fadeAnim.setEvaluator(kickAnimator);
                            fadeAnim.start();
                            fadeAnim.addListener(new Animator.AnimatorListener() {

                                @Override
                                public void onAnimationStart(Animator animation) {
                                }

                                @Override
                                public void onAnimationRepeat(Animator animation) {
                                }

                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    child.setVisibility(View.INVISIBLE);
                                }

                                @Override
                                public void onAnimationCancel(Animator animation) {
                                }
                            });
                        }


                    });
                        if (child.getId() == R.id.liner2) {
                Observable.timer((layout.getChildCount() - i) * 30 + 80, TimeUnit.MILLISECONDS)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Long>() {
                            @Override
                            public void accept(@NonNull Long aLong) throws Exception {
                                dismiss();
                            }

                        });
             }

        }

    }

    @Override
    public void onClick(View v) {

          switch (v.getId()){
              case R.id.r_close:
                  if (isShowing()) {
                      closeAnimation(contentView);
                  }
                  break;
              case R.id.release_text:
                  Toast.makeText(mContext, "aad", Toast.LENGTH_SHORT).show();

                  break;
              case R.id.release_photo:
                  Toast.makeText(mContext, "assad", Toast.LENGTH_SHORT).show();

                  break;
              case R.id.release_all:
//                  relativeLayout.setVisibility(View.GONE);
//                  relsease_scroll.setVisibility(View.VISIBLE);
//                  recyclewview();
                  Intent intent=new Intent(mContext, ReleaseTwoActivity.class);
                  mContext.startActivity(intent);
                  Toast.makeText(mContext, "assad", Toast.LENGTH_SHORT).show();
                  break;
          }

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
        recyclerView.setLayoutManager(new GridLayoutManager(mContext,4));
        ReleaseAdapter releaseAdapter=new ReleaseAdapter(mContext,list);
        recyclerView.setAdapter(releaseAdapter);

    }

}
