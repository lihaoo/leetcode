package com.proguard.haoli.niuke;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Thread thread;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HashMap hashMap = new HashMap();
    }

    public class MyHandler extends Handler {

        private MyHandler(Context context) {

        }

        @Override
        public void handleMessage(Message msg) {

        }
    }
}