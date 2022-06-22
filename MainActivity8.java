package com.example.allinone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity8 extends AppCompatActivity {

    EditText txt1,txt2,txt3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        txt1 = (EditText)findViewById(R.id.editTextTextEmailAddress);
        txt2 = (EditText)findViewById(R.id.editTextTextPersonName6);
        txt3 = (EditText)findViewById(R.id.editTextTextMultiLine);
        btn = (Button)findViewById(R.id.button18);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txt1.getText().toString().trim();
                String sub = txt2.getText().toString().trim();
                String msg = txt3.getText().toString().trim();

                Intent in = new Intent(Intent.ACTION_SEND);

                in.putExtra(Intent.EXTRA_EMAIL,new String[]{email});
                in.putExtra(Intent.EXTRA_SUBJECT, sub);
                in.putExtra(Intent.EXTRA_TEXT, msg);
                in.setType("message/rfc822");
                startActivity(Intent.createChooser(in,"Select Email App"));

                txt1.setText("");
                txt2.setText("");
                txt3.setText("");

            }
        });

    }
}