package com.coviam.booking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by mohammedshaiban on 5/6/16.
 */
public class login extends AppCompatActivity {

    private EditText name,email,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        name = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email_edit_text);
        password = (EditText) findViewById(R.id.password);

        login = (Button) findViewById(R.id.action_ok);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(validateLogin()){
//                    makeApiCall();
//                }
                Intent i = new Intent(login.this,ActivityMain.class);
                startActivity(i);
            }
        });

    }

    private void makeApiCall() {

        String tname, temail, tpassword;

        tname = name.getText().toString();
        temail = email.getText().toString();
        tpassword=password.toString();

        String url = "http://172.16.26.32:8080/spr-mvc-hib?name="+tname+"email="+temail+"password="+tpassword;

        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        apiResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(login.this,error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void apiResponse(String response) {
        JSONObject reader = null;
        try {
        reader = new JSONObject(response);
        String status = reader.getString("status");
        if(status.equalsIgnoreCase("success")){
            Intent i = new Intent(login.this,ActivityMain.class);
            startActivity(i);
        }else{
            Toast.makeText(login.this,"Something is wrong, try again",Toast.LENGTH_LONG).show();
        }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private boolean validateLogin(){
        if(TextUtils.isEmpty(name.getText().toString())){
            name.setError("Enter name");
            return false;
        }else if(TextUtils.isEmpty(email.getText().toString())){
            email.setError("Enter email");
            return false;
        }else if(TextUtils.isEmpty(password.getText().toString())){
            password.setError("Enter password");
            return false;
        }else{
            return true;
        }
    }

}
