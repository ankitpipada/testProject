package com.eps.smart_epds;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.eps.smart_epds.TabLayout.Complaint_Grievance;

/**
 * Created by lenovo on 12/4/2017.
 */

public class Grievance extends AppCompatActivity implements View.OnClickListener {
    CardView register_complaint, track;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grievance);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        Init();
    }

    private void Init() {
        register_complaint = (CardView) findViewById(R.id.register_complaint);
        register_complaint.setOnClickListener(this);
        track = (CardView) findViewById(R.id.track);
        track.setOnClickListener(this);
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
        if (id == android.R.id.home) {
            Intent i = new Intent(Grievance.this, HomePage.class);
            startActivity(i);
            finish();
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Intent i = new Intent(Grievance.this, HomePage.class);
            startActivity(i);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(Grievance.this, HomePage.class);
        i.putExtra("value", 1);
        startActivity(i);
        finish();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.register_complaint:
                Intent reg_intent = new Intent(getApplicationContext(), Complaint_Grievance.class);
                startActivity(reg_intent);
                finish();
                break;
            case R.id.track:
                Intent track_intent = new Intent(getApplicationContext(), Grievance_Track_activity.class);
                startActivity(track_intent);
                finish();
                break;
        }
    }
}
