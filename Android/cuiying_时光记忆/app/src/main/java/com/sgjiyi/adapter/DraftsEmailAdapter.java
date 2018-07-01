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

public class DraftsEmailAdapter extends RecyclerView.Adapter<DraftsEmailAdapter.emailViewHolder>{

    private LayoutInflater layoutInflater;
    private Context context;
    private List<EmailModel> emailModelList;
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);
    }

    private DraftsEmailAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(DraftsEmailAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public DraftsEmailAdapter(Context context,List<EmailModel> emailModelList){
        this.emailModelList=emailModelList;
        this.context=context;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public DraftsEmailAdapter.emailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DraftsEmailAdapter.emailViewHolder(layoutInflater.inflate(R.layout.item_drafts_email,parent,false));
    }

    @Override
    public void onBindViewHolder(final DraftsEmailAdapter.emailViewHolder holder, final int position) {
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
        holder.bindHolder(emailModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return emailModelList!=null?emailModelList.size():0;
    }

    public class emailViewHolder extends RecyclerView.ViewHolder{

        private TextView startDate,title,content;
        private TextView tvTopLine;

        public emailViewHolder(View itemView) {
            super(itemView);
            tvTopLine = itemView.findViewById(R.id.tvTopLine);
            startDate=itemView.findViewById(R.id.email_drafts_time);
            title=itemView.findViewById(R.id.drafts_email_content);
            content=itemView.findViewById(R.id.drafts_email_content);
        }

        public void bindHolder(EmailModel emailModel){
            startDate.setText("写于  "+emailModel.getData().toString());
            title.setText(emailModel.getTitle());
            content.setText(emailModel.getContent());
        }
    }
}
