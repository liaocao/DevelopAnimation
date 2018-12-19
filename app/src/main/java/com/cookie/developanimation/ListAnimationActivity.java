package com.cookie.developanimation;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListAnimationActivity extends AppCompatActivity {

    private List<Drawable> drawables = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_animation);

        drawables.add(getResources().getDrawable(R.mipmap.pic1));
        drawables.add(getResources().getDrawable(R.mipmap.pic2));
        drawables.add(getResources().getDrawable(R.mipmap.pic3));
        drawables.add(getResources().getDrawable(R.mipmap.pic4));
        drawables.add(getResources().getDrawable(R.mipmap.pic5));
        drawables.add(getResources().getDrawable(R.mipmap.pic6));
        drawables.add(getResources().getDrawable(R.mipmap.pic7));
        drawables.add(getResources().getDrawable(R.mipmap.pic8));
        drawables.add(getResources().getDrawable(R.mipmap.pic9));

        ListView listView = (ListView)findViewById(R.id.list);
        final ListAdapter adapter = new ListAdapter(this,listView,drawables,300);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //关键在这里哦
                Drawable drawable = (Drawable) adapter.getItem(position);
            }
        });
    }
}
