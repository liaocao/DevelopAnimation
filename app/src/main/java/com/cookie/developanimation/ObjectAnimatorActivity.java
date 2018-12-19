package com.cookie.developanimation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ObjectAnimatorActivity extends AppCompatActivity {

    private Button btnStart,btnCancel;
    private TextView tv;
    private ValueAnimator repeatAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);


        tv = (TextView) findViewById(R.id.tv);

        btnStart = (Button) findViewById(R.id.btn);
        btnCancel = (Button)findViewById(R.id.btn_cancel);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repeatAnimator = doRepeatAnim();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                repeatAnimator.cancel();
            }
        });
    }

    private ValueAnimator doRepeatAnim(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv,"alpha",1,0,1);
        animator.setDuration(2000);
        animator.start();
        return animator;
    }
}