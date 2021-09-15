package com.progtechuc.mad_week1_0706012010005;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputLayout;

import model.User;

public class InputUserActivity extends AppCompatActivity {

    private TextInputLayout inputNama, inputUmur, inputKota;
    private Button inputUser_saveButton;
    private Toolbar toolbar_userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_user);
        initView();
        setListener();
        toolbarBackButton();
    }

    private void toolbarBackButton() {
        toolbar_userInput.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                finish();
            }
        });
    }

    private void setListener() {
        inputUser_saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = inputNama.getEditText().getText().toString().trim();
                String kota = inputKota.getEditText().getText().toString().trim();
                int umur = Integer.parseInt(inputUmur.getEditText().getText().toString().trim());
                User temp = new User(nama, kota, umur);

                Intent intent = new Intent();
                intent.putExtra("userBaru", temp);
                setResult(2, intent);
                finish();
            }
        });
    }

    private void initView() {
        inputNama = findViewById(R.id.inputNama);
        inputUmur = findViewById(R.id.inputUmur);
        inputKota = findViewById(R.id.inputKota);
        inputUser_saveButton = findViewById(R.id.inputUser_saveButton);
        toolbar_userInput = findViewById(R.id.toolbar_userInput);


    }
}