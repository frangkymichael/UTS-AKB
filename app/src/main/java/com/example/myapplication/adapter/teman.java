package com.example.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.Friends;


import java.util.ArrayList;

//tanggal pengeerjaan : 20-05-2019
//nim  : 10116569
//nama : Frangky michael
//kelas: IF 13

public class teman extends RecyclerView.Adapter<teman.ViewHolder> {
    ArrayList<Friends> friends ;
    Context context;
    private ClickHandler mClick;
    private ArrayList<Integer> mSelected;

    public teman(ArrayList<Friends> friends, Context context, ClickHandler mClick) {
        this.friends = friends;
        this.context = context;
        this.mClick = mClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_friend, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.fnim.setText(friends.get(position).getFnim());
        holder.fname.setText(friends.get(position).getFname());
        holder.fclass.setText(friends.get(position).getFclass());
        holder.fphone.setText(friends.get(position).getFphone());
        holder.femail.setText(friends.get(position).getFemail());
        holder.fsosmed.setText(friends.get(position).getFsosmed());
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView fnim, fname, fclass, fphone, femail, fsosmed;

        public ViewHolder(View itemView) {
            super(itemView);
            fnim = itemView.findViewById(R.id.friend_nim);
            fname = itemView.findViewById(R.id.friend_name);
            fclass = itemView.findViewById(R.id.friend_class);
            fphone = itemView.findViewById(R.id.friend_phone);
            femail = itemView.findViewById(R.id.friend_email);
            fsosmed = itemView.findViewById(R.id.friend_social_media);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            mClick.onItemClick(getAdapterPosition());
        }
    }
        int selectionCount(){
            return mSelected.size();
        }
        public interface ClickHandler{
            void onItemClick(int position);
        }
}
