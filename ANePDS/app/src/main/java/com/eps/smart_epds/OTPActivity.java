package com.eps.smart_epds;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by lenovo on 12/4/2017.
 */

public class OTPActivity extends AppCompatActivity
{
    Button submit;
    EditText otp_et;
    UIHelper uiHelper;
    Bundle bundle;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_otp_lyt);

        submit = (Button) findViewById(R.id.submit);
        otp_et = (EditText) findViewById(R.id.otp_et);
        uiHelper = new UIHelper(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if(otp_et != null && otp_et.length()==4) {
                    Intent i = new Intent(OTPActivity.this, HomePage.class);
                    i.putExtra("value",0);
                    startActivity(i);
                    finish();
//                }
//                else
//                {
//                    ConnectionDetector.ShowDialog("Please Enter Valid 4 digit OTP",OTPActivity.this);
//                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(OTPActivity.this,LoginActivity.class);
        startActivity(i);
        finish();
    }
}
