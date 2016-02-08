package com.example.lenovo.samplecard;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class LOGIN extends ActionBarActivity {
    SQLiteDatabase db;
    EditText name,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db= openOrCreateDatabase("CardDb", Context.MODE_PRIVATE,null);
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

    public void login(View v){
        name = (EditText)findViewById(R.id.myname);
        password = (EditText)findViewById(R.id.mypass);
        Cursor c1 = db.rawQuery("SELECT * FROM REGISTRATION where Name='"+name.getText().toString()+"' and Password='"+password.getText().toString()+"'", null);
        if(c1.moveToFirst())
        {
            Intent i = new Intent(LOGIN.this, CARDSYSTEM.class);
            startActivity(i);

        }
        else
        {
            Toast.makeText(getApplicationContext(), "Wrong username or password", Toast.LENGTH_LONG).show();
        }
    }
}
