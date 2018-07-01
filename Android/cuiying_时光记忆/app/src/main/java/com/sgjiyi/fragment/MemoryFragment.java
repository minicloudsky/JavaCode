package com.sgjiyi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.sgjiyi.Listener.EndLessOnScrollListener;
import com.sgjiyi.activity.R;
import com.sgjiyi.activity.StorageMemoryActivity;
import com.sgjiyi.adapter.MemoryRecyclerAdapter;
import com.sgjiyi.model.MemoryModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acu on 2017/8/24.
 */

public class MemoryFragment extends Fragment{

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private List<MemoryModel> memoryModelList;
    private MemoryRecyclerAdapter memoryRecyclerAdapter;
    private View memoryView;
    private LinearLayoutManager linearLayoutManager;
    private FloatingActionButton floatingActionButton;
    private NiftyDialogBuilder dialogBuilder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        memoryView=inflater.inflate(R.layout.fragment_identical_index, null);
        initData();
        initView();
        memoryRecyclerAdapter=new MemoryRecyclerAdapter(memoryView.getContext(),memoryModelList);

        recyclerView.setAdapter(memoryRecyclerAdapter);
        linearLayoutManager=new LinearLayoutManager(memoryView.getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

    //    Toast.makeText(getActivity(),"cg001",Toast.LENGTH_SHORT).show();
        initListener();
        return memoryView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private void initView(){
        swipeRefreshLayout=memoryView.findViewById(R.id.memory_swipe_refresh);
        recyclerView=memoryView.findViewById(R.id.memory_content_list);
        floatingActionButton=memoryView.findViewById(R.id.floatingActionButton_write);
        floatingActionButton.attachToRecyclerView(recyclerView);

        swipeRefreshLayout.setColorSchemeResources(R.color.google_blue,R.color.google_green,R.color.google_red,R.color.google_yellow);
        dialogBuilder=NiftyDialogBuilder.getInstance(memoryView.getContext());
      //  Log.d("wnwn", "---------------------666666666666666------------------");
    }

    private void initData(){
        memoryModelList=new ArrayList<>();
        for (int i=0;i<6;i++){
            MemoryModel memoryModel=new MemoryModel();
            memoryModel.setTitle("致自己"+i);
            memoryModel.setData("2017-08-0"+i);
            memoryModel.setContent("20后岁的你好吗，好久不见，还记得20岁的你吗。甚是怀念。");
            memoryModelList.add(memoryModel);
        }
    }

    //注册监听开始
    private void initListener(){
        //Item单击监听
        memoryRecyclerAdapter.setOnItemClickListener(new MemoryRecyclerAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View view,int position) {
                Toast.makeText(getActivity(),"click:"+position,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view,final int position) {
                dialogBuilder.withTitle("记忆删除").withMessage("你确定要删除这份记忆吗？")
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
                MemoryModel memoryModel=new MemoryModel();
                memoryModel.setData("2017-08-25");
                memoryModel.setTitle("下拉刷新添加");
                memoryModel.setContent("真是简单了不少啊，可惜了。");
                memoryModelList.add(0,memoryModel);
                memoryRecyclerAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
         //       Toast.makeText(getActivity(),"成功",Toast.LENGTH_SHORT).show();
            }
        });
        //List上拉加载更多
        recyclerView.addOnScrollListener(new EndLessOnScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int currentPage) {

                if(currentPage>=5){
                    memoryRecyclerAdapter.changeState(2);
                }else{
                    memoryRecyclerAdapter.changeState(1);
                    loadMoreData();
                }
            }
        });

        //跳转至发布界面
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(getActivity(), StorageMemoryActivity.class);
                startActivity(it);
            }
        });

    }
    //注册监听结束


    //每次上拉加载的时候，给RecyclerView的后面添加了10条数据数据
    private void loadMoreData(){
                for (int i =0; i < 3; i++){
                    MemoryModel memoryModel=new MemoryModel();
                    memoryModel.setTitle("致自己"+i);
                    memoryModel.setData("2017-08-0"+i);
                    memoryModel.setContent("20后岁的你好吗，好久不见，还记得20岁的你吗。甚是怀念。");
                    memoryModelList.add(memoryModel);
                }
        memoryRecyclerAdapter.notifyDataSetChanged();
       /* recyclerView.post(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                memoryRecyclerAdapter.notifyDataSetChanged();
           //     memoryRecyclerAdapter.notifyItemInserted(memoryModelList.size());
            }
        });*/
    }

}
