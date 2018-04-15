package com.example.acamica.recyclegrid.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(parent);
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

        public RecyclerViewHolder(ViewGroup parent){
            super(LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false) );
            textView = (TextView) itemView.findViewById(android.R.id.text1);
        }

        public TextView getTextView(){
            return textView;
        }
    }
}
