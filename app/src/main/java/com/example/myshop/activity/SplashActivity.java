package com.example.myshop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.myshop.R;

public class SplashActivity extends AppCompatActivity {
    private Button eBtnSkip;
    private Handler eHandler=new Handler();
    private Runnable eRunnable=new Runnable() {
        @Override
        public void run() {
            toLoginActivity();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splish);
        initView();
        initEvent();
        eHandler.postDelayed(eRunnable,5000);
    }

    private void initEvent() {
        eBtnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toLoginActivity();
                eHandler.removeCallbacks(eRunnable);
            }
        });

    }

    private void initView() {
        eBtnSkip=findViewById(R.id.splash_button_skip);
    }

    public void toLoginActivity(){
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        eHandler.removeCallbacks(eRunnable);
    }
}