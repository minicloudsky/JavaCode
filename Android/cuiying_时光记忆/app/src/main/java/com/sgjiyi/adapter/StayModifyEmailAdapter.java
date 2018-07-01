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

import cn.iwgang.countdownview.CountdownView;

/**
 * Created by acu on 2017/8/26.
 */

public class StayModifyEmailAdapter extends RecyclerView.Adapter<StayModifyEmailAdapter.emailViewHolder>{
    private LayoutInflater layoutInflater;
    private Context context;
    private List<EmailModel> emailModelList;
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);
    }

    private StayModifyEmailAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(StayModifyEmailAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public StayModifyEmailAdapter(Context context,List<EmailModel> emailModelList){
        this.emailModelList=emailModelList;
        this.context=context;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public StayModifyEmailAdapter.emailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StayModifyEmailAdapter.emailViewHolder(layoutInflater.inflate(R.layout.item_stay_modify_email,parent,false));
    }

    @Override
    public void onBindViewHolder(final StayModifyEmailAdapter.emailViewHolder holder, final int position) {
        if(position==0){
            holder.tvTopLine.setVisibility(View.INVISIBLE);
        }else{
            holder.tvTopLine.setVisibility(View.VISIBLE);
        }
        if(onItemClickListener!=null){

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(holder.itemView,position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    onItemClickListener.onItemLongClick(holder.itemView,position);
                    return false;
                }
            });
        }
        holder.bindHolder(emailModelList.get(position),position);
    }

    @Override
    public int getItemCount() {
        return emailModelList!=null?emailModelList.size():0;
    }

    public class emailViewHolder extends RecyclerView.ViewHolder{

        private TextView startDate,title,content;
        private CountdownView countdownView;

        private TextView tvTopLine;

        public emailViewHolder(View itemView) {
            super(itemView);
            tvTopLine = itemView.findViewById(R.id.tvTopLine);
            startDate=itemView.findViewById(R.id.email_start_time);
            title=itemView.findViewById(R.id.stay_modify_email_title);
            content=itemView.findViewById(R.id.stay_modify_email_content);
            countdownView=itemView.findViewById(R.id.modify_count_down);
        }
        public void bindHolder(EmailModel emailModel, final int position){

            startDate.setText("写于  "+emailModel.getData().toString());
            title.setText(emailModel.getTitle());
            content.setText(emailModel.getContent());
            countdownView.start(emailModel.getCountDown());
            countdownView.setOnCountdownEndListener(new CountdownView.OnCountdownEndListener() {
                @Override
                public void onEnd(CountdownView cv) {
                    emailModelList.remove(position);
                    notifyDataSetChanged();
                }
            });
        }
    }
}
