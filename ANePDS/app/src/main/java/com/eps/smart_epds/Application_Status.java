package com.eps.smart_epds;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.eps.smart_epds.Adapter.Application_status_adapter;
import com.eps.smart_epds.Model.Applcation_Status_Model;

import java.util.ArrayList;

/**
 * Created by lenovo on 12/4/2017.
 */

public class Application_Status extends AppCompatActivity {
    Toolbar toolbar;
    ActionBar actionBar;
    Bundle bundle;
    private ListView listview;
    private Application_status_adapter adapter;
    String[] data = {"11/12/2017", "452136", "Auto & Taxi Renewal"};
    public  static ArrayList<Applcation_Status_Model> listitem=new ArrayList<Applcation_Status_Model>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.application_status);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
        //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        listitem=GetAppStatusData();
        Init();
    }

    private ArrayList<Applcation_Status_Model> GetAppStatusData() {
        ArrayList<Applcation_Status_Model> list = new ArrayList<Applcation_Status_Model>();
        for (int i = 0; i < 7; i++) {
            Applcation_Status_Model obj = new Applcation_Status_Model();

            if (i == 0) {
                obj.setDate("05-12-2017");
                obj.setAcknowledgeNo("100000");
                obj.setRequestType("Fresh RationCard");
                obj.setWaorkFlow("Create");
                obj.setStatus("Submitted");
                obj.setDateTime("06-12-2017- 17:00 pm");
            } else if (i == 1) {
                obj.setDate("06-12-2017");
                obj.setAcknowledgeNo("100001");
                obj.setRequestType("Auto & Taxi Renewal");
                obj.setWaorkFlow("Mark");
                obj.setStatus("Approved");
                obj.setDateTime("07-12-2017 - 14:00 pm");
            } else if (i == 2) {
                obj.setDate("07-12-2017");
                obj.setAcknowledgeNo("100002");
                obj.setRequestType("Weiging Instrument");
                obj.setWaorkFlow("Verify");
                obj.setStatus("Rejected");
                obj.setDateTime("07-12-2017 - 11:00 am");
            }else if (i == 3) {
                obj.setDate("09-12-2017");
                obj.setAcknowledgeNo("100003");
                obj.setRequestType("Fresh RationCard");
                obj.setWaorkFlow("Create");
                obj.setStatus("Rejected");
                obj.setDateTime("10-12-2017 - 11:00 am");
            }else if (i == 4) {
                obj.setDate("10-12-2017");
                obj.setAcknowledgeNo("100004");
                obj.setRequestType("Auto & Taxi Renewal");
                obj.setWaorkFlow("Inspection");
                obj.setStatus("Open");
                obj.setDateTime("11-12-2017 - 16:00 am");
            }else if (i == 5) {
                obj.setDate("11-12-2017");
                obj.setAcknowledgeNo("100005");
                obj.setRequestType("Weiging Instrument");
                obj.setWaorkFlow("Mark");
                obj.setStatus("Approved");
                obj.setDateTime("12-12-2017 - 15:00 am");
            }else if (i == 6) {
                obj.setDate("12-12-2017");
                obj.setAcknowledgeNo("100006");
                obj.setRequestType("Auto & Taxi Renewal");
                obj.setWaorkFlow("Mark");
                obj.setStatus("Rejected");
                obj.setDateTime("12-12-2017 - 15:00 am");
            }

            list.add(obj);
             obj=null;
        }

        return list;
    }

    private void Init() {
        listview = (ListView) findViewById(R.id.listview);
        adapter = new Application_status_adapter(getApplicationContext(), GetAppStatusData());
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Application_Status.this, Application_Status_Individual.class);
                intent.putExtra("Index",i);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(Application_Status.this, HomePage.class);
        i.putExtra("value", 1);
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
        if (id == android.R.id.home) {
            Intent i = new Intent(Application_Status.this, HomePage.class);
            i.putExtra("value", 1);
            startActivity(i);
            finish();
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Intent i = new Intent(Application_Status.this, HomePage.class);
            startActivity(i);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
