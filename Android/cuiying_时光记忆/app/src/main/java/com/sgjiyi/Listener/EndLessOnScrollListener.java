package com.sgjiyi.Listener;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

/**
 * Created by acu on 2017/8/24.
 */

public abstract class EndLessOnScrollListener extends  RecyclerView.OnScrollListener{

    //声明一个LinearLayoutManager
    private LinearLayoutManager mLinearLayoutManager;

    //当前页，从0开始
    private int currentPage = 0;
    //已经加载出来的Item的数量
    private int totalItemCount;

    //主要用来存储上一个totalItemCount
    private int previousTotal = 0;

    //在屏幕上可见的item数量
   // private int visibleItemCount;

    //在屏幕可见的Item中的第一个
 //   private int firstVisibleItem;

    //在屏幕可见的Item中的最后一个
    private int lastVisibleItem;

    //是否正在上拉数据
    private boolean isLoading = false;

    public EndLessOnScrollListener(LinearLayoutManager linearLayoutManager) {
        this.mLinearLayoutManager = linearLayoutManager;
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        if(newState==RecyclerView.SCROLL_STATE_IDLE&&lastVisibleItem+1==totalItemCount&&!isLoading){
            Log.d("wnwn", "---------------------最底部------------------");
            isLoading=true;
            currentPage ++;
            onLoadMore(currentPage);
            if(totalItemCount > previousTotal){
                //说明数据已经加载结束
                isLoading = false;
                previousTotal = totalItemCount;
            }else{
                isLoading=true;
            }
        }
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
    //    visibleItemCount = recyclerView.getChildCount();
        totalItemCount = mLinearLayoutManager.getItemCount();
    //    firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();
        lastVisibleItem=mLinearLayoutManager.findLastVisibleItemPosition();
    }

    /**
     * 提供一个抽闲方法，在Activity中监听到这个EndLessOnScrollListener
     * 并且实现这个方法
     * */
    public abstract void onLoadMore(int currentPage);}
