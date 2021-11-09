package kr.taemin.urikiri;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class SplashActivity extends Activity {
    private int threadNum = 0;
    Handler han;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        han = new Handler(){
            @Override
            public void handleMessage(Message msg){
                super.handleMessage(msg);
            }
        };

        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                count =0;
                while(true) {
                    Message msg = han.obtainMessage();
                    count++;
                    msg.arg1 = count;
                    //Log.i("시작된 스레드", Integer.toString(threadNum));

                    han.sendMessage(msg);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if(count == 2) {
                        startActivity(intent);
                        finish();
                        break;
                    }
                }
            }
        });
        th.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}




