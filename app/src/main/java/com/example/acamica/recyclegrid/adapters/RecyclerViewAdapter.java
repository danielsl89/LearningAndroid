package com.example.acamica.recyclegrid.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.getTextView().setText("Item: " + position);
    }

    @Override
    public int getItemCount() {
        return 1000;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private final TextView textView;

        public RecyclerViewHolder(View parent){
            super(parent);
            textView = (TextView) itemView.findViewById(android.R.id.text1);
        }

        public TextView getTextView(){
            return textView;
        }
    }
}
