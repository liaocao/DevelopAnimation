package com.cookie.developanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnimatorSetBuilderActivity extends AppCompatActivity {

    private Button mButton;
    private TextView mTv1, mTv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_sequentially);

        mButton = (Button) findViewById(R.id.btn);
        mTv1 = (TextView) findViewById(R.id.tv_1);
        mTv2 = (TextView) findViewById(R.id.tv_2);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPlaySequentiallyAnimator();
            }
        });
    }

    private void doPlaySequentiallyAnimator(){
        ObjectAnimator tv1TranslateY = ObjectAnimator.ofFloat(mTv1, "translationY", 0, 400, 0);
        ObjectAnimator tv2TranslateY = ObjectAnimator.ofFloat(mTv2, "translationY", 0, 400, 0);
        tv2TranslateY.setStartDelay(2000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(tv2TranslateY).with(tv1TranslateY);
        animatorSet.setStartDelay(4000);
        animatorSet.setDuration(2000);
        animatorSet.start();
    }
}
