package com.example.trabalhodepam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class faleconosco extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faleconosco);
    }
    public void btninsta(View view){
        Uri uri = Uri.parse("https://instagram.com/tea.trobrasil?igshid=wdai3gnphms2");
        Intent it = new
    Intent(Intent.ACTION_VIEW,uri);
        startActivity(it);
    }
}