package com.progtechuc.mad_week1_0706012010005;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import model.User;

public class UserprofileActivity extends AppCompatActivity {

    private TextView userDetail_nama;
    private TextInputLayout userDetail_umur, userDetail_kota;
    private FloatingActionButton FAB_delete, FAB_edit;
    private Toolbar toolbar_UserDetail;
    private ActivityResultLauncher<Intent> activityResultLauncher;
    private int position;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

        initView();
        inputUser();
        toolbarBackButton();
        setCallback();
        deleteButton();
        editButton();

    }

    private void setCallback() {
        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == 50) {
                            Intent intent = result.getData();
                            String nama2 = intent.getStringExtra("nama1");
                            String kota2 = intent.getStringExtra("kota1");
                            int umur2 = intent.getIntExtra("umur1", -1);

                            userDetail_nama.setText(nama2);
                            userDetail_kota.setHint(kota2);
                            userDetail_umur.setHint(String.valueOf(umur2));

                            Intent intent3 = new Intent();
                            intent3.putExtra("nama1", nama2);
                            intent3.putExtra("kota1", kota2);
                            intent3.putExtra("umur1", umur2);
                            intent3.putExtra("position", position);

                            User temp = new User(nama2, kota2, umur2);

                            intent3.putExtra("user", temp);
                            setResult(20, intent3);
                            finish();

                        }
                    }
                });
    }

    private void editButton() {
        FAB_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputUser();

                Intent intent1 = getIntent();

                String nama1 = intent1.getStringExtra("nama");
                String kota1 = intent1.getStringExtra("kota");
                String umur1 = intent1.getStringExtra("umur");

                Intent intent = new Intent(getBaseContext(), InputUserActivity.class);
                intent.putExtra("nama", nama1);
                intent.putExtra("kota", kota1);
                intent.putExtra("umur", umur1);

                intent.putExtra("action", "edit");

                activityResultLauncher.launch(intent);

            }
        });
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

        Intent intent1 = getIntent();
        position = intent1.getIntExtra("position", -1);



    }
}