package com.eps.smart_epds;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by lenovo on 12/4/2017.
 */

public class HomePage extends AppCompatActivity implements View.OnClickListener
{
    Toolbar toolbar;
    ActionBar actionBar;
    Bundle bundle;
    LinearLayout ration_card_lyt,fps_dealer_lyt,auto_texi_lyt,weighrnmeasure_lyt,grievance_lyt,application_status_lyt;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.epds_services);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
     //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);

        Init();


    }

    private void Init()
    {
        ration_card_lyt=(LinearLayout)findViewById(R.id.ration_card_lyt);
        fps_dealer_lyt=(LinearLayout)findViewById(R.id.fps_dealer_lyt);
        auto_texi_lyt=(LinearLayout)findViewById(R.id.auto_texi_lyt);
        weighrnmeasure_lyt=(LinearLayout)findViewById(R.id.weighrnmeasure_lyt);
        grievance_lyt=(LinearLayout)findViewById(R.id.grievance_lyt);
        application_status_lyt=(LinearLayout)findViewById(R.id.application_status_lyt);

        ration_card_lyt.setOnClickListener(this);
        fps_dealer_lyt.setOnClickListener(this);
        auto_texi_lyt.setOnClickListener(this);
        weighrnmeasure_lyt.setOnClickListener(this);
        grievance_lyt.setOnClickListener(this);
        application_status_lyt.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {

        Custom_dialog_messge(HomePage.this,"Do you want to Logout?");
    }

   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.homepage_menu, menu);
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
            Intent i = new Intent(HomePage.this,MainActivity.class);
            i.putExtra("value",1);
            startActivity(i);
            finish();
        }
       //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Custom_dialog_messge(HomePage.this,"Do you want to Logout?");

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view) {
        int id= view.getId();
        switch (id)
        {
            case R.id.ration_card_lyt:
                Intent intent=new Intent( getApplicationContext(),RationCardHolder.class);
                startActivity(intent);
                finish();
                break;

            case R.id.fps_dealer_lyt:
                Intent fps_intent=new Intent( getApplicationContext(),FPS_Activity.class);
                startActivity(fps_intent);
                finish();
                break;

            case R.id.auto_texi_lyt:
                Intent auto_intent=new Intent( getApplicationContext(),AutoTaxi_Owner.class);
                startActivity(auto_intent);
                finish();
                break;

            case R.id.weighrnmeasure_lyt:
                Intent wnm_intent=new Intent( getApplicationContext(),Weight_Measure.class);
                startActivity(wnm_intent);
                finish();
                break;
//                show_dialog("Your mobile no. 9826098260 is not registered with Weight \u0026 Measures Module",HomePage.this);
//                break;

            case R.id.grievance_lyt:
                Intent grievance_intent=new Intent( getApplicationContext(),Grievance.class);
                startActivity(grievance_intent);
                finish();
                break;

            case R.id.application_status_lyt:
                Intent app_status_intent=new Intent( getApplicationContext(),Application_Status.class);
                startActivity(app_status_intent);
                finish();
                break;
        }
    }


    public void show_dialog(String message,Activity activity) {
        final Dialog dialog = new Dialog(activity);
        // Include dialog.xml file
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //before
        dialog.setContentView(R.layout.alert_dialog);
        // Set dialog title
        // set values for custom dialog components - text, image and button
        TextView text = (TextView) dialog.findViewById(R.id.textDialog);
        text.setGravity(Gravity.LEFT);
        text.setText(message);


        Button OkButton = (Button) dialog.findViewById(R.id.submitbutton);
        OkButton.setText("Ok");
        dialog.show();
        OkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
//                finish();
                dialog.dismiss();

            }
        });

    /*    Button CancelButton = (Button) dialog.findViewById(R.id.declinebutton);
        CancelButton.setText("Cancel");
        dialog.show();
        CancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
                dialog.dismiss();

            }
        });*/
        // if decline button is clicked, close the custom dialog

    }


    public void Custom_dialog_messge(Activity activity, String message) {
        final Dialog dialog = new Dialog(activity);
        // Include dialog.xml file
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //before
        dialog.setContentView(R.layout.custom_dialog);
        // Set dialog title
        // set values for custom dialog components - text, image and button
        TextView text = (TextView) dialog.findViewById(R.id.textDialog);

        text.setText(message);


        Button OkButton = (Button) dialog.findViewById(R.id.submitbutton);
        OkButton.setText("Ok");
        dialog.show();
        OkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
//                finishAffinity();
                dialog.dismiss();
                Intent i = new Intent(HomePage.this,LoginActivity.class);
                startActivity(i);
                finish();


            }
        });

        Button CancelButton = (Button) dialog.findViewById(R.id.declinebutton);
        CancelButton.setText("Cancel");
        dialog.show();
        CancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
                dialog.dismiss();

            }
        });
        // if decline button is clicked, close the custom dialog

    }
}
