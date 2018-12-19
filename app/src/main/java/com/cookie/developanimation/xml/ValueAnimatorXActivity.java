package com.cookie.developanimation.xml;

import android.animation.AnimatorInflater;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cookie.developanimation.R;

public class ValueAnimatorXActivity extends AppCompatActivity {

    private Button btnStart,btnCancel;
    private TextView tv;

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
                doRepeatAnim();
            }
        });
    }

    private void doRepeatAnim(){
        ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(ValueAnimatorXActivity.this,
                R.animator.animator);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int offset = (int)animation.getAnimatedValue();
                tv.layout( offset,offset,tv.getWidth()+offset,tv.getHeight() + offset);
            }
        });
        valueAnimator.start();
    }
}