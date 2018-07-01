package com.sgjiyi.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;
import com.melnykov.fab.FloatingActionButton;
import com.sgjiyi.activity.R;
import com.sgjiyi.adapter.DraftsEmailAdapter;
import com.sgjiyi.adapter.MemoryRecyclerAdapter;
import com.sgjiyi.model.EmailModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by acu on 2017/8/26.
 */

public class DraftsEmailFragment extends Fragment{
    private View emailView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private List<EmailModel> emailModelList;
    private LinearLayoutManager linearLayoutManager;
    private FloatingActionButton floatingActionButton;
    private DraftsEmailAdapter draftsEmailAdapter;
    private NiftyDialogBuilder dialogBuilder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        emailView=inflater.inflate(R.layout.fragment_identical_index, null);
        initData();
        initView();//初始化控件
        draftsEmailAdapter=new DraftsEmailAdapter(emailView.getContext(),emailModelList);
        recyclerView.setAdapter(draftsEmailAdapter);
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
        dialogBuilder=NiftyDialogBuilder.getInstance(emailView.getContext());
    }

    //初始化监听事件
    private void initListener(){

        //Item单击监听
        draftsEmailAdapter.setOnItemClickListener(new DraftsEmailAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View view,int position) {
            }

            @Override
            public void onItemLongClick(View view,final int position) {
                dialogBuilder.withTitle("邮件删除").withMessage("你确定要删除这封未寄出的邮件吗？")
                        .withButton1Text("确定").withButton2Text("取消")
                        .isCancelableOnTouchOutside(true)
                        .setButton1Click(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialogBuilder.dismiss();
                                Toast.makeText(getActivity(),"确定:"+position,Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setButton2Click(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialogBuilder.dismiss();
                                Toast.makeText(getActivity(),"取消:"+position,Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });
        //List下拉刷新
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                EmailModel emailModel=new EmailModel();
                emailModel.setData(new Date());
                emailModel.setContent("有时候我发现，很多难堪的甚至是悔恨和伤痛的记忆，总是难以从自己的生命中剔除，总是难以释怀和放下。");
                emailModel.setTitle("至29岁的自己");
                emailModelList.add(0,emailModel);
                draftsEmailAdapter.notifyDataSetChanged();
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
            emailModel.setContent("有时候我发现，很多难堪的甚至是悔恨和伤痛的记忆，总是难以从自己的生命中剔除，总是难以释怀和放下。");
            emailModel.setTitle("至2"+i+"岁的自己");
            emailModelList.add(emailModel);
        }
    }
}
