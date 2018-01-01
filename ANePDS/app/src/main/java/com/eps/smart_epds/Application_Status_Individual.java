package com.eps.smart_epds;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.eps.smart_epds.Adapter.App_Status_Adapter;
import com.eps.smart_epds.Model.App_Status;

import java.util.ArrayList;

/**
 * Created by Admin on 12/7/2017.
 */

public class Application_Status_Individual extends AppCompatActivity {
    Toolbar toolbar;
    ActionBar actionBar;
    Bundle bundle;
    TextView header_text;
    int Index=0;
    TextView date,ack_no,re_type,work_flow,status,date_time;
    ListView app_status_alistview;
    public  static ArrayList<App_Status> appstatus = new ArrayList<App_Status>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.application_status_individual);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            Index=bundle.getInt("Index");
        }

        date = (TextView) findViewById(R.id.date);
        ack_no = (TextView) findViewById(R.id.ack_no);
        re_type = (TextView) findViewById(R.id.re_type);
        work_flow = (TextView) findViewById(R.id.work_flow);
        status = (TextView) findViewById(R.id.status);
        date_time = (TextView) findViewById(R.id.date_time);
        app_status_alistview = (ListView) findViewById(R.id.app_status_alistview);

        date.setText(Application_Status.listitem.get(Index).getDate());
        ack_no.setText(Application_Status.listitem.get(Index).getAcknowledgeNo());
        re_type.setText(Application_Status.listitem.get(Index).getRequestType());
        work_flow.setText(Application_Status.listitem.get(Index).getWaorkFlow());
        status.setText(Application_Status.listitem.get(Index).getStatus());
        date_time.setText(Application_Status.listitem.get(Index).getDateTime());


        init();

        appstatus = GetAppStatus();
        App_Status_Adapter app_status_adapter = new App_Status_Adapter(Application_Status_Individual.this,appstatus);
        app_status_alistview.setAdapter(app_status_adapter);



    }

    private ArrayList<App_Status> GetAppStatus() {
        ArrayList<App_Status> list = new ArrayList<App_Status>();
        for (int i = 0; i < 7; i++) {
            App_Status obj = new App_Status();

            if (i == 0) {
                obj.setUser("Administrator");
                obj.setWorkflow("Creation");
                obj.setStatus("Open");
                obj.setDate("12-12-2017");
            } else if (i == 1) {
                obj.setUser("Administrator");
                obj.setWorkflow("Creation");
                obj.setStatus("Submit");
                obj.setDate("12-12-2017");
            } else if (i == 2) {
                obj.setUser("Administrator");
                obj.setWorkflow("Verify");
                obj.setStatus("Open");
                obj.setDate("12-12-2017");
            }else if (i == 3) {
                obj.setUser("Administrator");
                obj.setWorkflow("Verify");
                obj.setStatus("Submit");
                obj.setDate("12-12-2017");
            }else if (i == 4) {
                obj.setUser("Administrator");
                obj.setWorkflow("Approve");
                obj.setStatus("Open");
                obj.setDate("12-12-2017");
            }else if (i == 5) {
                obj.setUser("Administrator");
                obj.setWorkflow("Approve");
                obj.setStatus("Submit");
                obj.setDate("12-12-2017");
            }else if (i == 6) {
                obj.setUser("Administrator");
                obj.setWorkflow("Card Printing");
                obj.setStatus("Pending");
                obj.setDate("12-12-2017");
            }

            list.add(obj);
            obj=null;
        }

        return list;
    }

    private void init()
    {
        header_text=(TextView)findViewById(R.id.header_text);
        header_text.setText("Application Status");
    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(Application_Status_Individual.this, Application_Status.class);
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
            Intent i = new Intent(Application_Status_Individual.this, Application_Status.class);
            i.putExtra("value", 1);
            startActivity(i);
            finish();
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Intent i = new Intent(Application_Status_Individual.this, HomePage.class);
            startActivity(i);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}