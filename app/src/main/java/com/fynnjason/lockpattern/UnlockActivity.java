package com.fynnjason.lockpattern;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.fynnjason.lockpattern.util.PreferenceUtil;
import com.fynnjason.lockpattern.view.LockPatternView;

public class UnlockActivity extends AppCompatActivity {

    private LockPatternView mLockPatternView;
    private String mPasswordStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);

        mLockPatternView = (LockPatternView) findViewById(R.id.lockView);

        mLockPatternView.setLockListener(new LockPatternView.OnLockListener() {
            String password = PreferenceUtil.getGesturePassword(UnlockActivity.this);

            @Override
            public void getStringPassword(String password) {
                mPasswordStr = password;
            }

            @Override
            public boolean isPassword() {
                if (mPasswordStr.equals(password)) {
                    Log.e("UnlockActivity", "密码"+password);
                    Toast.makeText(UnlockActivity.this, "密码正确", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UnlockActivity.this, MainActivity.class);
                    startActivity(intent);
                    UnlockActivity.this.finish();
                } else {
                    Toast.makeText(UnlockActivity.this, "密码不正确", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

    }

}
