package com.demo.srikanth.hierarchyviewer.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.srikanth.hierarchyviewer.R;
import com.demo.srikanth.hierarchyviewer.model.Body;
import com.demo.srikanth.hierarchyviewer.model.Child;
import com.demo.srikanth.hierarchyviewer.model.ChildCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by shrek on 5/26/16.
 */
public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildCategoryViewHolder> {

    ChildCategory category;
    List<Data> data = new ArrayList<>();

    public ChildAdapter(ChildCategory childCategory) {
        setData(childCategory);
    }

    @Override
    public ChildCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        if (viewType == 1) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_level_header_layout, null);
        } else if (viewType == 2) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_level_layout, null);
        }

        return new ChildCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChildCategoryViewHolder holder, int position) {
        holder.titleView.setText(data.get(position).text);
    }

    @Override
    public int getItemCount() {
        if (data == null) {
            return 0;
        } else {
            return data.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).viewType;
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

        for (Body body : bodyArrayList) {
            data.add(new Data(body.getText(), 1));

            List<Child> children = body.getChildren();

            for (Child child : children) {
                data.add(new Data(child.getText(), 2));
            }
        }
        notifyDataSetChanged();
    }

    private class Data {
        private String text;
        private int viewType;

        public Data(String _text, int i) {
            text = _text;
            viewType = i;
        }
    }
}
