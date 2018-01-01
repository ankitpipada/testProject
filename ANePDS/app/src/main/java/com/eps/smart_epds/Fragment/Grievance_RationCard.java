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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.eps.smart_epds.ConnectionDetector;
import com.eps.smart_epds.HomePage;
import com.eps.smart_epds.R;


public class Grievance_RationCard extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private Spinner complaint_by,grivance_type;
    private EditText graievance_ration_email,graievance_ration_mobileno,graievance_ration_decription;
    private Button btn_submit,btn_clear;
   // String[] Grievance_type = new String[]{"---- Please Select Grievance Type--------", "South Andaman", "Port Blair", "Ferrargunj", " Little Andaman"};
    String[] Complaint_by = new String[]{"---- Complaint by--------", " Arvind","Amit","Rajesh","Mena","Sonu"};

    String[] Grievance_type = new String[]{"---- Please Select Grievance Type--------",
            "Non-compliance of time lines" ,
            "Non-consideration of request",
            "Service mechanism of CSC" ,
            "Delivery of short quantity of PDS articles" ,
            "Sub-standard quality of PDS ARTICLES" ,
            "Non-availability of ration articles in the FPS" ,
            "Non-furnsihing bill /voucher of PDS articles FROM fps" ,
            "Non-registration of ration card with the FPS" ,
            "Denial to issue PDS articles by the FPS" ,
            "Non-receipt of SMS alert" ,
            "Non-display of Ration card information on the portal"};
    public Grievance_RationCard() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void init(View view)
    {
        complaint_by=(Spinner)view.findViewById(R.id.graievance_ration_complient_by);
//        complaint_by.setEnabled(false);
        grivance_type=(Spinner)view.findViewById(R.id.grivance_type);
//        grivance_type.setEnabled(false);

        ArrayAdapter<String> Grievance_type_adapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item_layout, Grievance_type);
        ArrayAdapter<String> Complaint_by_adapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item_layout, Complaint_by);


        complaint_by.setAdapter(Complaint_by_adapter);
        grivance_type.setAdapter(Grievance_type_adapter);

        graievance_ration_email=(EditText) view.findViewById(R.id.graievance_ration_email);
//        graievance_ration_email.setEnabled(false);
        graievance_ration_mobileno=(EditText) view.findViewById(R.id.graievance_ration_mobileno);
//        graievance_ration_mobileno.setEnabled(false);
        graievance_ration_decription=(EditText) view.findViewById(R.id.graievance_ration_decription);
//        graievance_ration_decription.setEnabled(false);
        graievance_ration_email=(EditText) view.findViewById(R.id.graievance_ration_email);

        btn_submit=(Button) view.findViewById(R.id.btn_submit);
        btn_clear=(Button) view.findViewById(R.id.btn_clear);

        btn_submit.setOnClickListener(this);
        btn_clear.setOnClickListener(this);


        graievance_ration_email.setText("gkaregam@gmail.com");
        graievance_ration_mobileno.setText("9827618819");
        graievance_ration_decription.setText("Ration card detail not include");
        complaint_by.setSelection(2);
        grivance_type.setSelection(2);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.grievance_rationcard, container, false);
        init(view);
        return view;
    }


    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id)
        {
            case R.id.btn_submit:
                if(btn_submit.getText().toString().trim().equals("Save"))
                {
                    ConnectionDetector.ShowDialog("Data Saved Successfully.",getActivity());
                    btn_submit.setText("Submit");
                }
                else
                  ShowDialog("Complaint registered successfully.\nYour Reference No. is 100005.",getActivity());
                break;
            case R.id.btn_clear:
                complaint_by.setSelection(0);
                grivance_type.setSelection(0);

                graievance_ration_email.setText("");
                graievance_ration_mobileno.setText("");
                graievance_ration_decription.setText("");
                graievance_ration_email.setText("");
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
