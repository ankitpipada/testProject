package com.eps.smart_epds.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.eps.smart_epds.Model.App_Status;
import com.eps.smart_epds.R;

import java.util.ArrayList;

/**
 * Created by lenovo on 12/12/2017.
 */

public class App_Status_Adapter extends BaseAdapter {
    Context context;
    ArrayList<App_Status> appstatus = new ArrayList<>();
    public App_Status_Adapter(Context context, ArrayList<App_Status> appstatus) {
        this.context = context;
        this.appstatus = appstatus;
    }

    @Override
    public int getCount() {
        return appstatus.size();
    }

    @Override
    public Object getItem(int position) {
        return appstatus.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = vi.inflate(R.layout.new_app_status_listitem, null);

        TextView user = (TextView) view.findViewById(R.id.user);
        TextView workflow = (TextView) view.findViewById(R.id.workflow);
        TextView status = (TextView) view.findViewById(R.id.status);
        TextView date = (TextView) view.findViewById(R.id.date);

        user.setText(appstatus.get(position).getUser());
        workflow.setText(appstatus.get(position).getWorkflow());
        date.setText(appstatus.get(position).getDate());
        status.setText(appstatus.get(position).getStatus());

        return view;
    }
}
