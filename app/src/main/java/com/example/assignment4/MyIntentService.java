package com.example.assignment4;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
/**
 * Created by DEll1 on 12/22/2017.
 */
public class MyIntentService extends IntentService {

    private static final String TAG = "MyIntentService";
    private boolean running = true;

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        int data = Integer.parseInt(intent.getExtras().get("MyData").toString());
        int i = 0;
        try {
            while (running && (i < data)) {

                EventBus.getDefault().post(new MyData(i));
                Log.d(TAG, "onHandleIntent: " + i);

                Thread.sleep(1000);
                i++;

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        running = false;
        super.onDestroy();
    }
}
