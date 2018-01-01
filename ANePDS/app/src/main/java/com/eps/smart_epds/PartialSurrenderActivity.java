package com.eps.smart_epds;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.eps.smart_epds.Adapter.Complete_Surrender_Item_Adapter;
import com.eps.smart_epds.Model.UserDetail;

import java.util.ArrayList;

/**
 * Created by lenovo on 12/4/2017.
 */

public class PartialSurrenderActivity extends AppCompatActivity implements View.OnClickListener
{
    Toolbar toolbar;
    ActionBar actionBar;
    Bundle bundle;
    private Button proceed_complete_surrender,cancel_complete_surrender;
    private ListView card_holder_family_detail;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complete_surrender_activity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
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
        header_text.setText("Partial Surrender");

        proceed_complete_surrender=(Button)findViewById(R.id.proceed_complete_surrender);
        proceed_complete_surrender.setOnClickListener(this);

        cancel_complete_surrender=(Button)findViewById(R.id.cancel_complete_surrender);
        cancel_complete_surrender.setOnClickListener(this);
        card_holder_family_detail=(ListView)findViewById(R.id.card_holder_family_detail);


        Complete_Surrender_Item_Adapter adapter=new Complete_Surrender_Item_Adapter(getApplicationContext(),GetUserInfo(),2);
        card_holder_family_detail.setAdapter(adapter);
    }



    @Override
    public void onBackPressed() {

        Intent i = new Intent(PartialSurrenderActivity.this,Surrender_of_card.class);
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
            Intent i = new Intent(PartialSurrenderActivity.this,Surrender_of_card.class);
            i.putExtra("value",1);
            startActivity(i);
            finish();
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Intent i = new Intent(PartialSurrenderActivity.this,HomePage.class);
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
            case R.id.proceed_complete_surrender:

                if(Is_Check_Partial_Surrender()==true)
                ShowDialog(PartialSurrenderActivity.this,"Do you want to submit request for Partial Surrender of your Ration Card ?");
                else
                    ConnectionDetector.ShowDialog("Please select atleast One Member to Partially Surrender Ration Card",this);
                break;

            case R.id.cancel_complete_surrender:
                Intent i = new Intent(PartialSurrenderActivity.this,Surrender_of_card.class);
                i.putExtra("value",1);
                startActivity(i);
                finish();
                break;
        }
    }
    private boolean Is_Check_Partial_Surrender()
    {
        boolean is_status=false;
        if(Complete_Surrender_Item_Adapter.Userinfo!=null && Complete_Surrender_Item_Adapter.Userinfo.size()>0)
        {
            for(int i=0;i<Complete_Surrender_Item_Adapter.Userinfo.size();i++)
            {
                if(Complete_Surrender_Item_Adapter.Userinfo.get(i).is_Check()==true)
                {
                    is_status=true;
                }
            }
        }
        return  is_status;
    }


    public void ShowDialog(Activity activity, String message) {
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
                ShowDialog2(PartialSurrenderActivity.this,"Partial Surrender request submitted successfully.\nYour Reference No. is 100002");
//                finish();
                dialog.dismiss();

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


    public void ShowDialog2(Activity activity, String message) {
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

//                finish();

                //      ConnectionDetector.ShowDialog("Complete Surrender Successful.\nYour reference number is 4612358",CompleteSurrenderActivity.this);
                dialog.dismiss();
                Intent i = new Intent(PartialSurrenderActivity.this,HomePage.class);
                startActivity(i);


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

    private ArrayList<UserDetail> GetUserInfo()
    {
        ArrayList<UserDetail> list=new ArrayList<UserDetail>();
        for(int i=0;i<5;i++)
        {
            UserDetail obj=new UserDetail();
            if(i==0)
            {
                obj.setName("Anil");
                obj.setAge("57");
                obj.setRelation("HOF");
                obj.setGender("Male");
            }
            else if(i==1)
            {
                obj.setName("Puja");
                obj.setAge("52");
                obj.setRelation("Wife");
                obj.setGender("Female");
            }
            else if(i==2)
            {
                obj.setName("Sunil");
                obj.setAge("27");
                obj.setRelation("Son");
                obj.setGender("Male");
            }
            else if(i==3)
            {
                obj.setName("Shiv");
                obj.setAge("22");
                obj.setRelation("Son");
                obj.setGender("Male");
            }
            else if(i==4)
            {
                obj.setName("Devi");
                obj.setAge("23");
                obj.setRelation("Daughter");
                obj.setGender("Female");
            }
            obj.setIs_Check(true);
            list.add(obj);
            obj=null;

        }
        return  list;
    }
}
