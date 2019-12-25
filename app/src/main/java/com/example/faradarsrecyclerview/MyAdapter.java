package com.example.faradarsrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {

    private List<MyFriend> myFriends;
    public MyAdapter (List<MyFriend> myfriends){
        this.myFriends=(myfriends==null) ?
                new ArrayList<MyFriend>() :
                myfriends;
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.myfriend_list_item,parent,false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MyViewHolder nv=(MyViewHolder)holder;
        nv.bind(myFriends.get(position));
    }

    @Override
    public int getItemCount() {
        return myFriends.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvCity;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvName=(TextView)itemView.findViewById(R.id.tv_name);
            tvCity=(TextView)itemView.findViewById(R.id.tv_city);
        }
        public void bind(MyFriend myFriend){
            tvName.setText(myFriend.getName());
            tvCity.setText(myFriend.getCity());
        }
    }
}