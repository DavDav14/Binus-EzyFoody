package com.example.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MyOrder extends AppCompatActivity {

    private ArrayList<String> orderanMinuman = new ArrayList<>();
    private ArrayList<String> orderanHarga = new ArrayList<>();
    private ArrayList<String> orderanQuantity = new ArrayList<>();

    Button btnPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        btnPay = findViewById(R.id.btnPay);
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Pay.class));
            }
        });


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