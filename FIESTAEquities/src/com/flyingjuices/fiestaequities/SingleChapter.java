package com.flyingjuices.fiestaequities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
 
public class SingleChapter extends Activity{
	String[] subChapters;
	String subChapterContent;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.single_chapter_item_view);
 
        TextView txtChapter = (TextView) findViewById(R.id.chapter_label);
 
        Intent i = getIntent();
        // getting attached intent data
        String chapter = i.getStringExtra("Chapter");
        
        // displaying selected chapter name
        txtChapter.setText(chapter);
        
        //get the List Holder
        ListView subChapterView = (ListView) findViewById(R.id.SubChapterView);
        
        // binding the right subchapters to List Holder
        if (chapter.equals("Introduction to Equities")){
        	subChapters = getResources().getStringArray(R.array.IntroductionToEquities);
        } else if (chapter.equals("Features of Equities")){
        	subChapters = getResources().getStringArray(R.array.FeaturesOfEquities);
        }
        
    	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.subchapters_list_item, R.id.label, subChapters);
    	subChapterView.setAdapter(adapter);
        
    	subChapterView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) {
            	
            	//this changes the subchapter displayed whenever a subchapter is clicked 
                String subChapter = ((TextView) view).getText().toString();
                TextView subChapterTitle = (TextView) findViewById(R.id.sub_chapter_title);
                subChapterTitle.setText(subChapter);
                
                //now need to change content
                //get content holder
                TextView ContentView = (TextView) findViewById(R.id.ContentView);
                
                //Intoduction to Equities
                if (subChapter.equals("What is Equity?")){
                	subChapterContent = getResources().getString(R.string.WhatIsEquity);
                } else if (subChapter.equals("What is Equity Investment?")){
                	subChapterContent = getResources().getString(R.string.WhatIsEquityInvestment);
                } else if (subChapter.equals("Alternative Names for Equity")){
                	subChapterContent = getResources().getString(R.string.AlternativeNamesForEquity);
                }
                
                //Features of Equities
                if (subChapter.equals("Relationship between shareholders and company")){
                	subChapterContent = getResources().getString(R.string.RelationshipBetweenShareholdersAndCompany);
                } else if (subChapter.equals("Characteristics of shares")){
                	subChapterContent = getResources().getString(R.string.CharacteristicsOfShares);
                }
                	
                //bind data to holder
                ContentView.setText(subChapterContent);
            }
    	});
        
    }
}