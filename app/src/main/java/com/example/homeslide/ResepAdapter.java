package com.example.homeslide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ResepAdapter extends RecyclerView.Adapter<ResepAdapter.ProductViewHolder>{

    Context mCtx;
    ArrayList<Resep> productList;
    RecyclerView recyclerView;
    OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick (int position);
    }
    public void setOnItemListener(OnItemClickListener listener){
        mListener = listener;
    }

    public ResepAdapter(Context mCtx, ArrayList<Resep> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }


    @Override
    public ResepAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from (mCtx);
        View view1 = inflater.inflate (R.layout.resep_kue, null);
        recyclerView = view1.findViewById (R.id.recyclerView);
        return new ResepAdapter.ProductViewHolder (LayoutInflater.from(mCtx).inflate(R.layout.layout_resep_kue,parent,false));
    }

    @Override
    public void onBindViewHolder(ResepAdapter.ProductViewHolder holder, int position) {
        Resep product = productList.get(position);

        holder.textViewTitle.setText(product.getNama());
        holder.textViewAsal.setText(product.getAsal());
        holder.textViewDesc.setText(product.getDeskripsi());

        Picasso.get().load(productList.get(position).getGambar()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
    class ProductViewHolder extends RecyclerView.ViewHolder {
        LayoutInflater inflater = LayoutInflater.from (mCtx);
        View view = inflater.inflate (R.layout.layout_resep_kue, null);
        TextView textViewTitle, textViewDesc, textViewAsal;
        ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDesc = itemView.findViewById(R.id.textViewDesc);
            textViewAsal = itemView.findViewById(R.id.textViewAsal);

            imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mListener!=null){
                        int itemPosition = recyclerView.getChildLayoutPosition (view);
                        String judul = productList.get(itemPosition).getNama();
                        String kota = productList.get(itemPosition).getAsal();
                        String deskripsi = productList.get(itemPosition).getDeskripsi();
                        String bahan = productList.get(itemPosition).getBahan();
                        String intruksi = productList.get(itemPosition).getIntruksi();
                        String gambar = productList.get(itemPosition).getGambar();

                        Intent intent = new Intent (mCtx, ResepActivity_1.class);
                        Bundle extras = new Bundle();
                        extras.putString("judulkonten",judul);
                        extras.putString("kotakonten",kota);
                        extras.putString("deskripsi",deskripsi);
                        extras.putString("bahan", bahan);
                        extras.putString("intruksi",intruksi);
                        extras.putString("gambarkonten", gambar);
                        intent.putExtras(extras);
                        if(itemPosition!=RecyclerView.NO_POSITION){
                            mListener.onItemClick(itemPosition);
                            mCtx.startActivity (intent);
                            View view1 = inflater.inflate (R.layout.resep_kue, null);
                            recyclerView = view1.findViewById (R.id.recyclerView);
                        }
                    }
                }
            });
        }
    }
}