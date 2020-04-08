package com.sneha.assignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter_hist extends RecyclerView.Adapter<adapter_hist.Viewholder> {

    ArrayList<POJO> histList;

    public adapter_hist(ArrayList<POJO> histList) {
        this.histList = histList;
    }

    @NonNull
    @Override
    public adapter_hist.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View listitem = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_hist, parent, false);
        return new Viewholder(listitem);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        POJO his = histList.get(position);
        holder.tv_rating.setText(his.getRating());
        holder.tv_dnt.setText(his.getDnt());
    }


    @Override
    public int getItemCount() {
        return histList.size();
    }


    public class Viewholder extends RecyclerView.ViewHolder {

        TextView tv_rating, tv_dnt;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            tv_rating = itemView.findViewById(R.id.tv_rating);
            tv_dnt = itemView.findViewById(R.id.tv_dnt);
        }
    }
}
