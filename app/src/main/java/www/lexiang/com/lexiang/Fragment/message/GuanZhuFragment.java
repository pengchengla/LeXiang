package www.lexiang.com.lexiang.Fragment.message;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import www.lexiang.com.lexiang.R;
import www.lexiang.com.lexiang.base.BaseFragment;

/**
 * Created by Administrator on 2017/11/10.
 */
public class GuanZhuFragment extends BaseFragment {
    private RecyclerView recycler_guanzhu;
    @Override
    protected void lazyLoad() {

    }

    @Override
    protected View initView() {
        View view=View.inflate(mContext, R.layout.fragment_guanzhu,null);
        recycler_guanzhu= (RecyclerView) view.findViewById(R.id.recycler_guanzhu);
        recycler_guanzhu.setLayoutManager(new LinearLayoutManager(mContext));
        List<String> list=new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        GuanzhuAdapter guanzhuAdapter=new GuanzhuAdapter(R.layout.item_qunzu,list);
        recycler_guanzhu.setAdapter(guanzhuAdapter);
        return view;
    }

    class GuanzhuAdapter extends BaseQuickAdapter<String,BaseViewHolder>{

        public GuanzhuAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {

        }
    }
}
