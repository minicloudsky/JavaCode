package com.sgjiyi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sgjiyi.activity.R;
import com.sgjiyi.model.EmailModel;

import java.util.List;

/**
 * Created by acu on 2017/8/26.
 */

public class EmailRecycleAdapter extends RecyclerView.Adapter<EmailRecycleAdapter.emailViewHolder>{

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
    private List<EmailModel> emailModelList;

    public EmailRecycleAdapter(Context context,List<EmailModel> emailModelList){
        this.emailModelList=emailModelList;
        this.context=context;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public emailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new emailViewHolder(layoutInflater.inflate(R.layout.item_already_send_email,parent,false));
    }

    @Override
    public void onBindViewHolder(emailViewHolder holder, int position) {
        if(position==0){
            holder.tvTopLine.setVisibility(View.INVISIBLE);
        }else{
            holder.tvTopLine.setVisibility(View.VISIBLE);
        }
        holder.bindHolder(emailModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return emailModelList!=null?emailModelList.size():0;
    }

    public class emailViewHolder extends RecyclerView.ViewHolder{

        private TextView data;
        private TextView tvTopLine, tvDot;

        public emailViewHolder(View itemView) {
            super(itemView);
            tvTopLine = itemView.findViewById(R.id.tvTopLine);
            tvDot = itemView.findViewById(R.id.tvDot);
            data=itemView.findViewById(R.id.email_Time);
        }
        public void bindHolder(EmailModel emailModel){
            data.setText("写于  "+emailModel.getData().toString());
        }
    }
}
