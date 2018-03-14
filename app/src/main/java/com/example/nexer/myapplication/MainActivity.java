package com.example.nexer.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/*References:
    Youtube Channels: https://www.youtube.com/channel/UCs6nmQViDpUw0nuIx9c_WvA <- He has everything! Like literally, everything
    Websites: Stackoverflow
              https://developer.android.com/guide/topics/ui/notifiers/toasts.html
              github.com
              https://romannurik.github.io/AndroidAssetStudio/
    People: Jayme Doran <- Helped me with Navigation
            Kuba Kulik <- Helped me with Sql syntax
 */

public class MainActivity extends AppCompatActivity  {
    EditText UsernameEt, PasswordEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsernameEt = (EditText)findViewById(R.id.LoginField);
        PasswordEt = (EditText)findViewById(R.id.PasswordField);
    }

    public void OnLogin(View view) {
        String username = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();
        String type = "login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password);
    }

}