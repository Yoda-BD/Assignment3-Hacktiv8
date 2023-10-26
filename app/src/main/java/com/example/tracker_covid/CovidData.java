package com.example.tracker_covid;

public class CovidData {
    private int cases;
    private int deaths;
    private int recovered;


}

public interface CovidApi {
    @GET("https://documenter.getpostman.com/view/8854915/SzS7R6uu?version=latest")
    Call<CovidData> getCovidData();
}

