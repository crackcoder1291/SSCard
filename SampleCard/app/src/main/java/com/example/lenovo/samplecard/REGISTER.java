package com.example.lenovo.samplecard;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class REGISTER extends ActionBarActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = openOrCreateDatabase("CardDb", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS REGISTRATION(Name VARCHAR,Password VARCHAR)");
    }

    EditText t1, t2, t3;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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

    public void subb(View v) {
        t1 = (EditText) findViewById(R.id.username);
        t2 = (EditText) findViewById(R.id.pass1);
        t3 = (EditText) findViewById(R.id.pass2);
        String n1, n2, n3;
        n1 = t1.getText().toString();
        n2 = t2.getText().toString();
        n3 = t3.getText().toString();
        if (n2.compareTo(n3) == 0) {
            db.execSQL("INSERT INTO REGISTRATION VALUES('" + n1 + "','" + n2 + "');");
            Toast.makeText(getApplicationContext(), "Registration successful", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(REGISTER.this, MainActivity.class);
            startActivity(i);
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Please type the matching password", Toast.LENGTH_SHORT).show();
        }
    }
}
