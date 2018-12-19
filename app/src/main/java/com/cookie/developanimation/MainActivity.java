package com.cookie.developanimation;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.cookie.developanimation.xml.ObjectAnimatorXActivity;
import com.cookie.developanimation.xml.ValueAnimatorXActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new SimpleAdapter(this, getData(), android.R.layout.simple_list_item_1, new String[] {"title"}, new int[] {android.R.id.text1}));
    }

    protected List<Map<String, Object>> getData(){
        List<Map<String, Object>> myData = new ArrayList<Map<String, Object>>();
        addItem(myData, "ValueAnimatorActivity", new Intent(this, ValueAnimatorActivity.class));
        addItem(myData, "BounceInterpolatorActivity", new Intent(this, BounceInterpolatorActivity.class));
        addItem(myData, "MyEvaluatorActivity", new Intent(this, MyEvaluatorActivity.class));
        addItem(myData, "ReverseEvaluatorActivity", new Intent(this, ReverseEvaluatorActivity.class));
        addItem(myData, "ArgbEvaluatorActivity", new Intent(this, ArgbEvaluatorActivity.class));
        addItem(myData, "ofObjectActivity", new Intent(this, ofObjectActivity.class));
        addItem(myData, "MyPointActivity", new Intent(this, MyPointActivity.class));
        addItem(myData, "=======================", null);
        addItem(myData, "ObjectAnimatorActivity", new Intent(this, ObjectAnimatorActivity.class));
        addItem(myData, "PlaySequentiallyActivity", new Intent(this, PlaySequentiallyActivity.class));
        addItem(myData, "PlayTogetherActivity", new Intent(this, PlayTogetherActivity.class));
        addItem(myData, "PlayTogetherInfinityActivity", new Intent(this, PlayTogetherInfinityActivity.class));
        addItem(myData, "PlaySequentiallyDelayActivity", new Intent(this, PlaySequentiallyDelayActivity.class));
        addItem(myData, "AnimatorSetBuilderActivity", new Intent(this, AnimatorSetBuilderActivity.class));
        addItem(myData, "ValueAnimatorXActivity", new Intent(this, ValueAnimatorXActivity.class));
        addItem(myData, "ObjectAnimatorXActivity", new Intent(this, ObjectAnimatorXActivity.class));
        addItem(myData, "PopMenuActivity", new Intent(this, PopMenuActivity.class));
        addItem(myData, "LayoutAnimationActivity", new Intent(this, LayoutAnimationActivity.class));
        addItem(myData, "GridLayoutAnimationActivity", new Intent(this, GridLayoutAnimationActivity.class));
        addItem(myData, "LayoutChangesActivity", new Intent(this, LayoutChangesActivity.class));
        addItem(myData, "ListAnimationActivity", new Intent(this, ListAnimationActivity.class));
        return myData;
    }

    private void addItem(List<Map<String, Object>> data, String title, Intent intent){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", title);
        map.put("intent", intent);

        data.add(map);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        Map<String, Object> map = (Map<String, Object>) l.getItemAtPosition(position);

        Intent i = (Intent) map.get("intent");
        if(i != null)
        startActivity(i);
    }
}
