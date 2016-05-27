package com.demo.srikanth.hierarchyviewer.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.srikanth.hierarchyviewer.R;
import com.demo.srikanth.hierarchyviewer.model.Body;
import com.demo.srikanth.hierarchyviewer.model.ChildCategory;

import java.util.List;

/**
 * Created by shrek on 5/26/16.
 */
public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildCategoryViewHolder> {

    ChildCategory category;

    @Override
    public ChildCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_level_layout, null);
        return new ChildCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChildCategoryViewHolder holder, int position) {
        holder.titleView.setText(category.getBody().get(position).getText());
    }

    @Override
    public int getItemCount() {
        if (category == null) {
            return 0;
        } else {
            return category.getBody().size();
        }
    }

    class ChildCategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView titleView;

        public ChildCategoryViewHolder(View itemView) {
            super(itemView);
            titleView = (TextView) itemView.findViewById(R.id.child_level_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Play the video here", Toast.LENGTH_LONG).show();
        }

    }

    public void setData(ChildCategory _childCategory) {

        List<Body> bodyArrayList = _childCategory.getBody();

        for (Body body : bodyArrayList ){
            Log.v("Testing",body.getText());
        }

    }

}
