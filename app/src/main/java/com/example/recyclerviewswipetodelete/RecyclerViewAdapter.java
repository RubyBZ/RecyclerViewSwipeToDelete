package com.example.recyclerviewswipetodelete;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private ArrayList<String> data;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitle;
        //Option 1 - drawing the background
        RelativeLayout relativeLayout;

        //Option 2 - putting layout one on top the other - revealing in onSwipe the background layout
        RelativeLayout viewBackground, viewForeground;

        public MyViewHolder(View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.txtTitle);

            //Option2 - configuring 2 layout
            viewBackground = itemView.findViewById(R.id.view_background);
            viewForeground = itemView.findViewById(R.id.view_foreground);
        }
    }

    public RecyclerViewAdapter(ArrayList<String> data) {
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Option 1
        //View itemView1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_row_option1, parent, false);
        //return new MyViewHolder(itemView1);

        //Option2
        View itemView2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_row_option2, parent, false);
        return new MyViewHolder(itemView2);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTitle.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public void removeItem(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(String item, int position) {
        data.add(position, item);
        notifyItemInserted(position);
    }

    public ArrayList<String> getData() {
        return data;
    }
}

