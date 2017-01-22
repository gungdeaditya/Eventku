package com.gdeaditya.eventku.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gungde on 15/01/17.
 */

public class ResponseLogin implements Parcelable {

    @SerializedName("nama")
    String nama;
    @SerializedName("status")
    String status;

    protected ResponseLogin(Parcel in) {
        nama = in.readString();
        status = in.readString();
    }

    public static final Creator<ResponseLogin> CREATOR = new Creator<ResponseLogin>() {
        @Override
        public ResponseLogin createFromParcel(Parcel in) {
            return new ResponseLogin(in);
        }

        @Override
        public ResponseLogin[] newArray(int size) {
            return new ResponseLogin[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeString(status);
    }
}
