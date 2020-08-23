package com.czinke.paymentmanager.recycler_view_manager;

import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.czinke.paymentmanager.R;

public class RecyclerHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener{

    TextView textViewName;
    OnItemClick onItemClick;

    public RecyclerHolder(@NonNull View itemView, OnItemClick OnItemClick) {
        super(itemView);
        this.textViewName = itemView.findViewById(R.id.textViewName);
        this.onItemClick = OnItemClick;
        itemView.setOnLongClickListener(this);
    }

    @Override
    public boolean onLongClick(View view) {
        onItemClick.ItemClickListener(getAdapterPosition());
        return false;
    }
}
