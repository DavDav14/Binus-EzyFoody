package com.example.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MyOrder extends AppCompatActivity {

    private ArrayList<String> orderanMinuman = new ArrayList<>();
    private ArrayList<String> orderanHarga = new ArrayList<>();
    private ArrayList<String> orderanQuantity = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        getDataOrder();
    }

    private void processAdapterMyOrder(){
        RecyclerView recycleMyOrder = findViewById(R.id.recycleMyOrder);
        AdapterMyOrder adapter = new AdapterMyOrder(orderanMinuman, orderanHarga, orderanQuantity,this);

        recycleMyOrder.setAdapter(adapter);
        recycleMyOrder.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getDataOrder(){
        if (getIntent().hasExtra("myOrder_namaMinuman") && getIntent().hasExtra("myOrder_harga") && getIntent().hasExtra("myOrder_quantity")){
            orderanMinuman.add(getIntent().getStringExtra("myOrder_namaMinuman"));
            orderanHarga.add(getIntent().getStringExtra("myOrder_harga"));
            orderanQuantity.add(getIntent().getStringExtra("myOrder_quantity"));

            processAdapterMyOrder();
//            setOrderActivity(orderanMinuman,orderanHarga,orderanQuantity);
        }
    }

//    private void setOrderActivity(ArrayList<String> orderanMinuman, ArrayList<String> orderanHarga, ArrayList<String> orderanQuantity){
//
//    }

}