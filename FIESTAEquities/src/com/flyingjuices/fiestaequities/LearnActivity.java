package com.flyingjuices.fiestaequities;

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
        String[] chapters = getResources().getStringArray(R.array.EquitiesChapters);
 
        // Binding resources Array
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.chapters_list_item, R.id.label, chapters);
        
        ListView singleChapter = (ListView) findViewById(R.id.Chapters);
        singleChapter.setAdapter(adapter);
        
        // listening to single list item on click
        singleChapter.setOnItemClickListener(new OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, View view,
              int position, long id) {
 
              // selected item
              String chapter = ((TextView) view).getText().toString();
 
              // Launching new Activity on selecting single List Item
              Intent i = new Intent(getApplicationContext(), SingleChapter.class);
              
              // sending data to new activity
              i.putExtra("Chapter", chapter);
              startActivity(i);
 
          }
        });
	
	}
}