package com.eps.smart_epds.TabLayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.eps.smart_epds.FPS_Activity;
import com.eps.smart_epds.Fragment.Grievance_Fair_Price_Shop;
import com.eps.smart_epds.Fragment.Grievance_Other;
import com.eps.smart_epds.Fragment.Grievance_RationCard;
import com.eps.smart_epds.Grievance;
import com.eps.smart_epds.HomePage;
import com.eps.smart_epds.R;

public class Complaint_Grievance extends AppCompatActivity {
    FrameLayout simpleFrameLayout;
    TabLayout tabLayout;
    private TextView header_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_tab_actity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);

        header_text=(TextView)findViewById(R.id.header_text);
        header_text.setText("Register a Complaint");

        simpleFrameLayout = (FrameLayout) findViewById(R.id.simpleFrameLayout);
        tabLayout = (TabLayout) findViewById(R.id.simpleTabLayout);
        TabLayout.Tab rationcardTab = tabLayout.newTab();
        rationcardTab.setText("Ration Card Holder ");
        tabLayout.addTab(rationcardTab);
        TabLayout.Tab fpsTab = tabLayout.newTab();
        fpsTab.setText("Fair Price Shop");
        tabLayout.addTab(fpsTab);
        TabLayout.Tab otherTab = tabLayout.newTab();
        otherTab.setText("Other");
        tabLayout.addTab(otherTab);
        // add  the tab  in the TabLayout
        // perform setOnTabSelectedListener event on TabLayout
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
// get the current selected tab's position and replace the fragment accordingly
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new Grievance_RationCard();
                        break;
                    case 1:
                        fragment = new Grievance_Fair_Price_Shop();
                        break;
                    case 2:
                        fragment = new Grievance_Other();
                        break;
                }
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.simpleFrameLayout, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });
        Fragment fragment = null;
        fragment = new Grievance_RationCard();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.simpleFrameLayout, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Complaint_Grievance.this,Grievance.class);
        startActivity(i);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(id== android.R.id.home)
        {
            Intent i = new Intent(Complaint_Grievance.this,Grievance.class);
            startActivity(i);
            finish();
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Intent i = new Intent(Complaint_Grievance.this,HomePage.class);
            startActivity(i);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
