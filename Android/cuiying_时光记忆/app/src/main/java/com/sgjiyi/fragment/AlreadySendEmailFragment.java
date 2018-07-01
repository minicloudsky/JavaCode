package com.sgjiyi.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.melnykov.fab.FloatingActionButton;
import com.sgjiyi.activity.R;
import com.sgjiyi.adapter.EmailRecycleAdapter;
import com.sgjiyi.model.EmailModel;
import com.sgjiyi.model.MemoryModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by acu on 2017/8/26.
 */

public class AlreadySendEmailFragment extends Fragment{

    private View emailView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private List<EmailModel> emailModelList;
    private LinearLayoutManager linearLayoutManager;
    private FloatingActionButton floatingActionButton;
    private EmailRecycleAdapter emailRecycleAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        emailView=inflater.inflate(R.layout.fragment_identical_index, null);
        initData();
        initView();//初始化控件
        emailRecycleAdapter=new EmailRecycleAdapter(emailView.getContext(),emailModelList);
        recyclerView.setAdapter(emailRecycleAdapter);
        linearLayoutManager=new LinearLayoutManager(emailView.getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        initListener();//初始化监听事件
        return emailView;
    }

    //初始化控件
    private void initView(){
        swipeRefreshLayout=emailView.findViewById(R.id.memory_swipe_refresh);
        recyclerView=emailView.findViewById(R.id.memory_content_list);
        floatingActionButton=emailView.findViewById(R.id.floatingActionButton_write);
        floatingActionButton.attachToRecyclerView(recyclerView);
        swipeRefreshLayout.setColorSchemeResources(R.color.google_blue,R.color.google_green,R.color.google_red,R.color.google_yellow);
    }

    //初始化监听事件
    private void initListener(){
        //List下拉刷新
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                EmailModel emailModel=new EmailModel();
                emailModel.setData(new Date());
                emailModelList.add(0,emailModel);
                emailRecycleAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        //写信悬浮按钮监听
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void initData(){
        emailModelList=new ArrayList<>();
        for (int i=0;i<10;i++){
            EmailModel emailModel=new EmailModel();
            emailModel.setData(new Date());
            emailModelList.add(emailModel);
        }
    }

}
