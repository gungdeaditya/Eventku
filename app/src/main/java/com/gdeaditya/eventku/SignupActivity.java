package com.gdeaditya.eventku;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gdeaditya.eventku.API.APIService;
import com.gdeaditya.eventku.Model.ResponseSignup;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

public class SignupActivity extends AppCompatActivity {

    EditText edtNama,edtEmail,edtPassword,edtNoTelp;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);

        edtNama = (EditText)findViewById(R.id.edtNama);
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        edtNoTelp = (EditText)findViewById(R.id.edtNoTelp);
    }

    public void signup(View view){
        progressDialog.show();
        signup();
    }

    private void signup() {
        String email = edtEmail.getText().toString();
        String pass = edtPassword.getText().toString();
        String nama = edtNama.getText().toString();
        String notelp = edtNoTelp.getText().toString();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://codeandroid24jam.hol.es/latihanapiserver")
                .build();

        APIService api = restAdapter.create(APIService.class);
        api.postSignup(email, pass, nama, notelp, new Callback<ResponseSignup>() {

                    @Override
                    public void success(ResponseSignup responseSignup, retrofit.client.Response response) {
                        progressDialog.dismiss();
                        if (responseSignup.getStatus().equals("1")) {
                            Toast.makeText(SignupActivity.this, "Success Signup", Toast.LENGTH_SHORT).show();
                            finish();
                        } else if (responseSignup.getStatus().equals("0")) {
                            Toast.makeText(SignupActivity.this, "User already exist", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        progressDialog.dismiss();
                        Log.e("ERROR", error.toString());
                        Toast.makeText(SignupActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
