package com.examplevinhphutvp.boundservice25022020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.strictmode.ServiceConnectionLeakedViolation;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mEdtst1, mEdtst2;
    Button mBtnTinhtoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdtst1 = findViewById(R.id.edittextSothu1);
        mEdtst2 = findViewById(R.id.edittextSothu2);
        mBtnTinhtoan = findViewById(R.id.buttonXuly);

        mBtnTinhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyService.class);
                bindService(intent,serviceConnection,BIND_AUTO_CREATE);
            }
        });
    }
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.MyBinder myBinder = (MyService.MyBinder) service ;
            Toast.makeText(MainActivity.this,"Connected",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Toast.makeText(MainActivity.this,"Disconnected",Toast.LENGTH_SHORT).show();
        }
    };
}

