package com.czinke.paymentmanager.recycler_view_manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.czinke.paymentmanager.models.Item;
import com.czinke.paymentmanager.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerHolder> {

    Context c;
    ArrayList<Item> items;
    private OnItemClick onItemClick;

    public RecyclerAdapter(Context c, ArrayList<Item> items, OnItemClick OnItemClick) {
        this.c = c;
        this.items = items;
        this.onItemClick = OnItemClick;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sample,null);
        return new RecyclerHolder(view, onItemClick) ;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int i) {
        holder.imageViewPriority.setImageResource(items.get(i).getPriority());
        holder.imageViewIcon.setImageResource(items.get(i).getIcon());
        holder.textViewName.setText(items.get(i).getName());
        holder.textViewMoney.setText(items.get(i).getMoney() + " ");
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
