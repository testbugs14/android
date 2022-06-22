package com.example.allinone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    EditText inp1, inp2, inp3;
    Button b1,b2,b3,b4,b5;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        b1 = (Button)findViewById(R.id.button4);
        b2 = (Button)findViewById(R.id.button5);
        b3 = (Button)findViewById(R.id.button6);
        b4 = (Button)findViewById(R.id.button7);
        b5 = (Button)findViewById(R.id.button8);

        inp1 = (EditText)findViewById(R.id.editTextTextPersonName2);
        inp2 = (EditText)findViewById(R.id.editTextTextPersonName3);
        inp3 = (EditText)findViewById(R.id.editTextTextPersonName4);

        db = openOrCreateDatabase("studentDB", Context.MODE_PRIVATE, null);
        db.execSQL("create table if not exists student(rollno varchar(7), name varchar(20), marks varchar(3));");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = inp2.getText().toString().trim();
                String rollno = inp1.getText().toString().trim();
                String marks = inp3.getText().toString().trim();

                if((name.length()==0)||(rollno.length()==0)||(marks.length()==0)){
                    Toast.makeText(getApplicationContext(),"All Fields must be filled",Toast.LENGTH_LONG);
                    return;
                }

                db.execSQL("insert into student values('"+rollno+"','"+name+"','"+marks+"');");
                showMessage("Success","Inserted into DB");
                clearText();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rollno = inp1.getText().toString().trim();

                if(rollno.length()==0){
                    showMessage("Alert","Roll no is mandatory for deletion");
                    return;
                }

                db.execSQL("delete from student where rollno = "+rollno+";");
                showMessage("Success","Deleted successfully !!");
                clearText();
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor c = db.rawQuery("select * from student",null);
                if(c.getCount()==0){
                    showMessage("Failed","nothing to show");
                    return;
                }

                StringBuffer stb = new StringBuffer();

                while (c.moveToNext()){
                    stb.append("Rollno : "+c.getString(0)+"\n");
                    stb.append("Name : "+c.getString(1)+"\n");
                    stb.append("Marks : "+c.getString(2)+"\n");
                    stb.append("\n");
                }
                showMessage("Records ",stb.toString());
            }
        });

    }
    private void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.show();
    }
    private void clearText(){
        inp1.setText("");
        inp2.setText("");
        inp3.setText("");
    }
}