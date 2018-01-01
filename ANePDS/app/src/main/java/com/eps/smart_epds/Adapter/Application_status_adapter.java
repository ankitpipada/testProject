package com.eps.smart_epds.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.eps.smart_epds.Model.Applcation_Status_Model;
import com.eps.smart_epds.R;

import java.util.ArrayList;

/**
 * Created by lenovo on 12/7/2017.
 */

public class Application_status_adapter extends BaseAdapter {

    Context context;
    ArrayList<Applcation_Status_Model> list=new ArrayList<Applcation_Status_Model>();

    public Application_status_adapter(Context context, ArrayList<Applcation_Status_Model> _list) {
        this.context = context;
        this.list=_list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Applcation_Status_Model getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = vi.inflate(R.layout.application_status_listitem, null);

        TextView ap_date_txt = (TextView) view.findViewById(R.id.ap_date_txt);
        TextView ac_no_txt = (TextView) view.findViewById(R.id.ac_no_txt);
        TextView re_type_txt = (TextView) view.findViewById(R.id.re_type_txt);
        re_type_txt.setSelected(true);

        ap_date_txt.setText(list.get(position).getDate());
        ac_no_txt.setText(list.get(position).getAcknowledgeNo());
        re_type_txt.setText(list.get(position).getRequestType());

        return view;
    }
}
