package com.gdeaditya.eventku.API;

import com.gdeaditya.eventku.Model.ResponseLogin;
import com.gdeaditya.eventku.Model.ResponseSignup;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by gungde on 15/01/17.
 */

public interface APIService {

    @FormUrlEncoded
    @POST("/login")
    void postLogin(@Field("email") String email,
                   @Field("pass") String password,
                   Callback<ResponseLogin> callback
    );

    @FormUrlEncoded
    @POST("/signup")
    void postSignup(@Field("email") String email,
                   @Field("pass") String password,
                    @Field("nama") String nama,
                    @Field("phone") String phone,
                   Callback<ResponseSignup> callback
    );
}
