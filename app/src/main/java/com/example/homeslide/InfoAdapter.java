package com.example.homeslide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.ProductViewHolder> {
    Context mCtx;
    ArrayList<Info> info;
    RecyclerView recyclerView;

    public InfoAdapter(Context mCtx, ArrayList<Info> info) {
        this.mCtx = mCtx;
        this.info = info;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater.from(mCtx).inflate(R.layout.layout_info_kue,parent,false));
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Info product = info.get(position);
        holder.textViewNama.setText(product.getNama());
        holder.textViewAsal.setText(product.getAsal());
        holder.textViewDeskripsi.setText(product.getDeskripsi());
        Picasso.get().load(info.get(position).getGambar()).into(holder.imageView);
    }
    @Override
    public int getItemCount() {
        return info.size();
    }
    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewNama, textViewDeskripsi, textViewAsal;
        ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewNama = itemView.findViewById(R.id.textViewTitle);
            textViewAsal = itemView.findViewById(R.id.textViewAsal);
            textViewDeskripsi = itemView.findViewById(R.id.textViewShortDesc);

            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
