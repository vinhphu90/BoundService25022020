package com.examplevinhphutvp.boundservice25022020;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {
    MyBinder myBinder;
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        myBinder = new MyBinder();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
       return new MyBinder();
    }
        class MyBinder extends Binder {
            public MyService getService() {
                return MyService.this;

            }
        }
    }
