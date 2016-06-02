package com.demo.srikanth.hierarchyviewer.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.srikanth.hierarchyviewer.R;
import com.demo.srikanth.hierarchyviewer.model.Body;
import com.demo.srikanth.hierarchyviewer.model.Child;
import com.demo.srikanth.hierarchyviewer.model.ChildCategory;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shrek on 5/26/16.
 */
public class ChildAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int HEADER_ELEMENT = 1;
    private final int CHILD_ELEMENT = 2;
    private final List<Data> data = new ArrayList<>();


    public ChildAdapter(ChildCategory childCategory) {
        setData(childCategory);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        if (viewType == HEADER_ELEMENT) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_level_header_layout, null);
            return new TopLevelCategoryVieHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_level_layout, null);
            return new ChildCategoryViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (data.get(position).viewType == HEADER_ELEMENT) {
            TopLevelCategoryVieHolder viewHolder = (TopLevelCategoryVieHolder) holder;
            viewHolder.titleView.setText(data.get(position).text);
        } else if (data.get(position).viewType == CHILD_ELEMENT) {
            ChildCategoryViewHolder viewHolder = (ChildCategoryViewHolder) holder;
            viewHolder.titleView.setText(data.get(position).text);
            viewHolder.subText.setText(data.get(position).subText);
            Picasso.with(viewHolder.childImage.getContext()).load(data.get(position).imageUrl).into(viewHolder.childImage);
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
        private ImageView childImage;

        public ChildCategoryViewHolder(View itemView) {
            super(itemView);
            subText = (TextView) itemView.findViewById(R.id.child_level_sub_text);
            titleView = (TextView) itemView.findViewById(R.id.child_level_title);
            childImage = (ImageView) itemView.findViewById(R.id.child_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), R.string.logic_to_play_audio, Toast.LENGTH_LONG).show();
        }
    }

    class TopLevelCategoryVieHolder extends RecyclerView.ViewHolder {

        private TextView titleView;

        public TopLevelCategoryVieHolder(View itemView) {
            super(itemView);
            titleView = (TextView) itemView.findViewById(R.id.child_level_header_title);
        }
    }


    public void setData(ChildCategory _childCategory) {

        List<Body> bodyArrayList = _childCategory.getBody();

        for (Body body : bodyArrayList) {
            data.add(new Data(body.getText(), HEADER_ELEMENT));

            List<Child> children = body.getChildren();

            for (Child child : children) {
                data.add(new Data(child.getText(), child.getSubtext(), child.getImage(), CHILD_ELEMENT));
            }
        }
        notifyDataSetChanged();
    }

    private class Data {
        private String text;
        private String subText;
        private int viewType;
        private String imageUrl;

        public Data(String _text, String _subText, String _imageUrl, int _viewType) {
            text = _text;
            subText = _subText;
            viewType = _viewType;
            imageUrl = _imageUrl;
        }

        public Data(String _text, int _viewType) {
            text = _text;
            viewType = _viewType;
            subText = null;
        }
    }
}
