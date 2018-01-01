package com.eps.smart_epds.Fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.eps.smart_epds.ConnectionDetector;
import com.eps.smart_epds.HomePage;
import com.eps.smart_epds.R;


public class Grievance_Other extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private EditText grievance_other_name,grievance_other_address,grievance_other_email,grievance_other_mobile,grievance_other_description;
    private Button grievance_other_summit,grievance_other_clear;

    public Grievance_Other() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.grievance_other, container, false);
        Init(view);
        return  view ;
    }
    private void Init(View view)
    {
        grievance_other_name=(EditText)view.findViewById(R.id.grievance_other_name);
//        grievance_other_name.setEnabled(false);
        grievance_other_address=(EditText)view.findViewById(R.id.grievance_other_address);
//        grievance_other_address.setEnabled(false);
        grievance_other_email=(EditText)view.findViewById(R.id.grievance_other_email);
//        grievance_other_email.setEnabled(false);
        grievance_other_mobile=(EditText)view.findViewById(R.id.grievance_other_mobile);
//        grievance_other_mobile.setEnabled(false);
        grievance_other_description=(EditText)view.findViewById(R.id.grievance_other_description);
//        grievance_other_description.setEnabled(false);

        grievance_other_summit=(Button)view.findViewById(R.id.grievance_other_summit);
        grievance_other_clear=(Button)view.findViewById(R.id.grievance_other_clear);
        grievance_other_clear.setOnClickListener(this);
        grievance_other_summit.setOnClickListener(this);

        grievance_other_name.setText("Vinay Kumar");
        grievance_other_email.setText("vinay@gmail.com");
        grievance_other_address.setText("RATNAM MARKET, Port Blair, South Andaman");
        grievance_other_mobile.setText("9827618819");
        grievance_other_description.setText("Ration card Detail not Correct.");

    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id)
        {
            case R.id.grievance_other_summit:
                if(grievance_other_summit.getText().toString().trim().equals("Save"))
                {
                    ConnectionDetector.ShowDialog("Data Saved Successfully.",getActivity());
                    grievance_other_summit.setText("Submit");
                }
                else
                 ShowDialog("Complaint registered successfully.\nYour Reference No. is 100007.",getActivity());
                break;
            case R.id.grievance_other_clear:
                grievance_other_name.setText("");
                grievance_other_email.setText("");
                grievance_other_address.setText("");
                grievance_other_mobile.setText("");
                grievance_other_description.setText("");

                break;
        }
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

        Button declinebutton = (Button) dialog.findViewById(R.id.declinebutton);
        declinebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        OkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
//                ShowDialog2(FPS_Change.this,"FPS Updated... Successfull\n   Your reference number is 100003");
//                finish();
                dialog.dismiss();
                Intent i = new Intent(getActivity(),HomePage.class);
                startActivity(i);

            }
        });
    }

}
