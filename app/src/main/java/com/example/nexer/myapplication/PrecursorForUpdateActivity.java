package com.example.nexer.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PrecursorForUpdateActivity extends AppCompatActivity {

    EditText ID;
    String str_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precursor_for_update);

        ID = (EditText)findViewById(R.id.iddisplay);
    }

    public void OnSearch(View view) {
        str_ID = ID.getText().toString();
        String type = "search";

        if(str_ID != null && str_ID != " "){
            BackgroundWorker backgroundWorkersearch = new BackgroundWorker(this);
            backgroundWorkersearch.execute(type, str_ID);

            Intent i = new Intent(getApplicationContext(), UpdateActivity.class);
            i.putExtra("IDValue", str_ID);
            startActivity(i);
        }else{

        }

    }

}
