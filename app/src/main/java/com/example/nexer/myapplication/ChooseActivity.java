package com.example.nexer.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
    }

    public void OnDeleteByName(View view){
        Intent myIntent = new Intent(ChooseActivity.this,
                RemoveActivity.class);
        startActivity(myIntent);
    }

    public void OnDeleteByID(View view){
        Intent myIntent = new Intent(ChooseActivity.this,
                ChooseActivity.class);
        startActivity(myIntent);
    }
}
