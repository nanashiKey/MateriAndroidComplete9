package com.sampledev.project.materiandroidcomplete9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.sampledev.project.materiandroidcomplete9.helpers.APIServices;
import com.sampledev.project.materiandroidcomplete9.helpers.Const;
import com.sampledev.project.materiandroidcomplete9.responsemodel.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    TextInputEditText etUsername, etEmail, etPaswword, etRePass;
    Button btnRegister;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPaswword = findViewById(R.id.etPassword);
        etRePass = findViewById(R.id.etRePass);
        btnRegister = findViewById(R.id.btnRegister);
        progressBar = findViewById(R.id.progressBar);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                executeRegister();
            }
        });
    }

    private void executeRegister(){
        String uname = etUsername.getText().toString();
        String email = etEmail.getText().toString();
        String pass = etPaswword.getText().toString();
        String rePass = etRePass.getText().toString();
        if(uname.equals("") || email.equals("") || pass.equals("") || rePass.equals("")){
            Toast.makeText(this, "silahkan isi setiap kolom kosong", Toast.LENGTH_SHORT).show();
        }else{
            if(pass.equals(rePass)){
                executeRetrofit(uname, pass, email);
                progressBar.setVisibility(View.VISIBLE);
            }else{
                Toast.makeText(this, "password tidak sesuai", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void executeRetrofit(String name, String pass, String email){
        Retrofit retro = new Retrofit.Builder()
                .baseUrl(Const.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIServices apidata = retro.create(APIServices.class);
        apidata.userRegister(name, email, pass, 0)
                .enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                        if(response.isSuccessful()){
                            RegisterResponse resData = response.body();
                            Toast.makeText(RegisterActivity.this, resData.message, Toast.LENGTH_SHORT).show();
                            finish();
                        }else{
                            Toast.makeText(RegisterActivity.this, "Register Gagal", Toast.LENGTH_SHORT).show();
                        }
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(RegisterActivity.this, t.getLocalizedMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });

    }
}