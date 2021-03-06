package com.eps.smart_epds;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class UIHelper
{	
	Activity activity;
	private ProgressDialog progressDialog, loadingDialog;

	public UIHelper(Activity activity)
	{
		this.activity = activity;
	}	
	
	public void showProgressDialog(final String title , final String message){

			if (activity != null){

		  			activity.runOnUiThread(new Runnable(){
				public void run(){
					progressDialog = ProgressDialog.show(activity, title, message);
				}
			});


		}
	}
	
	public void showLoadingDialog(final String message) {
		if (activity != null) {
			activity.runOnUiThread(new Runnable() {
				public void run() {

					loadingDialog = ProgressDialog.show(activity, "", message,	true, false);
				}
			});
		}
	}
	
	public void dismissLoadingDialog() {
		if (activity != null && loadingDialog != null) {
			loadingDialog.dismiss();
		}
	}
	
	public boolean isProgressActive(){
		if (progressDialog != null)
		{
			return progressDialog.isShowing();
		} 
		else
		{
			return false;
		}
	}
	public void dismissProgressDialog(){		
		if (activity != null && progressDialog != null)
		{
			progressDialog.dismiss();
		}
	}	

	public void showAlertDialog(final String Title, final String Message){
		activity.runOnUiThread(new Runnable() {
			public void run() {
				new AlertDialog.Builder(activity).setMessage(Message).setTitle(Title).setPositiveButton("OK", new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialog, int id){
						dialog.dismiss();
					}
				}).create().show();
			}
		});		
	}
	public void ShowDialog(String message, Activity activity) {
		final Dialog dialog = new Dialog(activity);
		// Include dialog.xml file
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //before
		dialog.setContentView(R.layout.alert_dialog);
		// Set dialog title
		// set values for custom dialog components - text, image and button
		TextView text = (TextView) dialog.findViewById(R.id.textDialog);

		text.setText(message);


		Button OkButton = (Button) dialog.findViewById(R.id.submitbutton);
		OkButton.setText(activity.getResources().getString(R.string.please_wait));
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


	public void showToast(final String msg) {
		if (activity != null){
			activity.runOnUiThread(new Runnable()
			{
				public void run() 
				{
					Toast.makeText(activity,msg, Toast.LENGTH_LONG).show();
				}
			});
		}
	}
	
	public boolean IsNumeric(String strNumber){
		try{
			double isNumberic = Double.parseDouble(strNumber);
			} catch (Exception e) {
				// TODO: handle exception
				return false;
			}
			
			return true;
		}
	@SuppressLint("SimpleDateFormat")
	public String ConvertJsonDate(String strdate, String strDateFormate)
	{
		String formattedDate = null;
		try{
//			Calendar cal = Calendar.getInstance();
//			TimeZone tz = cal.getTimeZone();
			String strAcuire = strdate.substring(6, strdate.length()-6);
			String ackwardRipOff = strAcuire.replace("+", "");
			long lngDate = Long.parseLong(ackwardRipOff);
//			Date createdOn = new Date((lngDate+(0530*36000)));
			Date createdOn = new Date(lngDate);
			SimpleDateFormat sdf = new SimpleDateFormat(strDateFormate);
//			sdf.setTimeZone(tz);
			formattedDate = sdf.format(createdOn);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return formattedDate;
	}

	public String getJsonFormatDate()
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
//	@SuppressLint("SimpleDateFormat")
//	public String ConvertJsonDate(String strdate, String strDateFormate)
//	{
//		String formattedDate = null;
//		try{
////			Calendar cal = Calendar.getInstance();
////			TimeZone tz = cal.getTimeZone();
//			String strAcuire = strdate.substring(6, strdate.length()-2);
//			String ackwardRipOff = strAcuire.replace("+", "");
//			long lngDate = Long.parseLong(ackwardRipOff.substring(0, 13));
////			Date createdOn = new Date((lngDate+(0530*36000)));
//			Date createdOn = new Date(lngDate);
//			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy", Locale.US);
////			sdf.setTimeZone(tz);
//			formattedDate = sdf.format(createdOn);
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return formattedDate;
//	}
//
//	public String getJsonFormatDate()
//	{
//		String jsonRetun =null;// "/Date(1444977583891+0530)/"
//		try{
//
//			long millisStart = Calendar.getInstance().getTimeInMillis();
//			jsonRetun = "/Date("+millisStart+"+0530)/";
//
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//
//		return jsonRetun;
//
//	}
	public String getJsonFormatDOB(long date)
	{
		String jsonRetun =null;// "/Date(1444977583891+0530)/"
		try{

			long millisStart = Calendar.getInstance().getTimeInMillis();
			String DateTime=""+date;
//			jsonRetun = "/Date("+DateTime+"+0530)/";
			jsonRetun = "/Date("+DateTime+"+0000)/";
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return jsonRetun;

	}
	public String getCompleteAddressString(Context mContext, double LATITUDE, double LONGITUDE) {
        String strAdd = "";
        
        try {
       	 Geocoder geocoder = new Geocoder(mContext, Locale.getDefault());
       	 List<Address> addresses = geocoder.getFromLocation(LATITUDE, LONGITUDE, 1);
            if (addresses != null) {
                Address returnedAddress = addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder("");

                for (int i = 0; i < returnedAddress.getMaxAddressLineIndex(); i++) {
                    strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n");
                }
                strAdd = strReturnedAddress.toString();

            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strAdd;
    }

}
