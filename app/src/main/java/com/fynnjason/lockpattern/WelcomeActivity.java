package com.fynnjason.lockpattern;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.fynnjason.lockpattern.util.PreferenceUtil;


public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String passwordStr = PreferenceUtil.getGesturePassword(WelcomeActivity.this);
                Intent intent;
                if (passwordStr.equals("")) {
                    intent = new Intent(WelcomeActivity.this, SetLockActivity.class);
                } else {
                    intent = new Intent(WelcomeActivity.this, UnlockActivity.class);
                }
                startActivity(intent);
                WelcomeActivity.this.finish();
            }
        }, 2000);
    }
}
