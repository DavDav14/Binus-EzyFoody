package com.example.binusezyfoody;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Drinks extends AppCompatActivity {

    Button btnDrinksToMain;
    Button btnMyOrder;

    // Membuat array list yg berasal dari Adapter agar sama datanya ketika dikirim
    private ArrayList<String> imageDrinks = new ArrayList<>();
    private ArrayList<String> nameDrinks = new ArrayList<>();
    private ArrayList<String> priceDrinks = new ArrayList<>();
    private ArrayList<String> infoDrinks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        // Ketika program dibuat, langsung mengambil data dari internet
        getDataFromInternet();

        btnMyOrder = findViewById(R.id.btnMyOrder);
        btnMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MyOrder.class));
            }
        });

        // Buat button back ke main menu
        btnDrinksToMain = findViewById(R.id.btnDrinksToMain);
        btnDrinksToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }

    // Untuk memproses RecyclerView nya
    private void processRecyclerViewAdapter(){
        // Mendeklarasikan objek dari recyclerview di activity_drinks
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // Memanggil adapter yang sudah dibuat sebelumnya
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(imageDrinks,nameDrinks,priceDrinks,infoDrinks,this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getDataFromInternet(){
        imageDrinks.add("https://asset.kompas.com/crops/g9Id9x04bjjC5unJ4IhketFYRWw=/0x0:780x520/750x500/data/photo/2020/03/27/5e7dd909de795.jpg");
        nameDrinks.add("Bandrek");
        priceDrinks.add("Rp 10.000");
        infoDrinks.add("Bandrek adalah minuman yang sangat pas jika sedang diminum di cuaca yang dingin, tunggu apa lagi? ayo langsung pesan minuman ini ");

        imageDrinks.add("https://asset.kompas.com/crops/e2RUgcc78UzoHbycOali2WgUEEQ=/0x0:1000x667/750x500/data/photo/2020/03/29/5e808eb0701d1.jpg");
        nameDrinks.add("Bir Pletok");
        priceDrinks.add("Rp 18.000");
        infoDrinks.add("Tenang, walaupun ada kata bir, minuman ini tidak memabukkan, malah menyehatkan dikarenakan memakai bahan alami.Tunggu apa lagi? ayo langsung pesan minuman ini ");

        imageDrinks.add("https://cdn.idntimes.com/content-images/community/2021/02/fromandroid-c148ce45a4d2690df0b8681b02494f69.jpg");
        nameDrinks.add("Es Cendol");
        priceDrinks.add("Rp 12.000");
        infoDrinks.add("Terbuat dari tepung beras, es cendol biasa disajikan bersama santan, gula merah cair, dan es serut.Tunggu apa lagi? ayo langsung pesan minuman ini ");

        imageDrinks.add("https://cdn.idntimes.com/content-images/community/2021/02/fromandroid-280925ec3917e3bf804b1cf16b45a090.jpg");
        nameDrinks.add("Bajigur");
        priceDrinks.add("Rp 10.000");
        infoDrinks.add("Berbahan dasar gula aren, santan, jahe, dan bahan rempah lainnya. Bajigur menjadi salah satu pilihan minuman yang tepat dan cocok diseruput di saat cuaca dingin serta musim hujan seperti sekarang..Tunggu apa lagi? ayo langsung pesan minuman ini ");

        imageDrinks.add("https://cdn.idntimes.com/content-images/community/2021/02/fromandroid-1bb939e0ece3018e9f4dd05d324df8c8.jpg");
        nameDrinks.add("Sekoteng");
        priceDrinks.add("Rp 14.000");
        infoDrinks.add("Sekoteng identik dengan beragam topping seperti kacang hijau, kacang tanah, pacar cina, dan potongan roti tawar.Tunggu apa lagi? ayo langsung pesan minuman ini ");

        imageDrinks.add("https://cdn.idntimes.com/content-images/community/2021/02/fromandroid-c178250a2e65c21b454206f0310aa9a0.jpg");
        nameDrinks.add("Wedang Uwuh");
        priceDrinks.add("Rp 12.000");
        infoDrinks.add("Minuman ini terbuat dari daun organik dan bahan rempah lain. Berkat nama unik inilah minuman menghangatkan ini mampu dikenal luas oleh masyarakat Indonesia.Tunggu apa lagi? ayo langsung pesan minuman ini ");

        imageDrinks.add("https://cdn.idntimes.com/content-images/community/2021/02/fromandroid-5c30f0f2073b325173c68b6b2c5ac251.jpg");
        nameDrinks.add("Wedang Ronde");
        priceDrinks.add("Rp 15.000");
        infoDrinks.add("Minuman tradisional khas Indonesia ini memang memiliki ciri khas disajikan adanya bola-bola yang terbuat dari tepung ketan dilengkapi dengan topping lain seperti kolang-kaling, kacang tanah, dan potongan roti tawar.Tunggu apa lagi? ayo langsung pesan minuman ini ");

        imageDrinks.add("https://cdn.idntimes.com/content-images/community/2021/02/fromandroid-7f37e2c3de26ac0f65fbed40e3375d1d.jpg");
        nameDrinks.add("Wedang Secang");
        priceDrinks.add("Rp 12.000");
        infoDrinks.add("Sesuai namanya, minuman khas Jogja ini terbuat dari kayu secang. Bahan rempah inilah yang menjadi ciri khas wedang secang memiliki warna merah khas.Tunggu apa lagi? ayo langsung pesan minuman ini ");

        imageDrinks.add("https://cdn.idntimes.com/content-images/community/2021/02/fromandroid-2b0bd56a09adf591b988ce48a0e2ad2b.jpg");
        nameDrinks.add("Sarabba");
        priceDrinks.add("Rp 8.000");
        infoDrinks.add("Salah satu ciri khas sarabba asal Makassar ialah adanya tambahan kuning telur mentah ditambah bahan-bahan rempah. Bahan-bahan inilah di klaim mampu mencegah berbagai penyakit seperti flu dan masuk angin.Tunggu apa lagi? ayo langsung pesan minuman ini ");

        imageDrinks.add("https://cdn.idntimes.com/content-images/community/2021/02/fromandroid-4d67a9f2dcae6fa99c962d5b9f64fd76.jpg");
        nameDrinks.add("Air Guraka");
        priceDrinks.add("Rp 9.000");
        infoDrinks.add("Air guraka menjadi minuman tradisional khas Maluku yang memiliki bahan dasar dari biji kenari. Selain kenari, ada tambahan bahan lain seperti jahe merah, gula aren, dan juga daun pandan.Tunggu apa lagi? ayo langsung pesan minuman ini ");

        imageDrinks.add("https://cdn.idntimes.com/content-images/community/2021/02/fromandroid-f6a9068e9ad2afeed72072a08250db7b.jpg");
        nameDrinks.add("Teh Talua");
        priceDrinks.add("Rp 7.000");
        infoDrinks.add("Sesuai namanya, teh talua terbuat dari teh yang diolah bersama telur, gula, dan perasan jeruk nipis. Disajikan dalam keadaan hangat, teh talua sangat pas diseruput untuk kamu yang lelah seharian beraktivitas.Tunggu apa lagi? ayo langsung pesan minuman ini ");

        imageDrinks.add("https://cdn.idntimes.com/content-images/community/2021/02/fromandroid-e586b8e61ede7f41962cbf9329ad7f1a.jpg");
        nameDrinks.add("Es Selendang Mayang");
        priceDrinks.add("Rp 13.000");
        infoDrinks.add("Minuman ini disajikan dengan campuran santan, sirup, dan susu. Sebagai pelengkapnya, es selendang mayang seringkali diberi topping pelengkap irisan buah nangka. Cita rasanya yang manis gurih, sangat pas dijadikan sebagai hidangan penutup.Tunggu apa lagi? ayo langsung pesan minuman ini ");

        imageDrinks.add("https://cdn.idntimes.com/content-images/community/2021/02/fromandroid-e82f8c3c5b18b8688ff4b3201da5ec22.jpg");
        nameDrinks.add("Es Doger");
        priceDrinks.add("Rp 16.000");
        infoDrinks.add("Es doger disajikan dengan beragam topping yang melimpah seperti es serut, tape, ketan hitam, cincau, susu, pacar cina, dan sirup berwarna kemerahan.Tunggu apa lagi? ayo langsung pesan minuman ini ");


        processRecyclerViewAdapter();
    }
}