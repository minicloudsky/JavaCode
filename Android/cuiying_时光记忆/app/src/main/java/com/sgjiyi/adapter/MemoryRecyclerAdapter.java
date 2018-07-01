package com.sgjiyi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sgjiyi.activity.R;
import com.sgjiyi.model.MemoryModel;

import java.util.List;


/**
 * Created by acu on 2017/8/24.
 */

public class MemoryRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private LayoutInflater layoutInflater;
    private Context context;
    private static final int TYPE_ITEM=0;  //普通Item View
    private static final int TYPE_FOOTER=1;  //底部FootView

    //上拉加载更多
    static final int PULL_LOAD_MORE = 0;
    //正在加载更多
    static final int LOADING_MORE = 1;
    //没有更多
    static final int NO_MORE = 2;
    //脚布局当前的状态,默认为没有更多
    int footer_state = 1;

    private List<MemoryModel> memoryModelList;
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    public MemoryRecyclerAdapter(Context context, List<MemoryModel> memoryModelList){
        this.context=context;
        this.memoryModelList=memoryModelList;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View view;
        if(viewType==TYPE_FOOTER){
            view=layoutInflater.inflate(R.layout.item_footer,parent,false);
            return new FooterViewHolder(view);
        }else{
            view=layoutInflater.inflate(R.layout.item_memory,parent,false);
            return new ContentViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(!(holder instanceof FooterViewHolder)){
            final ContentViewHolder contentViewHolder=(ContentViewHolder)holder;
            contentViewHolder.time.setTag(memoryModelList.get(position));
            contentViewHolder.time.setText(memoryModelList.get(position).getData());
            contentViewHolder.title.setText(memoryModelList.get(position).getTitle());
            contentViewHolder.content.setText(memoryModelList.get(position).getContent());
            contentViewHolder.image.setImageResource(R.drawable.test);
            if(onItemClickListener!=null){
                contentViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemClick(contentViewHolder.itemView,position);
                    }
                });

                contentViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        onItemClickListener.onItemLongClick(contentViewHolder.itemView,position);
                        return false;
                    }
                });
            }
        }else{
            FooterViewHolder footerViewHolder=(FooterViewHolder) holder;
            if(position==0){
                footerViewHolder.progressBar.setVisibility(View.GONE);
                footerViewHolder.progressbar_tv.setVisibility(View.GONE);
            }else{
                switch (footer_state){
                    case PULL_LOAD_MORE:
                        footerViewHolder.progressBar.setVisibility(View.GONE);
                        footerViewHolder.progressbar_tv.setText("上拉加载更多");
                        break;
                    case LOADING_MORE:
                        footerViewHolder.progressBar.setVisibility(View.VISIBLE);
                        footerViewHolder.progressbar_tv.setText("正在加载记忆...");
                        break;
                    case NO_MORE:
                        footerViewHolder.progressBar.setVisibility(View.GONE);
                        footerViewHolder.progressbar_tv.setText("记忆见底了");
                        break;
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return memoryModelList!=null ? memoryModelList.size()+1 : 0;
    }

    public class ContentViewHolder extends RecyclerView.ViewHolder
    {
        TextView time;
        TextView title;
        TextView content;
        ImageView image;

        public ContentViewHolder(View itemView)
        {
            super(itemView);
            time=itemView.findViewById(R.id.memory_time);
            title=itemView.findViewById(R.id.memory_title);
            content=itemView.findViewById(R.id.memory_desc);
            image=itemView.findViewById(R.id.memory_img);
        }
    }
    public class FooterViewHolder extends RecyclerView.ViewHolder{
        ProgressBar progressBar;
        TextView progressbar_tv;
        public FooterViewHolder(View itemView) {
            super(itemView);
            progressBar=itemView.findViewById(R.id.progressbar);
            progressbar_tv=itemView.findViewById(R.id.progressbar_tv);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position+1==getItemCount()){
            return TYPE_FOOTER;
        }else{
            return TYPE_ITEM;
        }
    }

    public void changeState(int state){
        this.footer_state=state;
        notifyDataSetChanged();
    }

}
