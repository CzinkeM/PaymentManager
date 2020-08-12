package com.czinke.paymentmanager.recycler_view_manager;

import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.czinke.paymentmanager.R;

public class RecyclerHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener{

    ImageView imageViewPriority;
    ImageView imageViewIcon;
    TextView textViewName;
    TextView textViewMoney;
    OnItemClick onItemClick;

    public RecyclerHolder(@NonNull View itemView, OnItemClick OnItemClick) {
        super(itemView);
        this.imageViewPriority = itemView.findViewById(R.id.imgPriority);
        this.imageViewIcon = itemView.findViewById(R.id.imgIcon);
        this.textViewName = itemView.findViewById(R.id.textName);
        this.textViewMoney = itemView.findViewById(R.id.textMoney);
        textViewMoney.setPaintFlags(Paint.FAKE_BOLD_TEXT_FLAG);
        this.onItemClick = OnItemClick;
        itemView.setOnLongClickListener(this);
    }

    @Override
    public boolean onLongClick(View view) {
        onItemClick.ItemClickListener(getAdapterPosition());
        return false;
    }
}
