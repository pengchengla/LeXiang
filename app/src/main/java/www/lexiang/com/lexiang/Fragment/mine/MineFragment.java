package www.lexiang.com.lexiang.Fragment.mine;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseFragment;
import www.lexiang.com.lexiang.view.CircleImageView;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class MineFragment extends BaseFragment implements View.OnClickListener {
    private ImageView ivSetting;
    private CircleImageView ivHead;
    private TextView tvNicheng;
    private TextView tvDengji;
    private TextView tvGuanzhuCount;
    private TextView tvFensiCount;
    private TextView tvQianming;
    private TextView tvZiliao;
    private TextView tvGojifen;
    private LinearLayout llEdit;
    private LinearLayout llCollect;
    private LinearLayout llShop;
    private TextView tvWeather;
    private TextView tvKuaidi;
    private TextView tvWeizhang;
    private TextView tv_heimingdan;
    private TextView tv_myjifen;
    private TextView tv_myfuwu;
    private TextView tv_zhinan;
    private TextView tv_shareapp;

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_mine, null);
        ivSetting = (ImageView) view.findViewById(R.id.iv_setting);
        ivSetting.setOnClickListener(this);
        ivHead = (CircleImageView) view.findViewById(R.id.iv_head);
        ivHead.setOnClickListener(this);
        tvNicheng = (TextView) view.findViewById(R.id.tv_nicheng);
        tvDengji = (TextView) view.findViewById(R.id.tv_dengji);
        tvGuanzhuCount = (TextView) view.findViewById(R.id.tv_guanzhu_count);
        tvFensiCount = (TextView) view.findViewById(R.id.tv_fensi_count);
        tvQianming = (TextView) view.findViewById(R.id.tv_qianming);
        tvZiliao = (TextView) view.findViewById(R.id.tv_ziliao);
        tvZiliao.setOnClickListener(this);
        tvGojifen = (TextView) view.findViewById(R.id.tv_gojifen);
        tvGojifen.setOnClickListener(this);
        llEdit = (LinearLayout) view.findViewById(R.id.ll_edit);
        llEdit.setOnClickListener(this);
        llCollect = (LinearLayout) view.findViewById(R.id.ll_collect);
        llCollect.setOnClickListener(this);
        llShop = (LinearLayout) view.findViewById(R.id.ll_shop);
        llShop.setOnClickListener(this);
        tvWeather = (TextView) view.findViewById(R.id.tv_weather);
        tvWeather.setOnClickListener(this);
        tvKuaidi = (TextView) view.findViewById(R.id.tv_kuaidi);
        tvKuaidi.setOnClickListener(this);
        tvWeizhang = (TextView) view.findViewById(R.id.tv_weizhang);
        tvWeizhang.setOnClickListener(this);
        tv_heimingdan = (TextView) view.findViewById(R.id.tv_heimingdan);
        tv_heimingdan.setOnClickListener(this);
        tv_myjifen = (TextView) view.findViewById(R.id.tv_myjifen);
        tv_myjifen.setOnClickListener(this);
        tv_myfuwu = (TextView) view.findViewById(R.id.tv_myfuwu);
        tv_myfuwu.setOnClickListener(this);
        tv_zhinan = (TextView) view.findViewById(R.id.tv_zhinan);
        tv_zhinan.setOnClickListener(this);
        tv_shareapp = (TextView) view.findViewById(R.id.tv_shareapp);
        tv_shareapp.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_setting:
                break;
            case R.id.iv_head:
                break;
            case R.id.tv_ziliao:
                break;
            case R.id.tv_gojifen:
                break;
            case R.id.ll_edit://动态
                Intent intent=new Intent(mContext,MyDongTaiActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_collect:
                break;
            case R.id.ll_shop:
                break;
            case R.id.tv_weather:
                break;
            case R.id.tv_kuaidi:
                break;
            case R.id.tv_weizhang:
                break;
            case R.id.tv_heimingdan:
                break;
            case R.id.tv_myjifen:
                break;
            case R.id.tv_myfuwu:
                break;
            case R.id.tv_zhinan:
                break;
            case R.id.tv_shareapp:
                break;
        }
    }
}
