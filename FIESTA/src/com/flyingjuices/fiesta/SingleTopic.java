package com.flyingjuices.fiesta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
 
public class SingleTopic extends Activity{
	String[] chapters;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_topic_item_view);
 
        TextView txtTopic = (TextView) findViewById(R.id.topic_label);
 
        Intent i = getIntent();
        // getting attached intent data
        String topic = i.getStringExtra("Topic");
        // displaying selected product name
        txtTopic.setText(topic);
        
        if (topic.equals("Equities")){
        	chapters = getResources().getStringArray(R.array.EquitiesChapters);
        } else if (topic.equals("Bonds")){
        	//chapters = getResources().getStringArray(R.array.BondsChapters);
        }
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.chapters_list_item, R.id.label, chapters);
        
        ListView singleChapter = (ListView) findViewById(R.id.Chapters);
        singleChapter.setAdapter(adapter);
        
        
 
    }
}