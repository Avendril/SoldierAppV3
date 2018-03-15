package com.example.nexer.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {

    EditText name, surname, email, phone, address1, address2, militaryRank, username, password;
    String str_name, str_surname, str_email, str_phone, str_address1, str_address2, str_militaryRank, str_username, str_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        name = (EditText)findViewById(R.id.insertName);
        surname = (EditText)findViewById(R.id.insertSurname);
        email = (EditText)findViewById(R.id.insertEmail);
        phone = (EditText)findViewById(R.id.insertPhoneNo);
        address1 = (EditText)findViewById(R.id.insertAddress1);
        address2 = (EditText)findViewById(R.id.insertAddress2);
        militaryRank = (EditText)findViewById(R.id.insertRank);
        username = (EditText)findViewById(R.id.insertUsername);
        password = (EditText)findViewById(R.id.insertPassword);
    }

    public void OnRegister(View view){
        str_name = name.getText().toString();
        str_surname = surname.getText().toString();
        str_email = email.getText().toString();
        str_phone = phone.getText().toString();
        str_address1 = address1.getText().toString();
        str_address2 = address2.getText().toString();
        str_militaryRank = militaryRank.getText().toString();
        str_username = username.getText().toString();
        str_password = password.getText().toString();

        String type = "insert";
        BackgroundWorker backgroundWorkerInsert = new BackgroundWorker(this);
        backgroundWorkerInsert.execute(type, str_name, str_surname, str_email, str_phone, str_address1, str_address2, str_militaryRank, str_username, str_password);
    }
}
