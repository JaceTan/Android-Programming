package com.flyingjuices.fiestaequities;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        TabHost tabHost = getTabHost();
        
        // Tab for Lectures
        TabSpec learnspec = tabHost.newTabSpec("Learn");
        // setting Title and Icon for the Tab
        learnspec.setIndicator("", getResources().getDrawable(R.drawable.icon_learn_tab));
        Intent learnIntent = new Intent(this, LearnActivity.class);
        learnspec.setContent(learnIntent);
 
        // Tab for Dictionary
        TabSpec dictionaryspec = tabHost.newTabSpec("Dictionary");
        dictionaryspec.setIndicator("", getResources().getDrawable(R.drawable.icon_dictionary_tab));
        Intent dictionaryIntent = new Intent(this, DictionaryActivity.class);
        dictionaryspec.setContent(dictionaryIntent);
        
        // Tab for Achievements
        TabSpec achievementsspec = tabHost.newTabSpec("Achievements");
        achievementsspec.setIndicator("", getResources().getDrawable(R.drawable.icon_achievements_tab));
        Intent achievementsIntent = new Intent(this, AchievementsActivity.class);
        achievementsspec.setContent(achievementsIntent);
        
        //Tab for About Us
        TabSpec aboutusspec = tabHost.newTabSpec("About Us");
        aboutusspec.setIndicator("", getResources().getDrawable(R.drawable.icon_about_us_tab));
        Intent aboutUsIntent = new Intent(this, AboutUsActivity.class);
        aboutusspec.setContent(aboutUsIntent);
        
        // Adding all TabSpec to TabHost
        tabHost.addTab(learnspec); // Adding learn tab
        tabHost.addTab(dictionaryspec); // Adding dictionary tab
        tabHost.addTab(achievementsspec); // Adding achievements tab
        tabHost.addTab(aboutusspec);// Adding about us tab

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
