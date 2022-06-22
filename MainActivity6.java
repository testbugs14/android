package com.example.allinone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity6 extends AppCompatActivity {

    Button btn1, btn2;
    TextView txtv;
    EditText inp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        btn1 = (Button)findViewById(R.id.button14);
        btn2 = (Button)findViewById(R.id.button15);

        txtv = (TextView)findViewById(R.id.textView6);
        inp = (EditText)findViewById(R.id.editTextTextPersonName5);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = inp.getText().toString().trim();
                String fname = "sdstore";

                try{

                    FileOutputStream fout = openFileOutput(fname, MODE_PRIVATE);
                    fout.write(msg.getBytes());
                    fout.close();
                    inp.setText("");
                    Toast.makeText(getApplicationContext(), "Success",Toast.LENGTH_LONG).show();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    FileInputStream fin = openFileInput("sdstore");
                    InputStreamReader inputStreamReader = new InputStreamReader(fin);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String msg;
                    StringBuffer stringBuffer = new StringBuffer();
                    msg = bufferedReader.readLine();
                    while(msg!= null){
                        stringBuffer.append(msg + "\n");
                        msg = bufferedReader.readLine();
                    }

                    txtv.setText(stringBuffer.toString());
                    txtv.setVisibility(View.VISIBLE);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        });


    }
    public void write(View view){
        String msg = inp.getText().toString().trim();
        String fname = "sdstore";

        try{

            FileOutputStream fout = openFileOutput(fname, MODE_PRIVATE);
            fout.write(msg.getBytes());
            fout.close();
            inp.setText("");
            Toast.makeText(getApplicationContext(), "Success",Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void  read(View view){
        try{
            FileInputStream fin = openFileInput("sdstore");
            InputStreamReader inputStreamReader = new InputStreamReader(fin);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String msg;
            StringBuffer stringBuffer = new StringBuffer();
            msg = bufferedReader.readLine();
            while(msg!= null){
                stringBuffer.append(msg + "\n");
                msg = bufferedReader.readLine();
            }

            txtv.setText(stringBuffer.toString());
            txtv.setVisibility(View.VISIBLE);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}