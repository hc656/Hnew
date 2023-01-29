package com.example.hnew.adapter;


import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.hnew.bean.NewsResponse;

import java.util.List;

public class NewsAdapter extends BaseQuickAdapter<NewsResponse.ResultBean.DataBean, BaseViewHolder> {
    public NewsAdapter(int layoutResId, @Nullable List<NewsResponse.ResultBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsResponse.ResultBean.DataBean item) {


    }

}
