package com.eps.smart_epds.Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.eps.smart_epds.Model.Weight_Measure_Model;
import com.eps.smart_epds.R;

import java.util.ArrayList;

/**
 * Created by lenovo on 12/15/2017.
 */

public class Weight_Measure_Adapter extends BaseAdapter {

    private Context context;
    private  ArrayList<Weight_Measure_Model> weight_measure_models = new ArrayList<>();

    public Weight_Measure_Adapter(Context context, ArrayList<Weight_Measure_Model> weight_measure_models){
        this.context = context;
        this.weight_measure_models = weight_measure_models;
    }

    @Override
    public int getCount() {
        return weight_measure_models.size();
    }

    @Override
    public Object getItem(int position) {
        return weight_measure_models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = vi.inflate(R.layout.horizontal_listview_item, null);

        TextView number =(TextView) view.findViewById(R.id.number);
        number.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        number.setSelected(true);
        number.setSingleLine(true);

        TextView lic_no = (TextView)view.findViewById(R.id.lic_no);
        lic_no.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        lic_no.setSelected(true);
        lic_no.setSingleLine(true);

        TextView iss_date =(TextView) view.findViewById(R.id.iss_date);
        iss_date.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        iss_date.setSelected(true);
        iss_date.setSingleLine(true);

        TextView ex_date = (TextView)view.findViewById(R.id.ex_date);
        ex_date.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        ex_date.setSelected(true);
        ex_date.setSingleLine(true);

        number.setText(weight_measure_models.get(position).getType());
        lic_no.setText(weight_measure_models.get(position).getLicense_no());
        iss_date.setText(weight_measure_models.get(position).getIssue_date());
        ex_date.setText(weight_measure_models.get(position).getExpiry_date());

        return view;
    }
}
