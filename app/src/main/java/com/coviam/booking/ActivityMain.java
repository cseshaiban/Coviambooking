package com.coviam.booking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class ActivityMain extends AppCompatActivity {
    LinearLayout r1,r2,r3,r4,r5,r6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        r1 = (LinearLayout) findViewById(R.id.r1);
        r2 = (LinearLayout) findViewById(R.id.r2);
        r3 = (LinearLayout) findViewById(R.id.r3);
        r4 = (LinearLayout) findViewById(R.id.r4);
        r5 = (LinearLayout) findViewById(R.id.r5);
        r6 = (LinearLayout) findViewById(R.id.r6);

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigate(1);
            }
        });
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigate(2);
            }
        });
        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigate(3);
            }
        }); r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigate(4);
            }
        });
        r5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigate(5);
            }
        });
        r6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigate(6);
            }
        });
    }

    private void navigate(int i){
        Intent in = new Intent(ActivityMain.this,SecondActivity.class);
        in.putExtra("ROOM_ID",i);
        startActivity(in);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
