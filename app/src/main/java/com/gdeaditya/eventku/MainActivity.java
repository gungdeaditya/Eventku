package com.gdeaditya.eventku;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gdeaditya.eventku.API.APIService;
import com.gdeaditya.eventku.Adapter.ArtikelAdapter;
import com.gdeaditya.eventku.Model.ResponseArtikel;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArtikelAdapter artikelAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ResponseArtikel> list = new ArrayList<ResponseArtikel>();

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = getSharedPreferences("MYDATA",MODE_PRIVATE);
        editor = pref.edit();

        recyclerView = (RecyclerView)findViewById(R.id.rv);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        artikelAdapter = new ArtikelAdapter(list,MainActivity.this);
        recyclerView.setAdapter(artikelAdapter);

        ambilData();
    }

    public void ambilData(){
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://codeandroid24jam.hol.es/latihanapiserver")
                .build();
        APIService api = restAdapter.create(APIService.class);
        api.getArtikel(new Callback<ResponseArtikel.ResponseArtikelResult>() {
            @Override
            public void success(ResponseArtikel.ResponseArtikelResult responseArtikelResult, Response response) {
                artikelAdapter.setList(responseArtikelResult.getResult());
                artikelAdapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }

//    public void ubah1(View view){
////        gambar.setImageResource(R.drawable.bg_event);
////        tanggal.setText(getResources().getString(R.string.tanggal_1));
////        judul.setText(getResources().getString(R.string.judul_1));
////        lokasi.setText(getResources().getString(R.string.lokasi_1));
////        kategori.setText(getResources().getString(R.string.kategori_1));
//        merubahTampilan(R.drawable.bg_event,
//                getResources().getString(R.string.tanggal_1),
//                getResources().getString(R.string.judul_1),
//                getResources().getString(R.string.lokasi_1),
//                getResources().getString(R.string.kategori_1));
//    }
//    public void ubah2(View view){
//        merubahTampilan(R.drawable.bg_event2,
//                getResources().getString(R.string.tanggal_2),
//                getResources().getString(R.string.judul_2),
//                getResources().getString(R.string.lokasi_2),
//                getResources().getString(R.string.kategori_2));
//    }
//    public void ubah3(View view){
//        merubahTampilan(R.drawable.bg_event3,
//                getResources().getString(R.string.tanggal_3),
//                getResources().getString(R.string.judul_3),
//                getResources().getString(R.string.lokasi_3),
//                getResources().getString(R.string.kategori_3));
//    }
//
//    public void merubahTampilan(int gmbr,String tgl,String jdl, String lok,String kat){
//        gambar.setImageResource(gmbr);
//        tanggal.setText(tgl);
//        judul.setText(jdl);
//        lokasi.setText(lok);
//        kategori.setText(kat);
//    }
//
//    public void Logout(View view){
//        editor.clear();
//        editor.commit();
//        Intent i = new Intent(this,LoginActivity.class);
//        startActivity(i);
//        finish();
//    }

}

