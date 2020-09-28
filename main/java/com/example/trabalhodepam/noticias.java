package com.example.trabalhodepam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class noticias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

}

    public void abrirnot (View view){
        Uri uri = Uri.parse("https://veja.abril.com.br/noticias-sobre/teatro/");
        Intent it = new
                Intent(Intent.ACTION_VIEW,uri);
        startActivity(it);
    }
}
