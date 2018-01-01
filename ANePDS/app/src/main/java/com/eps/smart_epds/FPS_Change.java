package com.eps.smart_epds;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eps.smart_epds.Adapter.FPS_Change_Item_Adapter;
import com.eps.smart_epds.Interface.FPS_Check_Change_Listner;
import com.eps.smart_epds.Model.FPS_Detail;

import java.util.ArrayList;

/**
 * Created by lenovo on 12/4/2017.
 */

public class FPS_Change extends AppCompatActivity implements View.OnClickListener,FPS_Check_Change_Listner {
    Toolbar toolbar;
    ActionBar actionBar;
    Bundle bundle;
    private Button complete_surrender, partial_surrender;
    private TextView header_text;
    private ImageView search_fps;
    private ImageView next;
    private LinearLayout bottom_lyt;
    private EditText fps_code_et;
    private Button getdata;
    private TextView selected_fps_code,fps_name_txt,fps_address;
    private RelativeLayout search_fps_lyt;
    private LinearLayout selected_fps_detail;
    private  ArrayList<FPS_Detail> fps_list=new ArrayList<FPS_Detail>();
    private CheckBox check_status;
    private Button submit_fps,cancel_fps;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fps_change_activity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
        //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        fps_list=GetFPS_Detail();
        Init();
    }

    private void Init() {
        header_text = (TextView) findViewById(R.id.header_text);
        header_text.setText("FPS Change");
        search_fps = (ImageView) findViewById(R.id.search_fps);
        search_fps.setOnClickListener(this);
        search_fps_lyt = (RelativeLayout) findViewById(R.id.search_fps_lyt);
        search_fps_lyt.setOnClickListener(this);
        fps_code_et=(EditText)findViewById(R.id.fps_code_et);
        getdata=(Button) findViewById(R.id.getdata);
        getdata.setOnClickListener(this);
        bottom_lyt=(LinearLayout)findViewById(R.id.bottom_lyt);
        selected_fps_detail=(LinearLayout) findViewById(R.id.selected_fps_detail);
        selected_fps_detail.setVisibility(View.GONE);

//        check_status=(CheckBox)findViewById(R.id.check_status);


        submit_fps=(Button) findViewById(R.id.submit_fps);
        cancel_fps=(Button) findViewById(R.id.cancel_fps);
        cancel_fps.setOnClickListener(this);
        submit_fps.setOnClickListener(this);
//        next= (ImageView) findViewById(R.id.next);
//        next.setVisibility(View.GONE);

        fps_code_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                selected_fps_detail.setVisibility(View.GONE);
                bottom_lyt.setVisibility(View.GONE);
            }
        });

        selected_fps_code=(TextView)findViewById(R.id.selected_fps_code);
        fps_name_txt=(TextView)findViewById(R.id.fps_name_txt);
        fps_address=(TextView)findViewById(R.id.fps_address);
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager)getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(fps_code_et.getWindowToken(), 0);
    }
    @Override
    public void onBackPressed() {

        Intent i = new Intent(FPS_Change.this, RationCardHolder.class);
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
            Intent i = new Intent(FPS_Change.this, RationCardHolder.class);
            i.putExtra("value", 1);
            startActivity(i);
            finish();
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Intent i = new Intent(FPS_Change.this, HomePage.class);
            startActivity(i);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.search_fps_lyt:
                FPS_Selection_Dialog_box(FPS_Change.this,"Please Select FPS ",GetFPS_Detail());
                break;

            case R.id.getdata:
                hideKeyboard();
                String Code=fps_code_et.getText().toString();
                int id_index=GetFPSInformation(GetFPS_Detail(),Code);
                if(id_index!=-1) {
                    selected_fps_code.setText(fps_list.get(id_index).getCode());
                    fps_name_txt.setText(fps_list.get(id_index).getName());
                    fps_address.setText(fps_list.get(id_index).getAddress());
                    selected_fps_detail.setVisibility(View.VISIBLE);
                    bottom_lyt.setVisibility(View.VISIBLE);
//                    check_status.setChecked(true);
                }
                else
                {
                    ConnectionDetector.ShowDialog("Please Enter Valid FPS Code",this);
                }
                break;

            case R.id.submit_fps:

//                if(check_status.isChecked()==true)
//                {
                    String code=selected_fps_code.getText().toString();
                    String Name=fps_name_txt.getText().toString();
                    String Address=fps_address.getText().toString();
                    SubmitButton_ShowDialog("Do you want to Update FPS\nFPS Code : "+code+"\n"+"FPS Name : "+Name+"\n"+"Address : "+Address,this);
//                }
//                else
//                {
//                    ConnectionDetector.ShowDialog("Please Check Selected FPS ",this);
//                }
                break;

            case R.id.cancel_fps:
                Intent intent=new Intent(getApplicationContext(),RationCardHolder.class);
                startActivity(intent);
                finish();
                break;
        }
    }
    public void SubmitButton_ShowDialog(String message,Activity activity) {
        final Dialog dialog = new Dialog(activity);
        // Include dialog.xml file
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //before
        dialog.setContentView(R.layout.custom_dialog);
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
               ShowDialog2(FPS_Change.this,"FPS changed successfully.\nYour Reference No. is 100003");
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
                Intent i = new Intent(FPS_Change.this,HomePage.class);
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


    //    TODO FPS SELECTION POPUP
    public void FPS_Selection_Dialog_box(Activity activity, String message, final ArrayList<FPS_Detail> list) {
        final Dialog dialog = new Dialog(activity);
        // Include dialog.xml file
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //before
        dialog.setContentView(R.layout.fps_selection_dialog);
        // Set dialog title
        // set values for custom dialog components - text, image and button
        TextView text = (TextView) dialog.findViewById(R.id.textheader);
        ImageView cancel= (ImageView) dialog.findViewById(R.id.cancel);
        text.setText(message);

        ListView fps_list=(ListView)dialog.findViewById(R.id.fps_list) ;
        FPS_Change_Item_Adapter adapter=new FPS_Change_Item_Adapter(FPS_Change.this,getApplicationContext(),list,0) ;
        fps_list.setAdapter(adapter);
        // if decline button is clicked, close the custom dialog
        fps_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selected_fps_code.setText(list.get(i).getCode());
                fps_name_txt.setText(list.get(i).getName());
                fps_address.setText(list.get(i).getAddress());
                selected_fps_detail.setVisibility(View.VISIBLE);
                bottom_lyt.setVisibility(View.VISIBLE);
//                check_status.setChecked(true);
                dialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private int GetFPSInformation(ArrayList<FPS_Detail> FPSDetail,String Code)
    {
        int Index=-1;
        if(FPSDetail!=null && FPSDetail.size()>0)
        {
            for(int i=0;i<FPSDetail.size();i++)
            {
                if(FPSDetail.get(i).getCode().trim().equals(Code))
                {
                    Index=i;
                }
            }
        }
        return  Index;
    }
/*

    private ArrayList<FPS_Detail> GetFPS_Detail() {
        ArrayList<FPS_Detail> FpsList = new ArrayList<FPS_Detail>();
        for(int i=0;i<5;i++)
        {
            FPS_Detail obj=new FPS_Detail();
            if(i==0)
            {
                obj.setName("Amit Traders");
                obj.setCode("1");
                obj.setAddress("41/2 vijay nagar main road Indore (Mp)");
            }
            if(i==1)
            {
                obj.setName("Brajesh kumar");
                obj.setCode("2");
                obj.setAddress("22 New Road indore (Mp)");
            }
            if(i==2)
            {
                obj.setName("Dinesh kumar");
                obj.setCode("3");
                obj.setAddress("72 Raj nagar Indore (Mp)");
            }
            if(i==3)
            {
                obj.setName("Kapil kumar");
                obj.setCode("4");
                obj.setAddress("41/2 Station road indore (Mp)");
            }
            if(i==4)
            {
                obj.setName("Amit kumar");
                obj.setCode("5");
                obj.setAddress("5/2 Bus stand road indore (Mp)");
            }
            FpsList.add(obj);
            obj=null;
        }
        return FpsList;
    }
*/

    @Override
    public void FPS_Change_listner(ArrayList<FPS_Detail> list) {

    }
    private ArrayList<FPS_Detail> GetFPS_Detail() {
        ArrayList<FPS_Detail> FpsList = new ArrayList<FPS_Detail>();
        for(int i=0;i<50;i++)
        {
            FPS_Detail obj=new FPS_Detail();
            obj.setName(FPS_Name[i]);
            obj.setCode(""+FPS_CODE[i]);
            obj.setAddress(Address[i]);
            FpsList.add(obj);
            obj=null;
        }
        return FpsList;
    }


    private int [] FPS_CODE={1,
            2,
            4,
            6,
            7,
            8,
            14,
            15,
            18,
            19,
            21,
            23,
            24,
            25,
            26,
            30,
            32,
            33,
            34,
            36,
            37,
            38,
            39,
            40,
            43,
            44,
            46,
            49,
            55,
            59,
            62,
            68,
            69,
            70,
            84,
            85,
            92,
            93,
            115,
            124,
            127,
            131,
            134,
            135,
            136,
            138,
            139,
            143,
            144,
            146
    };

    private String [] FPS_Name={
            "OM SARAVANA TRADERS",
            "SUNDER MOORTHY",
            "RAGHBIR SINGH",
            "MS SARAVANA LUCKY STORES",
            "MS SHANKER GENERAL STORE",
            "CONSUMERS COOP. SOCIETY LTD",
            "GURUAMMA",
            "M/S ERATTAI SWAMY TRADERS",
            "NAJIMA BEGUM",
            "CONSUMER COOP STORES LTD",
            "M/S SREENARAYAN SINGH",
            "SRI LAXMI TRADERS",
            "MS DHANA LAXMI STORES",
            "MS ARUN SINGH",
            "C.C.S LTD.",
            "MS RAJAN STORE",
            "MS K.MUTHU  CO.",
            "SMTI B.RAJESWARI",
            "POLICE WELFARE ASSOCIATION",
            "KAMACHI",
            "JEEVAN RAM STORE",
            "MS ADIAPPAN  SONS",
            "CONSUMERS COOP.SOCIETY",
            "MS DADA BHOY STORE",
            "CONSUMERS COOP.STORES",
            "MS HI LAND SUPER MARKET",
            "MS V.NADESHAN",
            "SHRI T GOVINDA SWAMY",
            "SHRI U SELVAM",
            "MS. S AYSHA",
            "SHRI PARICHAT SINGH",
            "P P ABDULLA  KUTTY",
            "SHRI K. MUTHU RAMAN",
            "SMTI GOURI DEBNATH",
            "SHRI SHANKER BAGCHI",
            "MS B JAYA PANDY",
            "S. VASANTHA",
            "MS M.A.ABDULWAHAB",
            "THE CONSUMERS COOP STORES",
            "C.C.S.LTD HAVELOCK",
            "MS RABBAKKAL",
            "MS. SULOCHANA MONDAL",
            "MS. V.VELUVALLI",
            "K MEENAKSHI",
            "MS L.BAL RAJ",
            "MS J.ROBIN",
            "IMTIAZ STORE",
            "MS. S.NITHYANANTHAM",
            "MS. SAJID ALI",
            "K. SIVANANDA RAJ"
    };


    private String[] FPS_OWNER={
                    "G KARMEGAM" ,
                    "SUNDER MOORTHY" ,
                    "RAGHBIR SINGH" ,
                    "S.VELU" ,
                    "SHANKER" ,
                    "MANAGER" ,
                    "GURUAMMA" ,
                    "ERATTAI SWAMY" ,
                    "NAJIMA BEGUM" ,
                    "MANAGER" ,
                    "SREENARAYAN SINGH" ,
                    "N CHANDRA PRAKASM" ,
                    "M BOSE" ,
                    "ARUN SINGH" ,
                    "MANAGER" ,
                    "RAJAN STORE" ,
                    "K.MUTHU" ,
                    "B.RAJESWARI" ,
                    " POLICE WELFARE ASSOCIATION" ,
                    "KAMACHI" ,
                    "JEEVAN RAM" ,
                    "ADIAPPAN" ,
                    "MANAGER" ,
                    "JULFKAR DEEN" ,
                    "MANAGER" ,
                    "V.KUNJU" ,
                    "V.NADESHAN" ,
                    "T GOVINDA SWAMY" ,
                    "SHRI U SELVAM" ,
                    "S AYSHA" ,
                    "PARICHAT SINGH" ,
                    "P P ABDULLA  KUTTY" ,
                    "K. MUTHU RAMAN" ,
                    "GOURI DEBNATH" ,
                    "SHANKER BAGCHI" ,
                    "B JAYA PANDY",
                    "S.VASANTHA" ,
                    "M A. ABDULWAHAB",
                    "MANAGER" ,
                    "MANAGER" ,
                    "RABBAKKAL" ,
                    "SULOCHANA MONDAL" ,
                    "V.VELUVALLI" ,
                    "K MEENAKSHI" ,
                    "L.BAL RAJ" ,
                    "J.ROBIN" ,
                    "SHRI.IMTIAZ AHMED" ,
                    "S.NITHYANANTHAM" ,
                    "SAJID ALI" ,
                    "K. SIVANANDA RAJ"
    };

    private String[] Address={"RATNAM MARKET, Port Blair, South Andaman",
            "DAIRY FARM PS MILL , Port Blair, South Andaman" ,
            "ABERDEEN BAZAR, Port Blair, South Andaman" ,
            "BATHU BASTHI , Port Blair, South Andaman" ,
            "PROTHRAPUR, Port Blair, South Andaman",
            "ABERDEEN BAZAR , Port Blair, South Andaman" ,
            "NAYAGAON , Port Blair, South Andaman" ,
            "ABERDEEN BAZAR , Port Blair, South Andaman",
            "DELANIPUR, Port Blair, South Andaman",
            "HADDO, Port Blair, South Andaman",
            "DELANIPUR, Port Blair, South Andaman",
            "BABU LANE, Port Blair, South Andaman" ,
            "SHADIPUR, Port Blair, South Andaman",
            "DAIRY FARM, Port Blair, South Andaman",
            "SHADIPUR, Port Blair, South Andaman" ,
            "DAIRY FARM, Port Blair, South Andaman" ,
            "PROTHRAPUR , Port Blair, South Andaman",
            "ABERDEEN BAZAR, Port Blair, South Andaman" ,
            "POLICE LINE, Port Blair, South Andaman" ,
            "DOLLY GUNJ, Port Blair, South Andaman",
            "BRICH GUNJ, Port Blair, South Andaman" ,
            "ABERDEEN BAZAR, Port Blair, South Andaman" ,
            "NEIL ISLAND, Port Blair, South Andaman" ,
            "HADDO, Port Blair, South Andaman" ,
            "GARACHARAMA, Port Blair, South Andaman" ,
            "HAVElOCK, Port Blair, South Andaman" ,
            "PREM NAGAR, Port Blair, South Andaman" ,
            "Garacharma, Port Blair, South Andaman" ,
            "MAZAR PAHAR, Port Blair, South Andaman" ,
            "CALICUT, Port Blair, South Andaman" ,
            "JUNGLIGHAT, Port Blair, South Andaman",
            "PREM NAGAR, Port Blair, South Andaman",
            "GARACHARAMA, Port Blair, South Andaman",
            "HAVELOCK NO.1, Port Blair, South Andaman",
            "Buniyadabad, Port Blair, South Andaman" ,
            "ABERDEEN BAZAAR, Port Blair, South Andaman" ,
            "BATHU BASTHI, Port Blair, South Andaman",
            "DELANIPUR, Port Blair, South Andaman",
            "DELANIPUR  1, Port Blair, South Andaman" ,
            "GOVIND NAGAR, Port Blair, South Andaman",
            "KAMRAJ NAGAR, Port Blair, South Andaman" ,
            "MAZAR PAHAD, Port Blair, South Andaman" ,
            "GARACHARMA, Port Blair, South Andaman" ,
            "AUSTINABAD, Port Blair, South Andaman" ,
            "KAMRAJ NAGAR, Port Blair, South Andaman," ,
            "NEW BIMBLITAN, Port Blair, South Andaman" ,
            "AUSTINABAD, Port Blair, South Andaman",
            "GARACHARMA, Port Blair, South Andaman" ,
            "LAMBA LINE, Port Blair, South Andaman",
            "BURMANALLAH, Port Blair, South Andaman"};
}
