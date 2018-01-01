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
import android.widget.TextView;

import com.eps.smart_epds.Adapter.Weight_Measure_Adapter;
import com.eps.smart_epds.Model.Weight_Measure_Model;

import java.util.ArrayList;

/**
 * Created by lenovo on 12/4/2017.
 */

public class Weight_Measure extends AppCompatActivity
{
    Toolbar toolbar;
    ActionBar actionBar;
    Bundle bundle;
    TextView number;
    HorizontalScrollView horizontal_list;
    ListView listViewaddpart;
    ArrayList<Weight_Measure_Model> weight_measure_models = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_measure);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
        //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);

        listViewaddpart = (ListView) findViewById(R.id.listViewaddpart);

        horizontal_list = (HorizontalScrollView) findViewById(R.id.horizontal_list);
        number = (TextView) findViewById(R.id.hnumber);
        number.setText("Type");

        weight_measure_models = weight_measure_method();

        Weight_Measure_Adapter weight_measure_adapter = new Weight_Measure_Adapter(Weight_Measure.this,weight_measure_models);
        listViewaddpart.setAdapter(weight_measure_adapter);

    }

    private ArrayList<Weight_Measure_Model> weight_measure_method() {

        ArrayList<Weight_Measure_Model> data = new ArrayList<>();
        for(int i = 0;i<5;i++)
        {
            Weight_Measure_Model weight_measure_model = new Weight_Measure_Model();
            if(i==0)
            {
                weight_measure_model.setType("Electronic Balance");
                weight_measure_model.setLicense_no("241217");
                weight_measure_model.setIssue_date("25/01/2017");
                weight_measure_model.setExpiry_date("24/01/2018");
            }
            if(i==1)
            {
                weight_measure_model.setType("Weigh Bridge");
                weight_measure_model.setLicense_no("159543");
                weight_measure_model.setIssue_date("26/02/2017");
                weight_measure_model.setExpiry_date("25/02/2018");
            }
            if(i==2)
            {
                weight_measure_model.setType("Petrol Pump");
                weight_measure_model.setLicense_no("456856");
                weight_measure_model.setIssue_date("21/04/2017");
                weight_measure_model.setExpiry_date("20/04/2018");
            }
            if(i==3)
            {
                weight_measure_model.setType("Tank Lorry");
                weight_measure_model.setLicense_no("456856");
                weight_measure_model.setIssue_date("15/07/2017");
                weight_measure_model.setExpiry_date("14/07/2018");
            }
            if(i==4)
            {
                weight_measure_model.setType("Bullion Weight");
                weight_measure_model.setLicense_no("498972");
                weight_measure_model.setIssue_date("17/05/2017");
                weight_measure_model.setExpiry_date("16/05/2018");
            }
            data.add(weight_measure_model);

        }

        return data;
    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(Weight_Measure.this,HomePage.class);
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
            Intent i = new Intent(Weight_Measure.this,HomePage.class);
            i.putExtra("value",1);
            startActivity(i);
            finish();
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Intent i = new Intent(Weight_Measure.this,HomePage.class);
            startActivity(i);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
