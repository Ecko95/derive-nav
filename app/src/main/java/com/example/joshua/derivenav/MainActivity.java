package com.example.joshua.derivenav;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton tabClassic;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabClassic = findViewById(R.id.tabClassic);
        tabClassic.setOnClickListener(this);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null && data.getExtras() != null)
            for (String key : data.getExtras().keySet())
                Toast.makeText(this, key + " : " + data.getExtras().get(key).toString(), Toast.LENGTH_SHORT).show();

        super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public void onClick(View view) {
        Intent intent = null;

        if (view == tabClassic){
            intent = new Intent(this, TabClassic.class);
        }

        startActivityForResult(intent, 1);
    }
}
