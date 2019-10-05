package com.example.abhishek.blood;

import android.app.AlertDialog;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<User> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        ImageView imageViewIcon;
        TextView textViewCity;
        TextView textViewGender;
        TextView textViewBlood;
        TextView textViewMobile;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
            this.textViewCity = itemView.findViewById(R.id.textViewCity);
            this.textViewBlood = itemView.findViewById(R.id.textViewBlood);
            this.textViewGender = itemView.findViewById(R.id.textViewGender);
            this.textViewMobile = itemView.findViewById(R.id.textViewMobile);


        }
    }

    public CustomAdapter(ArrayList<User> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_content, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {
        TextView textViewName = holder.textViewName;
        //City
        TextView textViewBlood = holder.textViewBlood;
        TextView textViewMobile = holder.textViewMobile;
        TextView textViewGender = holder.textViewGender;
        TextView textViewCity = holder.textViewCity;
        ViewListContents viewListContents = new ViewListContents();
        if(dataSet.size() == 0){
            viewListContents.showDialog();
        }
        else{
            textViewName.setText("Name: "+dataSet.get(listPosition).Name);
            textViewCity.setText("City: "+dataSet.get(listPosition).City);
            textViewGender.setText("Gender: "+dataSet.get(listPosition).Gender);
            textViewBlood.setText("Blood Grp: "+dataSet.get(listPosition).BloodGrp);
            textViewMobile.setText("Mobile: "+dataSet.get(listPosition).Mobile);
        }


    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


}



