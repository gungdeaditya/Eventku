package com.gdeaditya.eventku;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pref = getSharedPreferences("MYDATA",MODE_PRIVATE);
        editor = pref.edit();

        if(pref.getBoolean("KEEPLOGIN",false)){
            Intent i = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(i);
            finish();
        }else{
            // do nothing
        }

        username = (EditText)findViewById(R.id.edtUsername);
        password = (EditText)findViewById(R.id.edtPassword);
    }

    public void login(View view){
        if(username.getText().toString().equals("saya") && password.getText().toString().equals("12345")){
            editor.putBoolean("KEEPLOGIN",true);
            editor.commit();
            Intent i = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(i);
            finish();
        }else{
            Toast.makeText(this, "Mohon input yang benar", Toast.LENGTH_SHORT).show();
        }
    }
}
