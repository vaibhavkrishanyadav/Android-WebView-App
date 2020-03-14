package com.vibhu.rahulapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityB extends AppCompatActivity {
        Button retry;
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activityb);
            retry = findViewById(R.id.retryb);
            retry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gotoActivity();
                }
            });
        }

        public void gotoActivity(){
            Intent i = new Intent(ActivityB.this, MainActivity.class);
            startActivity(i);
            finish();
        }
}
