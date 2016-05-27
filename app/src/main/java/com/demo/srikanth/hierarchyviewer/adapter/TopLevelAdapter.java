package com.demo.srikanth.hierarchyviewer.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.srikanth.hierarchyviewer.R;
import com.demo.srikanth.hierarchyviewer.model.Body;
import com.demo.srikanth.hierarchyviewer.model.TopLevelCategories;

/**
 * Created by shrek on 5/26/16.
 */
public class TopLevelAdapter extends RecyclerView.Adapter<TopLevelAdapter.TopLevelViewHolder> {

    private TopLevelCategories categories;
    private OnClickListener onClickListener;

    public TopLevelAdapter(TopLevelCategories _categories) {
        categories = _categories;
    }

    @Override
    public TopLevelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_level_layout, null);
        return new TopLevelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TopLevelViewHolder holder, int position) {
        holder.titleView.setText(categories.getBody().get(position).getText());
    }

    @Override
    public int getItemCount() {
        if (categories == null) {
            return 0;
        }
        return categories.getBody().size();
    }

    public void setData(TopLevelCategories _categories) {
        categories = _categories;
        notifyDataSetChanged();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    class TopLevelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView titleView;

        public TopLevelViewHolder(View itemView) {
            super(itemView);
            titleView = (TextView) itemView.findViewById(R.id.top_level_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.v("Testing", "Clicked on " + getAdapterPosition());
            if (onClickListener != null) {
                onClickListener.OnClick(categories.getBody().get(getAdapterPosition()));
            }
        }

    }

    public interface OnClickListener {
        void OnClick(Body body);
    }

}


