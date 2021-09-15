package com.progtechuc.mad_week1_0706012010005;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import model.User;

public class RecyclerviewActivity extends AppCompatActivity implements OnCardClickListener{

    private RecyclerView recyclerView_recyclerView;
    private ArrayList<User> dataUser;
    private UserRVAdapter adapter;
    private FloatingActionButton recyclerView_FAB;
    private TextView noData;
    private ActivityResultLauncher<Intent> activityResultLauncher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        initView();
        noDataView();
        setupRecyclerView();
        //addDummyData();
        setCallback();
        setListener();

    }

    private void setCallback() {
        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == 20) {
                            int position = result.getData().getIntExtra("position", -1);

                            User user = result.getData().getParcelableExtra("user");
                            dataUser.set(position, user);
                            adapter.notifyDataSetChanged();
                        } else if (result.getResultCode() == 10) {
                            int position = result.getData().getIntExtra("position", -1);

                            dataUser.remove(position);
                            adapter.notifyDataSetChanged();
                            noDataView();
                        } else if (result.getResultCode() == 2){
                            User userBaru = result.getData().getParcelableExtra("userBaru");
                            dataUser.add(userBaru);
                            adapter.notifyDataSetChanged();
                            noDataView();
                        }
                    }
                });
    }

    private void noDataView() {
        if (dataUser.isEmpty()){
            recyclerView_recyclerView.setVisibility(View.GONE);
            noData.setVisibility(View.VISIBLE);
        }else{
            recyclerView_recyclerView.setVisibility(View.VISIBLE);
            noData.setVisibility(View.GONE);
        }
    }

    private void setListener() {
        recyclerView_FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), InputUserActivity.class);
                intent.putExtra("action", "add");

                activityResultLauncher.launch(intent);

            }
        });
    }

    private void addDummyData() {
        dataUser.add(new User("Michael", "Surakarta", 19));
        dataUser.add(new User("Daniel", "Surabaya", 19));
        dataUser.add(new User("Bryan", "Surabaya", 19));
        dataUser.add(new User("Bryan", "Surabaya", 19));
        dataUser.add(new User("Bryan", "Surabaya", 19));
        adapter.notifyDataSetChanged();
    }

    private void setupRecyclerView() {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getBaseContext());
        recyclerView_recyclerView.setLayoutManager(manager);
        recyclerView_recyclerView.setAdapter(adapter);
    }

    private void initView() {
        noData = findViewById(R.id.noData);
        recyclerView_recyclerView = findViewById(R.id.recyclerView_recyclerView);
        dataUser = new ArrayList<User>();
        adapter = new UserRVAdapter(dataUser, this);
        recyclerView_FAB = findViewById(R.id.recyclerView_FAB);

    }

    @Override
    public void OnClick(int position) {
        User user = dataUser.get(position);

        Intent intent = new Intent(getBaseContext(), UserprofileActivity.class);
        intent.putExtra("nama", user.getNama().toString().trim());
        intent.putExtra("umur", String.valueOf(user.getUmur()));
        intent.putExtra("kota", user.getKota().toString().trim());
        intent.putExtra("position", position);
        activityResultLauncher.launch(intent);
    }
}