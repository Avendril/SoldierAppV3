package com.example.nexer.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import static android.support.v4.content.ContextCompat.startActivity;


public class BackgroundWorkerInsert extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    BackgroundWorkerInsert (Context ctx) {
        context = ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String insert_url = "http://10.0.2.2/insert.php"; //If not working, use the ip that DNS gave you ipconfig

        if(type.equals("insert")){
            try {
                String name = params[1];
                String surname = params[2];
                String email = params[3];
                String phoneNo = params[4];
                String address1 = params[5];
                String address2 = params[6];
                String rank = params[7];
                String username = params[8];
                String password = params[9];

                URL url = new URL(insert_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST"); //Type of data that PHP files (conn.php and Login.php) has to use
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"
                        +URLEncoder.encode("surname","UTF-8")+"="+URLEncoder.encode(surname,"UTF-8")+"&"
                        +URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"
                        +URLEncoder.encode("phoneNo","UTF-8")+"="+URLEncoder.encode(phoneNo,"UTF-8")+"&"
                        +URLEncoder.encode("address1","UTF-8")+"="+URLEncoder.encode(address1,"UTF-8")+"&"
                        +URLEncoder.encode("address2","UTF-8")+"="+URLEncoder.encode(address2,"UTF-8")+"&"
                        +URLEncoder.encode("militaryRank","UTF-8")+"="+URLEncoder.encode(rank,"UTF-8")+"&"
                        +URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8"); //using the username and password above to check for inside the db

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();//Flushing the buffer so it doesn't use so much memory and closing it afterwards just to save some memory
                InputStream inputStream = httpURLConnection.getInputStream();//open another inputstream
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";

                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();//Close both buffer and reader, not flushing since this might be needed later
                httpURLConnection.disconnect();//Disconnecting from  the database after the login is finished!

                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        if(result.contains("New record created successfully")) {//Checking if the insert was a success (insert.php)
            Toast.makeText(context, "Data insertion successful!", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show();
        }
        alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}