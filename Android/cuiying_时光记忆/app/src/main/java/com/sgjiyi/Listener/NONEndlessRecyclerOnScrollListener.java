package com.sgjiyi.Listener;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by acu on 2017/8/25.
 */

public abstract class NONEndlessRecyclerOnScrollListener extends RecyclerView.OnScrollListener{
    private int previousTotal = 0;
    private boolean isLoading = false;
    private int totalItemCount;
    private int lastVisibleItem;

    private int currentPage = 1;

    private LinearLayoutManager mLinearLayoutManager;

    public NONEndlessRecyclerOnScrollListener(
            LinearLayoutManager linearLayoutManager) {
        this.mLinearLayoutManager = linearLayoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        lastVisibleItem = mLinearLayoutManager.findLastVisibleItemPosition();
        totalItemCount=mLinearLayoutManager.getItemCount();
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        if(newState==RecyclerView.SCROLL_STATE_IDLE&&lastVisibleItem+1==totalItemCount&&!isLoading){
            currentPage ++;
            onLoadMore(currentPage);
            isLoading = true;
        }
    }

    public abstract void onLoadMore(int currentPage);
}
