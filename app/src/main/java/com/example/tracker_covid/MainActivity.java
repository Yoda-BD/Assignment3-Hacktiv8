package com.example.tracker_covid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://documenter.getpostman.com/view/8854915/SzS7R6uu?version=latest")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    CovidApi covidApi = retrofit.create(CovidApi.class);
    Call<CovidData> call = covidApi.getCovidData();

    call.enqueue(new Callback<CovidData>() {
        @Override
        public void onResponse(Call<CovidData> call, Response<CovidData> response) {
            if (response.isSuccessful()) {
                CovidData data = response.body();
                // Lakukan sesuatu dengan data seperti menampilkan di UI
            } else {
                // Handle kesalahan
            }
        }

        @Override
        public void onFailure(Call<CovidData> call, Throwable t) {
            // Handle kesalahan jaringan
        }
    });
}