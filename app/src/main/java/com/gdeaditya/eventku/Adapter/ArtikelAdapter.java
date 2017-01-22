package com.gdeaditya.eventku.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gdeaditya.eventku.Model.ResponseArtikel;
import com.gdeaditya.eventku.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gungde on 22/01/17.
 */

public class ArtikelAdapter extends RecyclerView.Adapter<ArtikelAdapter.ArtikelViewHolder> {

    ArrayList<ResponseArtikel> list = new ArrayList<ResponseArtikel>();
    Context context;

    public ArtikelAdapter(ArrayList<ResponseArtikel> list, Context context){
        this.list = list;
        this.context = context;
    }


    @Override
    public ArtikelAdapter.ArtikelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_layout,parent);
        ArtikelViewHolder artikelViewHolder = new ArtikelViewHolder(view);
        return artikelViewHolder;
    }

    @Override
    public void onBindViewHolder(ArtikelAdapter.ArtikelViewHolder holder, int position) {
        holder.txJudul.setText(list.get(position).getJudul());
        holder.txTanggal.setText(list.get(position).getTanggal());
        holder.txKategori.setText(list.get(position).getKategori());
        holder.txLokasi.setText(list.get(position).getLokasi());
        Glide.with(context).load(list.get(position).getGambar()).into(holder.imgGambar);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ArtikelViewHolder extends RecyclerView.ViewHolder{

        TextView txTanggal, txJudul, txKategori, txLokasi;
        ImageView imgGambar;

        public ArtikelViewHolder(View itemView) {
            super(itemView);

            txTanggal = (TextView)itemView.findViewById(R.id.txTanggal);
            txJudul = (TextView)itemView.findViewById(R.id.txJudul);
            txKategori = (TextView)itemView.findViewById(R.id.txKategori);
            txLokasi = (TextView)itemView.findViewById(R.id.txLokasi);
            imgGambar = (ImageView) itemView.findViewById(R.id.imgGambar);
        }
    }

    public void setList(List<ResponseArtikel> artikelList){
        this.list = new ArrayList<>();
        this.list.addAll(artikelList);
        notifyDataSetChanged();
    }
}
