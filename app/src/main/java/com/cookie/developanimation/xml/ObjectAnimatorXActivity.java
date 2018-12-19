package com.cookie.developanimation.xml;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cookie.developanimation.R;

public class ObjectAnimatorXActivity extends AppCompatActivity {

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
        ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(ObjectAnimatorXActivity.this,
                R.animator.object_animator);
        animator.setTarget(tv);
        animator.start();
    }
}