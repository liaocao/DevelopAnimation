package com.cookie.developanimation;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class LayoutChangesActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout layoutTransitionGroup;
    private LayoutTransition mTransitioner;

    private int i = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_changes);

        layoutTransitionGroup = (LinearLayout) findViewById(R.id.layoutTransitionGroup);
        findViewById(R.id.add_btn).setOnClickListener(this);
        findViewById(R.id.remove_btn).setOnClickListener(this);


        mTransitioner = new LayoutTransition();
        //入场动画:view在这个容器中消失时触发的动画
        ObjectAnimator animIn = ObjectAnimator.ofFloat(null, "rotationY", 0f, 360f,0f);
        mTransitioner.setAnimator(LayoutTransition.APPEARING, animIn);

        //出场动画:view显示时的动画
        ObjectAnimator animOut = ObjectAnimator.ofFloat(null, "rotation", 0f, 90f, 0f);
        mTransitioner.setAnimator(LayoutTransition.DISAPPEARING, animOut);

        PropertyValuesHolder pvhLeft = PropertyValuesHolder.ofInt("left",0,100,0);
        PropertyValuesHolder pvhTop = PropertyValuesHolder.ofInt("top",1,1);

        PropertyValuesHolder pvhBottom = PropertyValuesHolder.ofInt("bottom",0,0);
        PropertyValuesHolder pvhRight = PropertyValuesHolder.ofInt("right",0,0);
        Animator changeAppearAnimator
                = ObjectAnimator.ofPropertyValuesHolder(layoutTransitionGroup, pvhLeft,pvhBottom,pvhTop,pvhRight);
        mTransitioner.setAnimator(LayoutTransition.CHANGE_APPEARING,changeAppearAnimator);

        layoutTransitionGroup.setLayoutTransition(mTransitioner);
    }

    private void addButtonView() {
        i++;
        Button button = new Button(this);
        button.setText("button" + i);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(params);
        layoutTransitionGroup.addView(button, 0);
    }

    private void removeButtonView() {
        if (i > 0) {
            layoutTransitionGroup.removeViewAt(0);
        }
        i--;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.add_btn) {
            addButtonView();
        }
        if (v.getId() == R.id.remove_btn) {
            removeButtonView();
        }

    }
}
