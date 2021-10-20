package com.wdj.tabview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabhost = getTabHost();

        TabHost.TabSpec tabSpecDog = tabhost.newTabSpec("Dog").setIndicator("Dog");
        tabSpecDog.setContent(R.id.dog);
        tabhost.addTab(tabSpecDog);

        TabHost.TabSpec tabSpecCat = tabhost.newTabSpec("Cat").setIndicator("Cat");
        tabSpecCat.setContent(R.id.cat);
        tabhost.addTab(tabSpecCat);

        TabHost.TabSpec tabSpecRabbit = tabhost.newTabSpec("Rabbit").setIndicator("Rabbit");
        tabSpecRabbit.setContent(R.id.rabbit);
        tabhost.addTab(tabSpecRabbit);

        TabHost.TabSpec tabSpecHorse = tabhost.newTabSpec("Horse").setIndicator("Horse");
        tabSpecHorse.setContent(R.id.horse);
        tabhost.addTab(tabSpecHorse);

        tabhost.setCurrentTab(0);
    }
}