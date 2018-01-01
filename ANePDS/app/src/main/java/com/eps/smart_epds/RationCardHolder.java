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
import android.widget.TextView;


public class RationCardHolder extends AppCompatActivity implements View.OnClickListener
{
    Toolbar toolbar;
    ActionBar actionBar;
    Bundle bundle;
    private CardView surrender_of_card,fps_change,address_change;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ration_card_activity);
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
        TextView header_text=(TextView)findViewById(R.id.header_text);
        header_text.setText("Ration Card Holder");
        surrender_of_card= (CardView) findViewById(R.id.surrender_of_card);
        fps_change= (CardView) findViewById(R.id.fps_change);
        address_change= (CardView) findViewById(R.id.address_change);

        surrender_of_card.setOnClickListener(this);
        fps_change.setOnClickListener(this);
        address_change.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(RationCardHolder.this,HomePage.class);
        i.putExtra("value",1);
        startActivity(i);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ration_card_menu, menu);
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
            Intent i = new Intent(RationCardHolder.this,HomePage.class);
            i.putExtra("value",1);
            startActivity(i);
            finish();
        }
     //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Intent i = new Intent(RationCardHolder.this,HomePage.class);
            startActivity(i);
            finish();
            return true;
        }
        if (id == R.id.fps_dealer_menu) {
            Intent i = new Intent(RationCardHolder.this,FPS_Activity.class);
            startActivity(i);
            finish();
            return true;
        }
        if (id == R.id.auto_texi_owner_menu) {
            Intent i = new Intent(RationCardHolder.this,AutoTaxi_Owner.class);
            startActivity(i);
            finish();
            return true;
        }
        if (id == R.id.wnm_menu) {
            Intent i = new Intent(RationCardHolder.this,Weight_Measure.class);
            startActivity(i);
            finish();
            return true;
        }if (id == R.id.grievance_menu) {
            Intent i = new Intent(RationCardHolder.this,Grievance.class);
            startActivity(i);
            finish();
            return true;
        }
        if (id == R.id.app_status_menu) {
            Intent i = new Intent(RationCardHolder.this,Application_Status.class);
            startActivity(i);
            finish();
            return true;
        }
        if (id == R.id.logout) {
            Intent i = new Intent(RationCardHolder.this,LoginActivity.class);
            startActivity(i);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id)
        {
            case R.id.surrender_of_card:
                Intent intent=new Intent(getApplicationContext(),Surrender_of_card.class);
                startActivity(intent);
                finish();
                break;

            case R.id.fps_change:

                Intent fps_intent=new Intent(getApplicationContext(),FPS_Change.class);
                startActivity(fps_intent);
                finish();
                break;

            case R.id.address_change:
                Intent address_intent=new Intent(getApplicationContext(),NewAddressChangeActivity.class);
                startActivity(address_intent);
                finish();
                break;
        }
    }
}
