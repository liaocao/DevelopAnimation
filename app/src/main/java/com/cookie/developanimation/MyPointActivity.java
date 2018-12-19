package com.cookie.developanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyPointActivity extends AppCompatActivity {

    private Button btnStart;
    private MyPointView mPointView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_point);

        btnStart = (Button) findViewById(R.id.btn);
        mPointView = (MyPointView)findViewById(R.id.pointview);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPointView.doPointAnim();
            }
        });
    }
}
