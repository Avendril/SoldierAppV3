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


public class BackgroundWorker extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    BackgroundWorker (Context ctx) {
        context = ctx;
    }

    boolean data;

    //Intent testintent = new Intent(UpdateActivity.class);
    @Override
    protected String doInBackground(String... params) {

        String type = params[0];
        String login_url = "http://10.0.2.2/login.php"; //If not working, use the ip that DNS gave you ipconfig
        String insert_url = "http://10.0.2.2/insert.php";
        String update_url = "http://10.0.2.2/update.php";
        String delete_url = "http://10.0.2.2/removebyname.php"; //If not working, use the ip that DNS gave you ipconfig
        String deletebyID_url = "http://10.0.2.2/removebyID.php";
        String search_url = "http://10.0.2.2/search.php";
        String retrieve_url = "http://10.0.2.2/retrieve.php";

        if(type.equals("login")) {
            try {
                String username = params[1];
                String password = params[2];

                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST"); //Type of data that PHP files (conn.php and Login.php) has to use
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"
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
        }else if(type.equals("insert")){
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
        }else if(type.equals("update")){
            try {
                String ID = params[1];
                String name = params[2];
                String surname = params[3];
                String email = params[4];
                String phoneNo = params[5];
                String address1 = params[6];
                String address2 = params[7];
                String rank = params[8];
                String username = params[9];
                String password = params[10];

                URL url = new URL(update_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST"); //Type of data that PHP files (conn.php and Login.php) has to use
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("id","UTF-8")+"="+URLEncoder.encode(ID,"UTF-8")+"&"
                        +URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"
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
        }else if(type.equals("deletebyname")){
            try {
                String name = params[1];
                String surname = params[2];

                URL url = new URL(delete_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST"); //Type of data that PHP files (conn.php and Login.php) has to use
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"
                        +URLEncoder.encode("surname","UTF-8")+"="+URLEncoder.encode(surname,"UTF-8"); //using the username and password above to check for inside the db

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
        }else if(type.equals("deletebyID")){
            try {
                String ID = params[1];

                URL url = new URL(deletebyID_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST"); //Type of data that PHP files (conn.php and Login.php) has to use
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("id","UTF-8")+"="+URLEncoder.encode(ID,"UTF-8"); //using the username and password above to check for inside the db

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
        }else if(type.equals("search")){
            try {
                String ID = params[1];

                URL url = new URL(search_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST"); //Type of data that PHP files (conn.php and Login.php) has to use
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("id","UTF-8")+"="+URLEncoder.encode(ID,"UTF-8"); //using the username and password above to check for inside the db

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
        }else if(type.equals("retrieve")){
            try {
                String ID = params[1];

                URL url = new URL(retrieve_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST"); //Type of data that PHP files (conn.php and Login.php) has to use
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("id","UTF-8")+"="+URLEncoder.encode(ID,"UTF-8"); //using the username and password above to check for inside the db

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

    }

    @Override
    protected void onPostExecute(String result) {
    //Login Status if statement!
        if(result.contains("Login Successful, Welcome!")) {//Checking for the login validation (login.php)

            alertDialog.setTitle("Login Status");
            alertDialog.setMessage(result);
            context.startActivity(new Intent(context, NavigationActivity.class)); //moving to navigation activity

        }else if(result.contains("New record created successfully")) {//Insert Status if statement

            Toast.makeText(context, "Data insertion successful! We will move you back to Navigation", Toast.LENGTH_SHORT).show();
            alertDialog.setTitle("Registration Status");
            alertDialog.setMessage("Registration of the new user was a success, we will now back you out to nav.");
            context.startActivity(new Intent(context, NavigationActivity.class));

        }else if(result.contains("updated")){//Update Status if statement

            alertDialog.setTitle("Update Status");
            Toast.makeText(context, "Update was successful!", Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, NavigationActivity.class));

        }else if(result.contains("Please enter both name and surname")){//Delete Status if statement

            alertDialog.setTitle("Deletion Status");
            alertDialog.setMessage("Please Enter both name and surname");

        }else if(result.contains("Please enter the ID of the user you want to remove")){

            alertDialog.setTitle("Deletion Status");
            alertDialog.setMessage("You need to enter ID of user you want to remove!!!");

        }else if(result.contains("User has been removed")) {//Checking if the insert was a success (insert.php)

            alertDialog.setTitle("Deletion Status");
            alertDialog.setMessage("User has been removed successfully");
            Toast.makeText(context, "The user has been deleted, You have been returned to the nav screen!", Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, NavigationActivity.class));

        }else if(result.contains("Found")){
            alertDialog.setTitle("Search Status");
            alertDialog.setMessage("ID has been found, proceeding now.");
            Toast.makeText(context, "You will be moved to update screen shortly", Toast.LENGTH_SHORT).show();
        }else{
            alertDialog.setTitle("Status");
            alertDialog.setMessage("Something went horribly wrong, and idk what!" + result);
            Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show();
        }

        alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}