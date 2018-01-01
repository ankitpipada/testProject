package com.eps.smart_epds.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.eps.smart_epds.Interface.FPS_Check_Change_Listner;
import com.eps.smart_epds.Model.FPS_Detail;
import com.eps.smart_epds.R;

import java.util.ArrayList;

/**
 * Created by lenovo on 12/4/2017.
 */

public class FPS_Change_Item_Adapter extends BaseAdapter {

    Context context;
    public  ArrayList<FPS_Detail> Userinfo=new ArrayList<FPS_Detail>();
    FPS_Check_Change_Listner _listner;
    int From_via;
    public FPS_Change_Item_Adapter(FPS_Check_Change_Listner listner,Context ct, ArrayList<FPS_Detail> list, int from)
    {
        this.context=ct;
        this.Userinfo=list;
        this.From_via= from;
        this._listner=listner;
    }
    @Override
    public int getCount() {
        return Userinfo.size();
    }

    @Override
    public FPS_Detail getItem(int position) {
        return Userinfo.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View grid = new View(context);
//        View grid;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        grid = inflater.inflate(R.layout.fps_selection_dialog_adapter, null);
        TextView fps_code=(TextView)grid.findViewById(R.id.selected_fps_code);
        TextView fps_name=(TextView)grid.findViewById(R.id.fps_name_txt);
        TextView fps_address=(TextView)grid.findViewById(R.id.fps_address);


//        CheckBox check_status=(CheckBox)grid .findViewById(R.id.check_status);
//        check_status.setVisibility(View.GONE);


//        check_status.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//
//                _listner.FPS_Change_listner();
//            }
//        });


        fps_code.setText(Userinfo.get(position).getCode());
        fps_name.setText(Userinfo.get(position).getName());
        fps_address.setText(Userinfo.get(position).getAddress());




        return grid;
    }
}
