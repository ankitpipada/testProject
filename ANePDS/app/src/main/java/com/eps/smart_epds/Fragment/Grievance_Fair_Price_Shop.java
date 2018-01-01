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


public class Grievance_Fair_Price_Shop extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private EditText fps_owner_name,fps_name,fps_email,fps_mobile,fps_description;
    private Spinner fps_grievance_tpe;
//    String[] Grievance_type = new String[]{"---- Please Select Grievance Type--------", "South Andaman", "Port Blair", "Ferrargunj", " Little Andaman"};

    String[] Grievance_type = new String[] {"Delay in processing of indent" ,
            "Non-receipt of entitled quantity" ,
            "damage/infested foodgrains" ,
            "Underweighment of bags" ,
            "Delayed issuance of foodgrais" ,
            "Delayed reecipt of kerosene oil /fortified wheat Atta" ,
            "Non-receipt of SMS alert"};
    private Button fps_summit,fps_clear;

    public Grievance_Fair_Price_Shop() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.grievance_fps, container, false);
        Init(view);
        return view;
    }

    private void Init(View view)
    {
        fps_owner_name=(EditText)view.findViewById(R.id.fps_owner_name);
        fps_owner_name.setEnabled(false);
        fps_name=(EditText)view.findViewById(R.id.fps_name);
        fps_name.setEnabled(false);
        fps_email=(EditText)view.findViewById(R.id.fps_email);
//        fps_email.setEnabled(false);
        fps_mobile=(EditText)view.findViewById(R.id.fps_mobile);
//        fps_mobile.setEnabled(false);
        fps_description=(EditText)view.findViewById(R.id.fps_description);
        fps_description.setEnabled(false);
//
        fps_grievance_tpe=(Spinner) view.findViewById(R.id.fps_grievance_tpe);
//        fps_grievance_tpe.setEnabled(false);
        ArrayAdapter<String> Grievance_type_adapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item_layout, Grievance_type);
        fps_grievance_tpe.setAdapter(Grievance_type_adapter);

        fps_summit=(Button)view.findViewById(R.id.fps_summit);
        fps_clear=(Button)view.findViewById(R.id.fps_clear);
        fps_clear.setOnClickListener(this);
        fps_summit.setOnClickListener(this);



        fps_owner_name.setText("G KARMEGAM");
        fps_name.setText("OM SARAVANA TRADERS");
        fps_email.setText("gkaregam@gmail.com");
        fps_mobile.setText("9827618819");
        fps_description.setText("FPS Information mismatch");
        fps_grievance_tpe.setSelection(2);

    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id)
        {
            case R.id.fps_summit:
                if(fps_summit.getText().toString().trim().equals("Save"))
                {
                    ConnectionDetector.ShowDialog("Data Saved Successfully.",getActivity());
                    fps_summit.setText("Submit");
                }
                else
                    ShowDialog("Complaint registered successfully.\nYour Reference No. is 100006.",getActivity());
                break;
            case R.id.fps_clear:
                fps_owner_name.setText("");
                fps_name.setText("");
                fps_email.setText("");
                fps_mobile.setText("");
                fps_description.setText("");
                fps_grievance_tpe.setSelection(0);
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
