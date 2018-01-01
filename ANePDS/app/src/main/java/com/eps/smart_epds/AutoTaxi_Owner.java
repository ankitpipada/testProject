package com.eps.smart_epds;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.HorizontalScrollView;
import android.widget.ListView;

import com.eps.smart_epds.Adapter.Auto_Taxi_Adapter;
import com.eps.smart_epds.Model.Auto_Taxi;

import java.util.ArrayList;

/**
 * Created by lenovo on 12/4/2017.
 */

public class AutoTaxi_Owner extends AppCompatActivity
{
    Toolbar toolbar;
    ActionBar actionBar;
    Bundle bundle;
    HorizontalScrollView horizontal_list;
    ListView listViewaddpart;
    ArrayList<Auto_Taxi> auto_taxi = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autotaxi_owner);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
        //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);

        auto_taxi = autoTaxi_Data();

        horizontal_list = (HorizontalScrollView) findViewById(R.id.horizontal_list);
        listViewaddpart = (ListView) findViewById(R.id.listViewaddpart);
        Auto_Taxi_Adapter auto_taxi_adapter = new Auto_Taxi_Adapter(AutoTaxi_Owner.this,auto_taxi);
        listViewaddpart.setAdapter(auto_taxi_adapter);

    }

    private ArrayList<Auto_Taxi> autoTaxi_Data() {

        ArrayList<Auto_Taxi> data = new ArrayList<>();
        for(int i = 0;i<5;i++)
        {
            Auto_Taxi auto_taxi_model = new Auto_Taxi();
            if(i==0)
            {
                auto_taxi_model.setNumber("MP-09-CA-2017");
                auto_taxi_model.setLicense_no("241217");
                auto_taxi_model.setIssue_date("25/01/2017");
                auto_taxi_model.setExpiry_date("24/01/2018");
            }if(i==1)
            {
                auto_taxi_model.setNumber("MP-09-CA-2045");
                auto_taxi_model.setLicense_no("159543");
                auto_taxi_model.setIssue_date("26/02/2017");
                auto_taxi_model.setExpiry_date("25/02/2018");
            }if(i==2)
            {
                auto_taxi_model.setNumber("MP-09-CA-4598");
                auto_taxi_model.setLicense_no("456856");
                auto_taxi_model.setIssue_date("21/04/2017");
                auto_taxi_model.setExpiry_date("20/04/2018");
            }
            if(i==3)
            {
                auto_taxi_model.setNumber("MP-09-CA-3584");
                auto_taxi_model.setLicense_no("653915");
                auto_taxi_model.setIssue_date("15/07/2017");
                auto_taxi_model.setExpiry_date("14/07/2018");
            }if(i==4)
            {
                auto_taxi_model.setNumber("MP-09-CA-9546");
                auto_taxi_model.setLicense_no("498972");
                auto_taxi_model.setIssue_date("17/05/2017");
                auto_taxi_model.setExpiry_date("16/05/2018");
            }
            data.add(auto_taxi_model);

        }

        return data;
    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(AutoTaxi_Owner.this,HomePage.class);
        i.putExtra("value",1);
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
            Intent i = new Intent(AutoTaxi_Owner.this,HomePage.class);
            i.putExtra("value",1);
            startActivity(i);
            finish();
        }
       //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Intent i = new Intent(AutoTaxi_Owner.this,HomePage.class);
            startActivity(i);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
