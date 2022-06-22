package com.example.allinone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button btn2;
    EditText txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn2 = (Button)findViewById(R.id.button2);
        txt1 = (EditText)findViewById(R.id.editTextTextPersonName);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Channel","My Channel", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("MY Channel");
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity2.this, "My Channel");
                builder.setContentTitle("Here's a Message for You !!");
                builder.setContentText(txt1.getText().toString().trim());
                builder.setSmallIcon(R.drawable.ic_launcher_background);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity2.this);
                managerCompat.notify(1337,builder.build());

                Toast.makeText(getApplicationContext(), "Notified", Toast.LENGTH_LONG).show();
                txt1.setText("");

            }
        });
    }
}