package com.example.allinone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4, btn5, btn6, btn7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.button);
        btn2 = (Button)findViewById(R.id.button3);
        btn3 = (Button)findViewById(R.id.button9);
        btn4 = (Button)findViewById(R.id.button11);
        btn5 = (Button)findViewById(R.id.button13);
        btn6 = (Button)findViewById(R.id.button16);
        btn7 = (Button)findViewById(R.id.button17);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(int1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2 = new Intent(getApplicationContext(),MainActivity3.class);
                startActivity(int2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int3 = new Intent(getApplicationContext(),MainActivity4.class);
                startActivity(int3);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int4 = new Intent(getApplicationContext(),MainActivity5.class);
                startActivity(int4);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int5 = new Intent(getApplicationContext(),MainActivity6.class);
                startActivity(int5);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int6 = new Intent(getApplicationContext(), MainActivity7.class);
                startActivity(int6);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int7 = new Intent(getApplicationContext(), MainActivity8.class);
                startActivity(int7);
            }
        });
    }
}