package com.example.hnew;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.hnew.adapter.NewsAdapter;
import com.example.hnew.bean.NewsResponse;
import com.example.hnew.contract.NewsContract;
import com.example.hnew.mvp.MvpFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import retrofit2.Response;


public class NewsFragment extends MvpFragment<NewsContract.NewsPresenter> implements NewsContract.INewsView {

    private FloatingActionButton fab;
    private ListView listView;
    private SmartRefreshLayout smartRefreshLayout;
    private List<NewsResponse.ResultBean.DataBean> newslist;
    private static final int UPNEWS_INSERT = 0;
    private NewsAdapter newsAdapter;
    private  String data;
    @Override
    public void initData(Bundle savedInstanceState) {
        listView = (ListView) rootView.findViewById(R.id.listView);
        fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        smartRefreshLayout = (SmartRefreshLayout) rootView.findViewById(R.id.smart_refresh);
    }

    @Override
    public int getLayoutId() {
        return R.layout.list_item;
    }

    @Override
    protected NewsContract.NewsPresenter createPresent() {
        return new NewsContract.NewsPresenter();
    }

    @SuppressLint("HandlerLeak")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
     //   onAttach(getActivity());
        Bundle bundle = getArguments();
        data = bundle.getString("name","top");
        mPresent.TopNews(data);
        //置顶功能
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.smoothScrollToPosition(0);
            }
        });
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mPresent.TopNews(data);
            }
        });
    }

    @Override
    public void getTopNews(Response<NewsResponse> response) {

        if(response.code() == 200){


        }else{
            Toast.makeText(getActivity(),"网络异常",Toast.LENGTH_SHORT).show();
        }

    }
}
