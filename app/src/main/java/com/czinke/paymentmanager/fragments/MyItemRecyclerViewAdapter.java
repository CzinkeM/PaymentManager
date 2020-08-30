package com.czinke.paymentmanager.fragments;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.czinke.paymentmanager.MainActivity;
import com.czinke.paymentmanager.R;
import com.czinke.paymentmanager.models.Item;
import com.czinke.paymentmanager.recycler_view_manager.OnItemClick;

import java.util.ArrayList;
import java.util.List;

import javax.sql.StatementEvent;

public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "Adapter";
    private final List<Item> mValues;

    public MyItemRecyclerViewAdapter(List<Item> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sample, parent, false);
      final ViewHolder mHolder = new ViewHolder(view);
        mHolder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = String.valueOf(mHolder.getAdapterPosition());
                Toast.makeText(view.getContext(),s,Toast.LENGTH_SHORT).show();
            }
        });
        mHolder.mCardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Item item = MainActivity.appDatabase.mydao().GetItems().get(mHolder.getAdapterPosition());
                MainActivity.appDatabase.mydao().DeleteItem(item);

                Fragment frg = null;
                frg = MainActivity.fragmentManager.findFragmentByTag("Home");
                final FragmentTransaction ft = MainActivity.fragmentManager.beginTransaction();
                ft.detach(frg);
                ft.attach(frg);
                ft.commit();
                Toast.makeText(view.getContext(),"item deleted", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        return mHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).getName());
        holder.mImageView.setImageResource(R.drawable.ic_launcher_foreground);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;
        public Item mItem;
        public CardView mCardView;
        public ImageView mImageView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mContentView = (TextView) view.findViewById(R.id.content);
            mCardView = (CardView) view.findViewById(R.id.CardView);
            mImageView = (ImageView) view.findViewById(R.id.imageView);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}