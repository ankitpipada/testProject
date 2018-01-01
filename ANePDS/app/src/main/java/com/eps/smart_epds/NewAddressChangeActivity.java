package com.eps.smart_epds;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class NewAddressChangeActivity extends AppCompatActivity {
    String[] districtarr = new String[]{"---- Please Select District--------", "South Andaman",
            "North", "Middle Andaman",
            "Nicobars"
    };
    String[] teharr = new String[]{"---- Please Select Tehsil--------", "South Andaman", "Port Blair", "Ferrargunj", " Little Andaman"};
    String[] state_arr = new String[]{"---- Please Select State--------", " Andaman & Nicobar Islands"};
    Spinner disttSpinner, tehSpinner, statespin, permanentdisttspnr, permanent_teh_spnr, permanent_state_spn, previous_dist_spn, previous_teh_spn, previous_state_spin;
    ImageView up_btn_present, right_btn_present, up_btn_permanant, up_btn_previous, right_btn_permanent, right_btn_previous;
    CardView card_arrow_right_presnt,card_arrow_right_permnt,card_arrow_right__previous;

    CardView present_addres, permanent_addres, previous_addres;
    CheckBox same_as_present, same_as_presnt_for_prvous, same_permanent;

    EditText houseno_present, locality_present, village_presnt, wardno_presnt, pincode_present;
    EditText houseno_permanent, locality_permanent, village_permanent, wardno_permanent, pincode_permanent;
    EditText houseno_previous, locality_previous, village_previous, wardno_previous, pincode_previous;
    Button editbtn, submit_btn, cancel_btn;
    TextView header_text;
    private Toolbar toolbar;
    private ActionBar actionBar;
    private RelativeLayout new_present_lyt,new_permanent_lyt,new_previous_lyt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_address_change);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
        //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);

        new_present_lyt = (RelativeLayout) findViewById(R.id.present_lyt);
        new_permanent_lyt = (RelativeLayout) findViewById(R.id.permanent_lyt);
        new_previous_lyt = (RelativeLayout) findViewById(R.id.previous_lyt);

        disttSpinner = (Spinner) findViewById(R.id.district);
        tehSpinner = (Spinner) findViewById(R.id.tehseelspn);
        statespin = (Spinner) findViewById(R.id.state_spn);
        header_text = (TextView) findViewById(R.id.header_text);
        header_text.setText("Address Change");
        permanentdisttspnr = (Spinner) findViewById(R.id.district_permanetn);
        permanent_teh_spnr = (Spinner) findViewById(R.id.tehseelspn_permanent);
        permanent_state_spn = (Spinner) findViewById(R.id.state_spn_permanent);
        previous_dist_spn = (Spinner) findViewById(R.id.district_previous);
        previous_state_spin = (Spinner) findViewById(R.id.state_spn_previous);
        previous_teh_spn = (Spinner) findViewById(R.id.tehseelspn_previous);


        //imagebutton

        up_btn_permanant = (ImageView) findViewById(R.id.arrow_up_permnt);
        up_btn_present = (ImageView) findViewById(R.id.arrow_up_presnt);
        up_btn_previous = (ImageView) findViewById(R.id.arrow_up_previous);
        right_btn_present = (ImageView) findViewById(R.id.arrow_right_presnt);
        right_btn_permanent = (ImageView) findViewById(R.id.arrow_right_permnt);
        right_btn_previous = (ImageView) findViewById(R.id.arrow_right__previous);

        // checkBox
        same_as_present = (CheckBox) findViewById(R.id.same_present);
        same_as_presnt_for_prvous = (CheckBox) findViewById(R.id.same_presnt_for_previous);
        same_permanent = (CheckBox) findViewById(R.id.same_as_permanent);

        //layouts
        present_addres = (CardView) findViewById(R.id.present_addres_ll);
        permanent_addres = (CardView) findViewById(R.id.premanen_add_ll);
        previous_addres = (CardView) findViewById(R.id.previous_address_ll);

        editbtn = (Button) findViewById(R.id.edit_save_button);
        submit_btn = (Button) findViewById(R.id.submit_btn);
        cancel_btn = (Button) findViewById(R.id.cancel_btn);




        new_present_lyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                up_btn_present.setVisibility(View.VISIBLE);
                right_btn_present.setVisibility(View.GONE);
                present_addres.setVisibility(View.VISIBLE);
            }
        });

        up_btn_present.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                up_btn_present.setVisibility(View.GONE);
                right_btn_present.setVisibility(View.VISIBLE);
                present_addres.setVisibility(View.GONE);
            }
        });

        new_permanent_lyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                up_btn_permanant.setVisibility(View.VISIBLE);
                right_btn_permanent.setVisibility(View.GONE);
                permanent_addres.setVisibility(View.VISIBLE);
                same_as_present.setVisibility(View.VISIBLE);
            }
        });
        up_btn_permanant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                up_btn_permanant.setVisibility(View.GONE);
                right_btn_permanent.setVisibility(View.VISIBLE);
                permanent_addres.setVisibility(View.GONE);
                same_as_present.setVisibility(View.GONE);
            }
        });

        new_previous_lyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                right_btn_previous.setVisibility(View.GONE);
                up_btn_previous.setVisibility(View.VISIBLE);
                previous_addres.setVisibility(View.VISIBLE);
                same_permanent.setVisibility(view.GONE);
                same_as_presnt_for_prvous.setVisibility(View.GONE);
            }
        });
        up_btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                right_btn_previous.setVisibility(View.VISIBLE);
                up_btn_previous.setVisibility(View.GONE);
                previous_addres.setVisibility(View.GONE);
                same_permanent.setVisibility(view.GONE);
                same_as_presnt_for_prvous.setVisibility(View.GONE);
            }
        });
        same_as_presnt_for_prvous.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    same_permanent.setChecked(false);
                    same_as_presnt_for_prvous.setChecked(true);
                }
            }
        });
        same_permanent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    same_permanent.setChecked(true);
                    same_as_presnt_for_prvous.setChecked(false);
                }
            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item_layout, districtarr);
        ArrayAdapter<String> teh_adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item_layout, teharr);
        disttSpinner.setAdapter(adapter);
        tehSpinner.setAdapter(teh_adapter);
        permanentdisttspnr.setAdapter(adapter);
        permanent_teh_spnr.setAdapter(teh_adapter);
        previous_dist_spn.setAdapter(adapter);
        previous_teh_spn.setAdapter(teh_adapter);

        ArrayAdapter<String> stateAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item_layout, state_arr);
        statespin.setAdapter(stateAdapter);
        permanent_state_spn.setAdapter(stateAdapter);
        previous_state_spin.setAdapter(stateAdapter);

        init();
    }

    private void init() {
        // edittext present



       /* present_lyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
        /*permanent_lyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/

     /*   previous_lyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
        houseno_present = (EditText) findViewById(R.id.presenr_house_no);
        locality_present = (EditText) findViewById(R.id.present_locality);
        village_presnt = (EditText) findViewById(R.id.present_village);
        wardno_presnt = (EditText) findViewById(R.id.present_wardno);
        pincode_present = (EditText) findViewById(R.id.present_pincode);

        //permanent edittext

        houseno_permanent = (EditText) findViewById(R.id.premanent_house_no);
        locality_permanent = (EditText) findViewById(R.id.premanent_locality);
        village_permanent = (EditText) findViewById(R.id.premanent_village);
        wardno_permanent = (EditText) findViewById(R.id.premanent_wardno);
        pincode_permanent = (EditText) findViewById(R.id.permanent_pincode);

        //previous edittext

        houseno_previous = (EditText) findViewById(R.id.previous_house_no);
        houseno_previous.setEnabled(false);
        locality_previous = (EditText) findViewById(R.id.previous_locality);
        locality_previous.setEnabled(false);
        village_previous = (EditText) findViewById(R.id.previous_village);
        village_previous.setEnabled(false);
        wardno_previous = (EditText) findViewById(R.id.previous_wardno);
        wardno_previous.setEnabled(false);
        pincode_previous = (EditText) findViewById(R.id.previous_pincode);
        pincode_previous.setEnabled(false);


        houseno_present.setText("235");
        locality_present.setText("RATNAM MARKET, Port Blair, South Andaman");
        village_presnt.setText("Port blair (MCI)");
        wardno_presnt.setText("0048");
        pincode_present.setText("744101");
        disttSpinner.setSelection(1);
        tehSpinner.setSelection(2);
        statespin.setSelection(1);

        houseno_permanent.setText("235");
        locality_permanent.setText("RATNAM MARKET, Port Blair, South Andaman");
        village_permanent .setText("Port blair (MCI)");
        wardno_permanent .setText("0048");
        pincode_permanent.setText("744101");
        permanentdisttspnr.setSelection(1);
        permanent_teh_spnr.setSelection(2);
        permanent_state_spn.setSelection(1);

        houseno_previous.setText("235");
        locality_previous.setText("RATNAM MARKET, Port Blair, South Andaman");
        village_previous .setText("Port blair (MCI)");
        wardno_previous .setText("0048");
        pincode_previous.setText("744101");
        previous_dist_spn.setSelection(1);
        previous_teh_spn.setSelection(2);
        previous_state_spin.setSelection(1);;

        editbtn.setVisibility(View.GONE);
        editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editbtn.getText().toString().trim().equals("Edit")) {
                    editbtn.setText("Save");
                    houseno_present.setFocusable(true);
                    houseno_present.setEnabled(true);
                    locality_present.setFocusable(true);
                    locality_present.setEnabled(true);
                    village_presnt.setFocusable(true);
                    village_presnt.setEnabled(true);
                    wardno_presnt.setFocusable(true);
                    wardno_presnt.setEnabled(true);
                    pincode_present.setFocusable(true);
                    pincode_present.setEnabled(true);
                    disttSpinner.setFocusable(true);
                    disttSpinner.setEnabled(true);
                    tehSpinner.setFocusable(true);
                    tehSpinner.setEnabled(true);
                    statespin.setFocusable(true);
                    statespin.setEnabled(true);
                } else {
                    houseno_present.setFocusable(false);
                    houseno_present.setEnabled(false);
                    locality_present.setFocusable(false);
                    locality_present.setEnabled(false);
                    village_presnt.setFocusable(false);
                    village_presnt.setEnabled(false);
                    wardno_presnt.setFocusable(false);
                    wardno_presnt.setEnabled(false);
                    pincode_present.setFocusable(false);
                    pincode_present.setEnabled(false);
                    disttSpinner.setFocusable(false);
                    disttSpinner.setEnabled(false);
                    tehSpinner.setFocusable(false);
                    tehSpinner.setEnabled(false);
                    statespin.setFocusable(false);
                    statespin.setEnabled(false);
                    ConnectionDetector.ShowDialog("Present Address Data saved Successfully", NewAddressChangeActivity.this);
                }

            }
        });


        same_as_present.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                String Houseno = houseno_present.getText().toString();
                String locality = locality_present.getText().toString();
                String Village = village_presnt.getText().toString();
                String wardno = wardno_presnt.getText().toString();
                String Pincode = pincode_present.getText().toString();
                int district = disttSpinner.getSelectedItemPosition();
                int tehseel = tehSpinner.getSelectedItemPosition();
                ;
                int state = statespin.getSelectedItemPosition();
                ;


                permanentdisttspnr.setSelection(district);
                permanent_teh_spnr.setSelection(tehseel);
                permanent_state_spn.setSelection(state);
                houseno_permanent.setText(Houseno);
                locality_permanent.setText(locality);
                village_permanent.setText(Village);
                wardno_permanent.setText(wardno);
                pincode_permanent.setText(Pincode);

            }
        });
        same_as_presnt_for_prvous.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    same_permanent.setChecked(false);
                    same_as_presnt_for_prvous.setChecked(true);
                }


                String Houseno = houseno_present.getText().toString();
                String locality = locality_present.getText().toString();
                String Village = village_presnt.getText().toString();
                String wardno = wardno_presnt.getText().toString();
                String Pincode = pincode_present.getText().toString();
                int district = disttSpinner.getSelectedItemPosition();
                int tehseel = tehSpinner.getSelectedItemPosition();
                ;
                int state = statespin.getSelectedItemPosition();
                ;


                houseno_previous.setText(Houseno);
                locality_previous.setText(locality);
                village_previous.setText(Village);
                wardno_previous.setText(wardno);
                pincode_previous.setText(Pincode);
                previous_dist_spn.setSelection(district);
                previous_teh_spn.setSelection(tehseel);
                previous_state_spin.setSelection(state);
            }
        });
        same_permanent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    same_permanent.setChecked(true);
                    same_as_presnt_for_prvous.setChecked(false);
                }

                String Houseno = houseno_permanent.getText().toString();
                String locality = locality_permanent.getText().toString();
                String Village = village_permanent.getText().toString();
                String wardno = wardno_permanent.getText().toString();
                String Pincode = pincode_permanent.getText().toString();
                int district = permanentdisttspnr.getSelectedItemPosition();
                int tehseel = permanent_teh_spnr.getSelectedItemPosition();
                ;
                int state = permanent_state_spn.getSelectedItemPosition();
                ;


                houseno_previous.setText(Houseno);
                locality_previous.setText(locality);
                village_previous.setText(Village);
                wardno_previous.setText(wardno);
                pincode_previous.setText(Pincode);
                previous_dist_spn.setSelection(district);
                previous_teh_spn.setSelection(tehseel);
                previous_state_spin.setSelection(state);
            }
        });

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = submit_btn.getText().toString();
                if (text.trim().equals("Save")) {
                    submit_btn.setText("Submit");
                    ConnectionDetector.ShowDialog("Address Updated Successfully", NewAddressChangeActivity.this);

                }
                else
                    ShowDialog("Address Saved Successfully\nYour reference number is 100004", NewAddressChangeActivity.this);
            }
        });
        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RationCardHolder.class);
                startActivity(intent);
                finish();
            }
        });


    }


    public void ShowDialog(String message,Activity activity) {
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
//                ShowDialog2(FPS_Change.this,"FPS Updated... Successfull\n   Your reference number is 100003");
//                finish();
                dialog.dismiss();
//                submit_btn.setText("Submit");
                Intent i = new Intent(NewAddressChangeActivity.this,HomePage.class);
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

    @Override
    public void onBackPressed() {

        Intent i = new Intent(NewAddressChangeActivity.this, RationCardHolder.class);
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
            Intent i = new Intent(NewAddressChangeActivity.this, RationCardHolder.class);
            i.putExtra("value", 1);
            startActivity(i);
            finish();
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Intent i = new Intent(NewAddressChangeActivity.this, HomePage.class);
            startActivity(i);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
