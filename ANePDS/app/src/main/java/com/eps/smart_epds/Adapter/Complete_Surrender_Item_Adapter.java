package com.eps.smart_epds.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.eps.smart_epds.Model.UserDetail;
import com.eps.smart_epds.R;

import java.util.ArrayList;

/**
 * Created by lenovo on 12/4/2017.
 */

public class Complete_Surrender_Item_Adapter extends BaseAdapter {

    Context context;
    public static ArrayList<UserDetail> Userinfo=new ArrayList<UserDetail>();
    int From_via;
    public Complete_Surrender_Item_Adapter(Context ct, ArrayList<UserDetail> list,int from)
    {
        this.context=ct;
        this.Userinfo=list;
        this.From_via= from;
    }
    @Override
    public int getCount() {
        return Userinfo.size();
    }

    @Override
    public UserDetail getItem(int position) {
        return Userinfo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View grid = new View(context);
        grid = inflater.inflate(R.layout.surrender_list_item, null);
        TextView name=(TextView)grid.findViewById(R.id.name);
        TextView relation=(TextView)grid.findViewById(R.id.relation);
        TextView age=(TextView)grid.findViewById(R.id.age);
        TextView gender=(TextView)grid.findViewById(R.id.gender);
        CheckBox check_status=(CheckBox)grid.findViewById(R.id.check_status);

        if(From_via==2) {
            if (position == 0) {
                check_status.setVisibility(View.GONE);
                check_status.setClickable(false);
                check_status.setChecked(false);
                Userinfo.get(position).setIs_Check(false);
            } else
                check_status.setClickable(true);
            if (position == 2) {
                check_status.setVisibility(View.VISIBLE);
                check_status.setClickable(true);
                check_status.setChecked(true);
            }

        }
        else
        {
            check_status.setChecked(true);
            check_status.setClickable(false);
        }

        check_status.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Userinfo.get(position).setIs_Check(b);
            }
        });

        name.setText(Userinfo.get(position).getName());
        relation.setText(Userinfo.get(position).getRelation());
        age.setText(Userinfo.get(position).getAge());
        gender.setText(Userinfo.get(position).getGender());
        return grid;
    }
}
