package com.cookie.developanimation;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;

public class BounceInterpolatorActivity extends AppCompatActivity {

    private static final String TAG = "ValueAnimatorActivity";

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
        ValueAnimator animator = ValueAnimator.ofInt(0,600);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int)animation.getAnimatedValue();
                tv.layout(tv.getLeft(),curValue,tv.getRight(),curValue+tv.getHeight());
            }
        });
        animator.setDuration(1000);
        animator.setInterpolator(new BounceInterpolator());
        animator.start();
        return animator;
    }
}
