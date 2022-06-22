package com.example.allinone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity4 extends AppCompatActivity {

    Button btn;
    ProgressBar pb1, pb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        btn = (Button)findViewById(R.id.button10);
        pb1 = (ProgressBar)findViewById(R.id.progressBar);
        pb2 = (ProgressBar)findViewById(R.id.progressBar2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startProgress();
            }
        });

    }
    private void  startProgress(){
        pb1.setProgress(0);
        new Thread(new task1()).start();
        pb2.setProgress(0);
        new Thread(new task2()).start();
    }

    private class task1 implements Runnable{

        @Override
        public void run(){

            Thread.currentThread().setName("Thread 1");

            for(int i=0;i<=100;i+=5){
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pb1.setProgress(i);
            }
        }
    }
    private class task2 implements Runnable{

        @Override
        public void run(){

            Thread.currentThread().setName("Thread 2");

            for(int i=0;i<=100;i+=10){
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pb2.setProgress(i);
            }
        }
    }
}