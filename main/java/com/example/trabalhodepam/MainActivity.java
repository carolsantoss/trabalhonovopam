package com.example.trabalhodepam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtteatro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtteatro=(TextView)findViewById(R.id.txtteatro);
    }
        public void clickFale(View view){
            Intent intent1 = new Intent(this, faleconosco.class);
            startActivity(intent1);
        }

        public void clickLogin(View view) {
            Intent intent2 = new Intent(this, login.class);
            startActivity(intent2);
        }

        public void clickCartaz(View view){
            Intent intent3 = new Intent(this, cartaz.class);
            startActivity(intent3);
        }

        public void clickNoticias(View view){
            Intent intent4 = new Intent(this, noticias.class);
            startActivity(intent4);
        }
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        outState.putInt("COR",txtteatro.getCurrentTextColor());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        int color = savedInstanceState.getInt("COR");
        txtteatro.setTextColor(color);

    }

    public void mudarcor (View view){
        TextView txt = (TextView)view;
        if(txt.getCurrentTextColor()!=Color.RED)
        {
            txt.setTextColor(Color.RED);
        }
        else
        {
            txt.setTextColor(Color.BLACK);
        }

    }
}
