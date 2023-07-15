package com.example.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    int seconds=0;
    boolean isRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.timerText);
        startTimer();
    }
    public void onClickStart(View view){
        isRunning = true;
    }
    public void onClickStop(View view){
        isRunning = false;
    }
    public void onClickReset(View view){
        isRunning = false;
        seconds=0;

    }
    public void startTimer(){
        Handler handler=new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                int s= seconds%60;
                int m= seconds/60;
                int h= m/60;
                if (isRunning){
                seconds++;
                }

                String formatString= String.format(Locale.getDefault(),"%02d:%02d:%02d",h,m,s);
                textView.setText(formatString);
                handler.postDelayed(this,10);
            }
        };
        handler.post(runnable);
    }
}