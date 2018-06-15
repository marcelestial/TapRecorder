package com.spaceside.marcel.taprecorder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TimeListAdapter extends RecyclerView.Adapter<TimeListAdapter.TimeViewHolder>{

    class TimeViewHolder extends RecyclerView.ViewHolder {
        private final TextView timeItemView;

        private TimeViewHolder(View itemView){
            super(itemView);
            timeItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Time> mTimes;

    TimeListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public TimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new TimeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TimeViewHolder holder, int position){
        if(mTimes != null){
            Time current = mTimes.get(position);
            holder.timeItemView.setText(current.getTime());
        }else{
            holder.timeItemView.setText("No Data");
        }
    }

    void setTimes(List<Time> times){
        mTimes = times;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mTimes != null)
            return mTimes.size();
        else return 0;
    }


}
