package com.elapp.intentexample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnPindahActivity;
    private Button btnTelpon;

    private EditText edtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPindahActivity = findViewById(R.id.btn_pindah_activity);
        btnTelpon = findViewById(R.id.btn_telpon);

        edtUsername = findViewById(R.id.edt_username);
        btnPindahActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString();
                if (username.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Isi username anda", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                }
            }
        }
        );

        btnTelpon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*String phoneNumber = "082264449406";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(dialPhoneIntent);*/
                Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }

    private void openWhatsApp(String number, String message) {
        Uri waUrl = Uri.parse("https://wa.me//"+number+"?text="+message+"");
        Intent waIntent = new Intent(Intent.ACTION_VIEW, waUrl);
        waIntent.setPackage("com.whatsapp");

        startActivity(waIntent);

    }

}