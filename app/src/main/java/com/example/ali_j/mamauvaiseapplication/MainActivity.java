package com.example.ali_j.mamauvaiseapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;
import android.os.Message;

public class MainActivity extends AppCompatActivity {
    Handler monHandler=new Handler() {

        @Override
        public void dispatchMessage(Message msg) {
            TextView Text1 = (TextView) findViewById(R.id.Text1);
            Text1.setText("Telechargement complete avec succes");
        }
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  void    Telecharger(View view) {
        Runnable r=new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        Thread.sleep(15000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    monHandler.sendEmptyMessage(0);
                }
            }

    };Thread monThread=new Thread(r);
    monThread.start();
    }
    public void afficherMessage(View view){
        Toast.makeText(this,"vous avez clique sur le bouton qui affiche le message",Toast.LENGTH_LONG).show();


    }
}
