package com.cookie.developanimation;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ArgbEvaluatorActivity extends AppCompatActivity {
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
        ValueAnimator animator = ValueAnimator.ofInt(0xffffff00,0xff0000ff);
        animator.setEvaluator(new ArgbEvaluator());
        animator.setDuration(3000);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int)animation.getAnimatedValue();
                tv.setBackgroundColor(curValue);

            }
        });
        animator.start();
        return animator;
    }//我们在IntEvaluator的基础上修改了下，让它返回值时增加了200；所以当我们定义的区间是ofInt(0,400)时，它的实际返回值区间应该是(200,600)
}