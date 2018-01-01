package com.eps.smart_epds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Grievance_Track_activity extends AppCompatActivity implements View.OnClickListener{
    EditText grievance_track_mobile, grievance_track_tikit_no,grievance_track_name,grievance_track_addres,grievance_track_email,grievance_track_discription;
    Button grievance_track_getdata,clear_btn;
    TextView action,grievance_track_date,grievance_track_employee_name,grievance_track_status,grievance_track_action;
    TextView header_text;
    CardView ticket_detail_lyt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grievance_track_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);

        Init();


    }


    private void Init()
    {
        header_text=(TextView)findViewById(R.id.header_text);
        header_text.setText("Track");

        grievance_track_getdata=(Button)findViewById(R.id.grievance_track_getdata);
        grievance_track_getdata.setOnClickListener(this);

        grievance_track_date=(TextView)findViewById(R.id.grievance_track_date);
        grievance_track_employee_name=(TextView)findViewById(R.id.grievance_track_employee_name);
        grievance_track_status=(TextView)findViewById(R.id.grievance_track_status);
        grievance_track_action=(TextView)findViewById(R.id.grievance_track_action);

        grievance_track_mobile=(EditText) findViewById(R.id.grievance_track_mobile);
        grievance_track_tikit_no=(EditText) findViewById(R.id.grievance_track_tikit_no);
        grievance_track_name=(EditText)findViewById(R.id.grievance_track_name);
        grievance_track_addres=(EditText)findViewById(R.id.grievance_track_addres);
        grievance_track_email=(EditText)findViewById(R.id.grievance_track_email);
        grievance_track_discription=(EditText)findViewById(R.id.grievance_track_discription);
        ticket_detail_lyt=(CardView)findViewById(R.id.ticket_detail_lyt);
        ticket_detail_lyt.setVisibility(View.GONE);
        clear_btn=(Button)findViewById(R.id.clear_btn);
        clear_btn.setOnClickListener(this);
    }


    @Override
    public void onBackPressed() {

        Intent i = new Intent(Grievance_Track_activity.this,Grievance.class);
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
            Intent i = new Intent(Grievance_Track_activity.this,Grievance.class);
            i.putExtra("value",1);
            startActivity(i);
            finish();
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Intent i = new Intent(Grievance_Track_activity.this,HomePage.class);
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
            case R.id.clear_btn:
                grievance_track_name.setText("");
                grievance_track_addres.setText("");
                grievance_track_email.setText("");
                grievance_track_discription.setText("");
                grievance_track_mobile.setText("");
                ticket_detail_lyt.setVisibility(View.GONE);
                break;

            case R.id.grievance_track_getdata:
                String ticket=grievance_track_tikit_no.getText().toString();
                if(ticket.trim().equals("1"))
                {
                    grievance_track_name.setText("Vinay kumar");
                    grievance_track_addres.setText("RATNAM MARKET, Port Blair, South Andaman");
                    grievance_track_email.setText("vinay@gmail.com");
                    grievance_track_discription.setText("Order not Dispatch");
                    grievance_track_mobile.setText("9827618819");
                    ticket_detail_lyt.setVisibility(View.VISIBLE);
                }
                break;
        }
    }
}
