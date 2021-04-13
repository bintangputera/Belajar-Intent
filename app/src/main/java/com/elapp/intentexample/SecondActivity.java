package com.elapp.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView txNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txNama = findViewById(R.id.tx_nama);

        String username = getIntent().getStringExtra("username");
        txNama.setText(username);

    }
}