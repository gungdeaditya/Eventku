package com.gdeaditya.eventku;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.gdeaditya.eventku.API.APIService;
import com.gdeaditya.eventku.Model.ResponseLogin;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    ProgressDialog pDialog;

    String KEEPLOGIN = "KEEPLOGIN";
    String NAMA = "NAMA";
    String MYDATA = "MYDATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pref = getSharedPreferences(MYDATA,MODE_PRIVATE);
        editor = pref.edit();
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Mohon Tunggu");
        pDialog.setCancelable(true);

        if(pref.getBoolean(KEEPLOGIN,false)){
            Intent i = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(i);
            finish();
        }else{
            // do nothing
        }

        email = (EditText)findViewById(R.id.edtEmail);
        password = (EditText)findViewById(R.id.edtPassword);
    }

    public void login(View view){
        loginRetrofit();
    }

    public void signup(View view) {
        Intent i = new Intent(this,SignupActivity.class);
        startActivity(i);
    }

    private void loginRetrofit(){
        pDialog.show();
        String email_value = email.getText().toString();
        String pass_value = password.getText().toString();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://codeandroid24jam.hol.es/latihanapiserver")
                .build();

        APIService api = restAdapter.create(APIService.class);
        api.postLogin(email_value, pass_value, new Callback<ResponseLogin>() {
            @Override
            public void success(ResponseLogin responseLogin, Response response) {
                pDialog.dismiss();
                if(responseLogin.getStatus().equals("1")){
                    editor.putString(NAMA,responseLogin.getNama());
                    editor.putBoolean(KEEPLOGIN, true);
                    editor.commit();

                    Intent i = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "Email atau Password Salah!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                pDialog.dismiss();
            }
        });

    }

}
