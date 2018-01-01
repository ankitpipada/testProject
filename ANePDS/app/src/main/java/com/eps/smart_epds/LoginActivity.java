package com.eps.smart_epds;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by lenovo on 12/4/2017.
 */

public class LoginActivity extends AppCompatActivity {

    EditText etmobile;
    Button btn_getdata;
    UIHelper uiHelper;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        etmobile = (EditText) findViewById(R.id.etmobile);
        btn_getdata = (Button) findViewById(R.id.btn_getdata);
        final String no = "9876543210";
        uiHelper = new UIHelper(this);


        btn_getdata.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
//                    if(etmobile != null && etmobile.length()==10)
                    {
                        Intent i = new Intent(LoginActivity.this, OTPActivity.class);
                        startActivity(i);
                        finish();
                    }
//                    else
//                    {
//                        ConnectionDetector.ShowDialog("Please Enter Valid Mobile Number",LoginActivity.this);
//                    }
                }
            });


//        etmobile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                myscrollview.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        View lastChild = myscrollview.getChildAt(myscrollview.getChildCount() - 1);
//                        int bottom = lastChild.getBottom() + myscrollview.getPaddingBottom();
//                        int sy = myscrollview.getScrollY();
//                        int sh = myscrollview.getHeight();
//                        int delta = bottom - (sy + sh);
//                        myscrollview.smoothScrollBy(0, delta);
//                    }
//                }, 200);
//            }
//        });

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Custom_dialog_messge(LoginActivity.this,"Do you want to Exit?");
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
                dialog.dismiss();
                finishAffinity();
//                finish();

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
