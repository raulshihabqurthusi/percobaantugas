package com.hacktiv8.percobaantugas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText komentarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        komentarText = findViewById(R.id.komentar_text);
    }

    @Override
    protected void onStart() {
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT);
        super.onStart();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT);
        saveDataKomentar(komentarText.getText().toString());
        super.onStop();
    }

    @Override
    protected void onPause() {
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT);
        super.onPause();
    }

    @Override
    protected void onResume() {
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT);
        String datakomentar = ambilDatakomentar();
        komentarText.setText(datakomentar);
        super.onResume();
    }
    private void saveDataKomentar(String value){
        SharedPreferences.Editor editor= this.getSharedPreferences("komentar", Context.MODE_PRIVATE).edit();
        editor.putString("keyKomentar", value);
        editor.commit();
    }
    private String ambilDatakomentar(){
        String result = this.getSharedPreferences("komentar", Context.MODE_PRIVATE).getString("keyKomentar", null);
        return result;
    }
}