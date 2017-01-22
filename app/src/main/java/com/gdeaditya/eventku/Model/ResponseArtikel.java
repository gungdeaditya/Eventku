package com.gdeaditya.eventku.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit.client.Response;

/**
 * Created by gungde on 22/01/17.
 */

public class ResponseArtikel  implements Parcelable{

    @SerializedName("id_event")
    String id_event;
    @SerializedName("tanggal")
    String tanggal;
    @SerializedName("judul")
    String judul;
    @SerializedName("lokasi")
    String lokasi;
    @SerializedName("kategori")
    String kategori;
    @SerializedName("gambar")
    String gambar;

    protected ResponseArtikel(Parcel in) {
        id_event = in.readString();
        tanggal = in.readString();
        judul = in.readString();
        lokasi = in.readString();
        kategori = in.readString();
        gambar = in.readString();
    }

    public static final Creator<ResponseArtikel> CREATOR = new Creator<ResponseArtikel>() {
        @Override
        public ResponseArtikel createFromParcel(Parcel in) {
            return new ResponseArtikel(in);
        }

        @Override
        public ResponseArtikel[] newArray(int size) {
            return new ResponseArtikel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id_event);
        parcel.writeString(tanggal);
        parcel.writeString(judul);
        parcel.writeString(lokasi);
        parcel.writeString(kategori);
        parcel.writeString(gambar);
    }

    public String getId_event() {
        return id_event;
    }

    public void setId_event(String id_event) {
        this.id_event = id_event;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public static class ResponseArtikelResult{
        List<ResponseArtikel> data;
        public List<ResponseArtikel> getResult(){
            return data;
        }
    }
}
