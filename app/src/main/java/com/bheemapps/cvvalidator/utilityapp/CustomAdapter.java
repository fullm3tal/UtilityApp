package com.bheemapps.cvvalidator.utilityapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ItemViewHolder> {

    private List<String> items;
    Context context;
    RecyclerViewClickListener listener;

    public CustomAdapter(List<String> items,
                         Context context,
                         RecyclerViewClickListener listener) {
        this.items = items;
        this.context = context;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        itemViewHolder.tvFeatureName.setText(items.get(i));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvFeatureName;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFeatureName = itemView.findViewById(R.id.tv_feature);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int position = this.getAdapterPosition();
            listener.onRecyclerViewItemClicked(position);
        }
    }

}
