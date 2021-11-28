package com.example.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class Order extends AppCompatActivity {

    //Deklarasi var untuk quantity
    Integer minteger = 0;

    Button btnMyOrder;
    Button btnOrder;

    // Deklarasi var untuk button order more
    Button btnOrderMore;

    // Deklarasikan variabel penampung dari desain
    ImageView orderImageMinuman;
    TextView orderNamaMinuman, orderHarga, orderInfoMinuman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // Untuk MyOrder
        btnMyOrder = findViewById(R.id.btnMyOrder);
        btnMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MyOrder.class));
            }
        });

        // Untuk OrderMore
        btnOrderMore = findViewById(R.id.btnOrderMore);
        btnOrderMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Drinks.class));
            }
        });

        // Inisiasi variabel dengan ID dari desain
        orderImageMinuman = findViewById(R.id.orderImageMinuman);
        orderNamaMinuman = findViewById(R.id.orderNamaMinuman);
        orderHarga = findViewById(R.id.orderHarga);
        orderInfoMinuman = findViewById(R.id.orderInfoMinuman);

        // Deklarasikan method untuk menampung data yang masuk
        getIncomingExtra();

        // Click listener untuk OrderNow
        btnOrder = findViewById(R.id.btnOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Your order success added", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MyOrder.class);
                intent.putExtra("myOrder_namaMinuman",orderNamaMinuman.getText().toString());
                intent.putExtra("myOrder_harga",orderHarga.getText().toString());
                intent.putExtra("myOrder_quantity",minteger.toString());

                getApplicationContext().startActivity(intent);
            }
        });
    }

    // Buat method untuk Increase dan Decrease
    public void increaseInteger(View view) {
        minteger = minteger + 1;
        display(minteger);

    }public void decreaseInteger(View view) {
        if(minteger < 1){
            Toast.makeText(this, "Cannot less than 0", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            minteger = minteger - 1;
            display(minteger);
        }
    }

    private void display(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.integer_number);
        displayInteger.setText("" + number);
    }

    // Method untuk menampung nilai yang dikirim dari Adapter
    private void getIncomingExtra(){
        // Untuk mengecek apakah ada yang datanya NULL
        if(getIntent().hasExtra("foto_minuman") && getIntent().hasExtra("nama_minuman") && getIntent().hasExtra("harga_minuman") && getIntent().hasExtra("info_minuman")){

            // Menampung nilai yang dikirim dari Adapter ke dalam Variabel
            String fotoMinuman = getIntent().getStringExtra("foto_minuman");
            String namaMinuman = getIntent().getStringExtra("nama_minuman");
            String hargaMinuman = getIntent().getStringExtra("harga_minuman");
            String infoMinuman = getIntent().getStringExtra("info_minuman");

            // Mendeklarasikan method baru untuk mengirimkan nilainya yang kita tampung diatas ke dalam method baru
            setDataActivity(fotoMinuman,namaMinuman,hargaMinuman,infoMinuman);
        }
    }

    // Method yang digunakan untuk mengirim datanya ke dalam objek yang sudah didesain di activity_order
    private void setDataActivity(String fotoMinuman, String namaMinuman, String hargaMinuman, String infoMinuman){

        Glide.with(this).asBitmap().load(fotoMinuman).into(orderImageMinuman);
        orderNamaMinuman.setText(namaMinuman);
        orderHarga.setText(hargaMinuman);
        orderInfoMinuman.setText(infoMinuman);
    }
}