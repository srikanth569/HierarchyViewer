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

/**
 * Created by shrek on 5/26/16.
 */
public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildCategoryViewHolder> {

    private final int HEADER_ELEMENT = 1;
    private final int CHILD_ELEMENT = 2;
    private final List<Data> data = new ArrayList<>();


    public ChildAdapter(ChildCategory childCategory) {
        setData(childCategory);
    }

    @Override
    public ChildCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        if (viewType == HEADER_ELEMENT) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_level_header_layout, null);
        } else if (viewType == CHILD_ELEMENT) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_level_layout, null);
        }

        return new ChildCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChildCategoryViewHolder holder, int position) {
        holder.titleView.setText(data.get(position).text);
        if (data.get(position).viewType == CHILD_ELEMENT) {
            holder.subText.setText(data.get(position).subText);
        }
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
        private TextView subText;

        public ChildCategoryViewHolder(View itemView) {
            super(itemView);
            subText = (TextView) itemView.findViewById(R.id.child_level_sub_text);
            titleView = (TextView) itemView.findViewById(R.id.child_level_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (data.get(position).viewType == 2) {
                Toast.makeText(v.getContext(), R.string.logic_to_play_audio, Toast.LENGTH_LONG).show();
            }
        }

    }

    public void setData(ChildCategory _childCategory) {

        List<Body> bodyArrayList = _childCategory.getBody();

        for (Body body : bodyArrayList) {
            data.add(new Data(body.getText(), HEADER_ELEMENT));

            List<Child> children = body.getChildren();

            for (Child child : children) {
                data.add(new Data(child.getText(), child.getSubtext(), CHILD_ELEMENT));
            }
        }
        notifyDataSetChanged();
    }

    private class Data {
        private String text;
        private String subText;
        private int viewType;

        public Data(String _text, String _subText, int _viewType) {
            text = _text;
            subText = _subText;
            viewType = _viewType;
        }

        public Data(String _text, int _viewType) {
            text = _text;
            viewType = _viewType;
            subText = null;
        }
    }
}
