package com.wordpress.jonyonandroidcraftsmanship.handlerbasic2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnSend=null;
    private MyThread myThread=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        btnSend= (Button) findViewById(R.id.btnSend);
        Logger.log(Thread.currentThread().getName());
        myThread=new MyThread();
        myThread.start();
    }

    public void sendMessage(View view) {
        myThread.handler.post(new Runnable() {
            @Override
            public void run() {
                Logger.log(Thread.currentThread().getName());
            }
        });
    }

    private class MyThread extends Thread{
        Handler handler=null;
        public MyThread() {

        }
        @Override
        public void run() {
            Looper.prepare();
            handler=new Handler();
            Looper.loop();
        }
    }
}
