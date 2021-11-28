package com.example.binusezyfoody;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.lang.reflect.Array;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    // Membuat object arrayList
    private ArrayList<String> imageDrinks = new ArrayList<>();
    private ArrayList<String> nameDrinks = new ArrayList<>();
    private ArrayList<String> priceDrinks = new ArrayList<>();
    private ArrayList<String> infoDrinks = new ArrayList<>();
    private Context context;

    // Membuat Constructor untuk RecyclerViewAdapter
    public RecyclerViewAdapter(ArrayList<String> imageDrinks, ArrayList<String> nameDrinks, ArrayList<String> priceDrinks,
                               ArrayList<String> infoDrinks, Context context) {
        this.imageDrinks = imageDrinks;
        this.nameDrinks = nameDrinks;
        this.priceDrinks = priceDrinks;
        this.infoDrinks = infoDrinks;
        this.context = context;
    }

    // Method Abstract RecyclerViewAdapter
    @NonNull
    @Override
    // Method ketika ViewHolder nya terbentuk
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflatter untuk memasukkan template desain recyclerview ke drinks
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    // Memasukkan data kita ke template recyclerview
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).asBitmap().load(imageDrinks.get(position)).into(holder.imageMinuman);
        holder.namaMinuman.setText(nameDrinks.get(position));
        holder.harga.setText(priceDrinks.get(position));

        // Ketika diklik minumannya, maka akan pindah ke activity order
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Proses intent ke order
                Intent intent = new Intent(context, Order.class);

                //Mengirim data
                intent.putExtra("foto_minuman", imageDrinks.get(position));
                intent.putExtra("nama_minuman", nameDrinks.get(position));
                intent.putExtra("harga_minuman", priceDrinks.get(position));
                intent.putExtra("info_minuman", infoDrinks.get(position));

                context.startActivity(intent);
            }
        });
    }

    // Untuk mendapatkan jumlah dari array
    @Override
    public int getItemCount() {
        return nameDrinks.size();
    }

    // Memanggil ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imageMinuman;
        TextView namaMinuman;
        TextView harga;
        ConstraintLayout constraintLayout;

        // Membuat Constructor untuk View Holder
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageMinuman = itemView.findViewById(R.id.imageMinuman);
            namaMinuman = itemView.findViewById(R.id.namaMinuman);
            harga = itemView.findViewById(R.id.harga);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);
        }
    }

}
