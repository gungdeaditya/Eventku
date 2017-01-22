package com.gdeaditya.eventku.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gungde on 15/01/17.
 */

public class ResponseSignup implements Parcelable {

    @SerializedName("status")
    String status;

    protected ResponseSignup(Parcel in) {
        status = in.readString();
    }

    public static final Creator<ResponseSignup> CREATOR = new Creator<ResponseSignup>() {
        @Override
        public ResponseSignup createFromParcel(Parcel in) {
            return new ResponseSignup(in);
        }

        @Override
        public ResponseSignup[] newArray(int size) {
            return new ResponseSignup[size];
        }
    };

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
        parcel.writeString(status);
    }
}
