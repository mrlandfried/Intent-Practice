package com.example.intentpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class childActivity extends AppCompatActivity {

    private TextView tv1, tv2;
    private Button logout;
    private SharedPreferences mySharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        logout = (Button) findViewById(R.id.button_logout);

        mySharedPref = getSharedPreferences("MyPref", MODE_PRIVATE);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final SharedPreferences.Editor editor = mySharedPref.edit();
                editor.putString("uname", "");
                editor.apply();
                finish();
            }
        });

        Intent intent = getIntent();

        String un = intent.getStringExtra("username");
        tv1.setText(un);

        tv2.setText(intent.getStringExtra("password"));


    }
}