package com.example.nexer.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RemoveIDActivity extends AppCompatActivity {

    EditText ID;
    String str_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_id);

        ID = (EditText)findViewById(R.id.deleteID);
    }

    public void OnDelete(View view){
        str_ID = ID.getText().toString();

        String type = "deletebyID";
        BackgroundWorker backgroundWorkerDelete = new BackgroundWorker(this);
        backgroundWorkerDelete.execute(type, str_ID);
    }
}
