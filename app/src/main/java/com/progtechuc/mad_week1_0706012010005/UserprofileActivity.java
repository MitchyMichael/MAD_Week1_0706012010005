package com.progtechuc.mad_week1_0706012010005;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class UserprofileActivity extends AppCompatActivity {

    private TextView userDetail_nama;
    private TextInputLayout userDetail_umur, userDetail_kota;
    private FloatingActionButton FAB_delete, FAB_edit;
    private Toolbar toolbar_UserDetail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

        initView();
        inputUser();
        toolbarBackButton();
        deleteButton();
    }

    private void deleteButton() {
        FAB_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                int position = intent1.getIntExtra("position", -1);

                Intent intent = new Intent();
                intent.putExtra("position", position);

                setResult(10, intent);
                finish();
            }
        });
    }


    private void toolbarBackButton() {
        toolbar_UserDetail.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                finish();
            }
        });
    }

    private void inputUser() {
        Intent intent = getIntent();
        userDetail_nama.setText(intent.getStringExtra("nama"));
        userDetail_kota.setHint(intent.getStringExtra("kota"));
        userDetail_umur.setHint(intent.getStringExtra("umur"));

    }

    private void initView() {
        userDetail_nama = findViewById(R.id.userDetail_nama);
        userDetail_umur = findViewById(R.id.userDetail_umur);
        userDetail_kota = findViewById(R.id.userDetail_kota);
        FAB_delete = findViewById(R.id.FAB_delete);
        FAB_edit = findViewById(R.id.FAB_edit);
        toolbar_UserDetail = findViewById(R.id.toolbar_UserDetail);



    }
}