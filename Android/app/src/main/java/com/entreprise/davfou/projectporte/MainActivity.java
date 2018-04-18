package com.entreprise.davfou.projectporte;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.entreprise.davfou.projectporte.service.ApiService;
import com.entreprise.davfou.projectporte.service.RestClient;
import com.entreprise.davfou.projectporte.utilsRecyclerView.AdapterDataDoor;
import com.entreprise.davfou.projectporte.utilsRecyclerView.DataDoor;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    @BindView(R.id.recyclerViewDataDoors)
    RecyclerView recyclerViewDataDoors;
    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        ApiService githubService = new RestClient().createService(ApiService.class);

        Call<ArrayList<DataDoor>> call = githubService.listDataDoor();

        call.enqueue(new Callback<ArrayList<DataDoor>>() {
            @Override
            public void onResponse(Call<ArrayList<DataDoor>> call, Response<ArrayList<DataDoor>> response) {
                recyclerViewDataDoors.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerViewDataDoors.setAdapter(new AdapterDataDoor(response.body(), getApplicationContext()));
            }

            @Override
            public void onFailure(Call<ArrayList<DataDoor>> call, Throwable t) {

            }
        });


    }


    @Override
    protected void onResume() {
        ApiService githubService = new RestClient().createService(ApiService.class);

        Call<ArrayList<DataDoor>> call = githubService.listDataDoor();

        call.enqueue(new Callback<ArrayList<DataDoor>>() {
            @Override
            public void onResponse(Call<ArrayList<DataDoor>> call, Response<ArrayList<DataDoor>> response) {
                recyclerViewDataDoors.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerViewDataDoors.setAdapter(new AdapterDataDoor(response.body(), getApplicationContext()));
            }

            @Override
            public void onFailure(Call<ArrayList<DataDoor>> call, Throwable t) {

            }
        });
        super.onResume();
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        ApiService githubService = new RestClient().createService(ApiService.class);

        Call<ArrayList<DataDoor>> call = githubService.listDataDoor();

        call.enqueue(new Callback<ArrayList<DataDoor>>() {
            @Override
            public void onResponse(Call<ArrayList<DataDoor>> call, Response<ArrayList<DataDoor>> response) {
                recyclerViewDataDoors.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerViewDataDoors.setAdapter(new AdapterDataDoor(response.body(), getApplicationContext()));
            }

            @Override
            public void onFailure(Call<ArrayList<DataDoor>> call, Throwable t) {

            }
        });

    }
}
