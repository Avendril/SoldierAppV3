package com.example.nexer.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RemoveActivity extends AppCompatActivity {

    EditText name, surname;
    String str_name, str_surname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        name = (EditText)findViewById(R.id.insertName);
        surname = (EditText)findViewById(R.id.insertSurname);
    }

    public void OnDelete(View view){
        str_name = name.getText().toString();
        str_surname = surname.getText().toString();

        String type = "delete";
        BackgroundWorkerDeleteByName backgroundWorkerDeleteByName = new BackgroundWorkerDeleteByName(this);
        backgroundWorkerDeleteByName.execute(type, str_name, str_surname);
    }
}
