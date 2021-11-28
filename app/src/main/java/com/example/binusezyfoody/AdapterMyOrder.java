package com.example.binusezyfoody;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class AdapterMyOrder extends RecyclerView.Adapter<AdapterMyOrder.ViewHolder>{

    private ArrayList<String> orderanMinuman = new ArrayList<>();
    private ArrayList<String> orderanHarga = new ArrayList<>();
    private ArrayList<String> orderanQuantity = new ArrayList<>();
    private Context context;

    public AdapterMyOrder(ArrayList<String> orderanMinuman, ArrayList<String> orderanHarga,
                          ArrayList<String> orderanQuantity, Context context) {
        this.orderanMinuman = orderanMinuman;
        this.orderanHarga = orderanHarga;
        this.orderanQuantity = orderanQuantity;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_myorder,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.myDrinks.setText(orderanMinuman.get(position));
        holder.myPrice.setText(orderanHarga.get(position));
        holder.myQuantity.setText(orderanQuantity.get(position));
    }

    @Override
    public int getItemCount() {
        return orderanMinuman.size();
    }


    // Method View Holder nya
    public class  ViewHolder extends RecyclerView.ViewHolder{
        TextView myDrinks, myPrice, myQuantity;
        ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myDrinks = itemView.findViewById(R.id.myDrinks);
            myPrice = itemView.findViewById(R.id.myPrice);
            myQuantity = itemView.findViewById(R.id.myQuantity);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);
        }
    }

}
