package com.flyingjuices.fiesta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class LearnActivity extends Activity{
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_layout);
        
        // storing string resources into Array
        String[] lecture_topics = getResources().getStringArray(R.array.topics);
 
        // Binding resources Array to ListAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.topics_list_item, R.id.label, lecture_topics);
        
        ListView singletopic = (ListView) findViewById(R.id.ListOfTopics);
        singletopic.setAdapter(adapter);
        
        // listening to single list item on click
        singletopic.setOnItemClickListener(new OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, View view,
              int position, long id) {
 
              // selected item
              String topic = ((TextView) view).getText().toString();
 
              // Launching new Activity on selecting single List Item
              Intent i = new Intent(getApplicationContext(), SingleTopic.class);
              // sending data to new activity
              i.putExtra("Topic", topic);
              startActivity(i);
 
          }
        });
	
	}
}