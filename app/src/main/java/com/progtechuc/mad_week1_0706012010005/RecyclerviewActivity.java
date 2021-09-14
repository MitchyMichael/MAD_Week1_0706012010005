package com.progtechuc.mad_week1_0706012010005;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import model.User;

public class RecyclerviewActivity extends AppCompatActivity {

    private RecyclerView recyclerView_recyclerView;
    private ArrayList<User> dataUser;
    private UserRVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        initView();
        setupRecyclerView();
        addDummyData();

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
        recyclerView_recyclerView = findViewById(R.id.recyclerView_recyclerView);
        dataUser = new ArrayList<User>();
        adapter = new UserRVAdapter(dataUser);

    }
}