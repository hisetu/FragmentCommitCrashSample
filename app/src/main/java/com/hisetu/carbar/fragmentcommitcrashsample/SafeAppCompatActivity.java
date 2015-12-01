package com.hisetu.carbar.fragmentcommitcrashsample;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class SafeAppCompatActivity extends AppCompatActivity {
    private boolean isPaused = false;
    private Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler = new Handler();
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        isPaused = false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        isPaused = true;
    }

    protected void safeCommit(final Runnable commitTask) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (isPaused) {
                    handler.postDelayed(this, 500);
                } else {
                    if (commitTask != null)
                        commitTask.run();
                }
            }
        });
    }
}
