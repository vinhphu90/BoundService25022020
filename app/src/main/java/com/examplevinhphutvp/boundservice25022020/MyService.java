package com.examplevinhphutvp.boundservice25022020;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {
    MyBinder myBinder;
    int ketqua = -1 ;
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        myBinder = new MyBinder();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        final Integer st1 = intent.getIntExtra("st1",-1);
        final Integer st2 = intent.getIntExtra("st2",-1);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              ketqua = st1+st2;
            }
        },2000);
       return new MyBinder();
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Toast.makeText(this," onRebind",Toast.LENGTH_SHORT).show();
    }

    class MyBinder extends Binder {
            public MyService getService() {
                return MyService.this;

            }
        }
        public int getKetqua(){
        return ketqua ;
        }
    }
