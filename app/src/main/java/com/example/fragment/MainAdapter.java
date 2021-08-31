package com.example.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter <MainAdapter.ViewHolder>{
    private ArrayList <String> list;
    private OnClick onClick;

    public void setList(ArrayList<String> list,OnClick onClick) {
        this.list = new ArrayList<>();
        this.list = list;
        this.onClick = onClick;
        notifyDataSetChanged();
    }

    @NonNull
       @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate((R.layout.item_rv), parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  MainAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tittle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tittle = itemView.findViewById(R.id.tittle_tv);

        }

        public void onBind(String s) {
            tittle.setText(s);
            itemView.setOnClickListener(v->{
                onClick.onItemClick(s);
            });
        }
    }
        public interface OnClick{
           void onItemClick(String s);
        }

    }


