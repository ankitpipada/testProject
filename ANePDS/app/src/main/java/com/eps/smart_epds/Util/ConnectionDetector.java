package com.eps.smart_epds.Util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.eps.smart_epds.R;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Random;




public class ConnectionDetector {

    private Context _context;

    public ConnectionDetector(Context context) {
        this._context = context;
    }

    public boolean isConnectingToInternet() {
        ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivity != null) {
            @SuppressWarnings("deprecation")
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }

        }
        return false;
    }

    public static void Custom_dialog_messge(Activity activity, String message) {
        final Dialog dialog = new Dialog(activity);
        // Include dialog.xml file
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //before
        dialog.setContentView(R.layout.status_dialog);
        dialog.setCanceledOnTouchOutside(false);
        // Set dialog title
        // set values for custom dialog components - text, image and button
        TextView text = (TextView) dialog.findViewById(R.id.textDialog);

        text.setText(message);


        Button OkButton = (Button) dialog.findViewById(R.id.submitbutton);
        OkButton.setText("Ok");



        dialog.show();
        // if decline button is clicked, close the custom dialog
        OkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
                dialog.dismiss();
                //  Custom_dialog("", type);

            }
        });

        // if decline button is clicked, close the custom dialog

    }


    public static void ShowDialog(String message, Activity activity) {
        final Dialog dialog = new Dialog(activity);
        // Include dialog.xml file
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //before
        dialog.setContentView(R.layout.alert_dialog);
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

            }
        });

        // if decline button is clicked, close the custom dialog

    }



    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    public static String GetEncripted_Value()
    {
        String Return_value="";
        try {
            String bytesToken = "tokenbased:authentication";
            byte[]  byteArray = bytesToken.getBytes("UTF-8");
            String base64Token= Base64.encodeToString(byteArray, Base64.DEFAULT);//new String(Base64.encode(byteArray,Base64.DEFAULT));
            String Encription = "Lgh=U3-lz_dG7=ytL=l1dXN=0Y2e5hdG9rZW5h3iYXNlZhph=d2j6doZW50a=WNhdGlvpf4c-mJodQ==";
            String random_string=ConnectionDetector.generateRandomString(Encription);
            byte[]  byteArray1 = random_string.getBytes("UTF-8");
            String base64Random= Base64.encodeToString(byteArray1, Base64.DEFAULT);

            Return_value=base64Random.substring(0, 10) + Encription.substring(0, 10) + base64Token.substring(0, base64Token.length() - 3) + Encription.substring(Encription.length() - 10, Encription.length() );

        }catch (UnsupportedEncodingException e){}
        return  Return_value;
    }

    public static String generateRandomString(String list){

        StringBuffer randStr = new StringBuffer();
        for(int i=0; i<10; i++){
            int number = getRandomNumber(list);
            char ch = list.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }
    public static  int getRandomNumber(String List) {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(List.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }

    // Method for checking Internet Connection
    public static boolean isConnectedToNet(Context _context) {
        Boolean isgprs=false,isWifi=false;
        try {
            ConnectivityManager manager = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);

            try {
                isgprs = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting();
            }catch (Exception e){}
            try {
                isWifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
            }catch (Exception e)
            {}
        }
        catch (Exception e)
        {}
        if (isgprs || isWifi) {
            return true;
        } else {
            return false;
        }

    }

    public static String getJsonFormatDate()
    {
        String jsonRetun =null;// "/Date(1444977583891+0530)/"
        try{

            long millisStart = Calendar.getInstance().getTimeInMillis();
            jsonRetun = "/Date("+millisStart+"+0530)/";

        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return jsonRetun;

    }
}