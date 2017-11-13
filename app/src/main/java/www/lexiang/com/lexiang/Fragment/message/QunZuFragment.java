package www.lexiang.com.lexiang.Fragment.message;

import android.content.Intent;
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
public class QunZuFragment extends BaseFragment {
    private RecyclerView recyler_myqunzu, recyler_comment_qunzu;

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_qunzu, null);
        recyler_myqunzu = (RecyclerView) view.findViewById(R.id.recyler_myqunzu);
        recyler_myqunzu.setLayoutManager(new LinearLayoutManager(mContext));
        recyler_myqunzu.setNestedScrollingEnabled(false);
        recyler_comment_qunzu = (RecyclerView) view.findViewById(R.id.recyler_comment_qunzu);
        recyler_comment_qunzu.setLayoutManager(new LinearLayoutManager(mContext));
        recyler_comment_qunzu.setNestedScrollingEnabled(false);
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        MyQunZuAdapter qunZuAdapter = new MyQunZuAdapter(R.layout.item_qunzu, list);
        recyler_myqunzu.setAdapter(qunZuAdapter);

        CommentQunZuAdapter commentQunZuAdapter = new CommentQunZuAdapter(R.layout.item_qunzu, list);
        recyler_comment_qunzu.setAdapter(commentQunZuAdapter);
        commentQunZuAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(mContext,QunIntroActivity.class));
            }
        });
        return view;
    }

    class MyQunZuAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public MyQunZuAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {

        }
    }

    class CommentQunZuAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public CommentQunZuAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {

        }
    }
}
