package com.example.intentpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    private EditText username, password;
    private Button submit, button2, button3;
    private SharedPreferences mySharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySharedPref = getSharedPreferences("MyPref", MODE_PRIVATE);

        String test = mySharedPref.getString("uname", "");
        if (!test.equals("")){
            Intent intent = new Intent(MainActivity.this, childActivity.class);
            intent.putExtra("username", test);
            startActivity(intent);

        }

        Log.d("INTENT_DEBUG", test);


        final SharedPreferences.Editor editor = mySharedPref.edit();

        username = (EditText) findViewById(R.id.et_username);
        password = (EditText) findViewById(R.id.et_password);
        submit = (Button) findViewById(R.id.button);

        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String validUsername = "bob";
                String validPassword = "abc";

                String un = username.getText() + "";
                String pass = password.getText().toString();

                username.setText("");
                password.setText("");

                if (un.equals(validUsername) && pass.equals(validPassword)) {
                    editor.putString("uname", un);
                    editor.apply();


                    Intent intent = new Intent(MainActivity.this, childActivity.class);
                    intent.putExtra("username", un);
                    intent.putExtra("password", pass);
                    startActivity(intent);
                }
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://sites.google.com/desertsands.us/pdhs/home";
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String geo = "geo:0,0?q=Las Vegas";
                Uri geoLocation = Uri.parse(geo);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(geoLocation);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });



    }
}