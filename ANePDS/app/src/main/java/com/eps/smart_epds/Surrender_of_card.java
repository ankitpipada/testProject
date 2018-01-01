package com.eps.smart_epds;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.eps.smart_epds.Adapter.Complete_Surrender_Item_Adapter;

/**
 * Created by lenovo on 12/4/2017.
 */

public class Surrender_of_card extends AppCompatActivity implements View.OnClickListener
{
    Toolbar toolbar;
    ActionBar actionBar;
    Bundle bundle;
    private Button complete_surrender,partial_surrender;
    private TextView header_text;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surrender_card_activity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
        //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        Init();
    }

    private void Init()
    {
        header_text=(TextView)findViewById(R.id.header_text);
        header_text.setText("Surrender of Card");
        complete_surrender=(Button) findViewById(R.id.complete_surrender);
        partial_surrender=(Button)findViewById(R.id.partial_surrender);

        complete_surrender.setOnClickListener(this);
        partial_surrender.setOnClickListener(this);
    }


    @Override
    public void onBackPressed() {

        Intent i = new Intent(Surrender_of_card.this,RationCardHolder.class);
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
            Intent i = new Intent(Surrender_of_card.this,RationCardHolder.class);
            i.putExtra("value",1);
            startActivity(i);
            finish();
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Intent i = new Intent(Surrender_of_card.this,HomePage.class);
            startActivity(i);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        int id= view.getId();
        switch (id)
        {
            case R.id.complete_surrender:
                if(Complete_Surrender_Item_Adapter.Userinfo!=null && Complete_Surrender_Item_Adapter.Userinfo.size()>0)
                    Complete_Surrender_Item_Adapter.Userinfo.clear();
                Intent intent=new Intent(getApplicationContext(),CompleteSurrenderActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.partial_surrender:
                if(Complete_Surrender_Item_Adapter.Userinfo!=null && Complete_Surrender_Item_Adapter.Userinfo.size()>0)
                    Complete_Surrender_Item_Adapter.Userinfo.clear();
                Intent partialintent=new Intent(getApplicationContext(),PartialSurrenderActivity.class);
                startActivity(partialintent);
                finish();
                break;
        }
    }
}
