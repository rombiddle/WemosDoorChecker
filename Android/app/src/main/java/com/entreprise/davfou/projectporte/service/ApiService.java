package com.entreprise.davfou.projectporte.service;

import com.entreprise.davfou.projectporte.utilsRecyclerView.DataDoor;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    String ENDPOINT = "http://vps455628.ovh.net/";

    @GET("wemos")
    Call<ArrayList<DataDoor>> listDataDoor();
}
