package com.flyingjuices.fiestaPG;

import android.os.Bundle;
//import android.app.Activity;
import android.view.Menu;
import org.apache.cordova.DroidGap;

import com.flyingjuices.fiesta.R;

public class MainActivity extends DroidGap {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.loadUrl("file:///android_asset/www/index.html");
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
