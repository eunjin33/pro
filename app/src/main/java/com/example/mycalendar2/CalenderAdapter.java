package com.example.mycalendar2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class CalenderAdapter extends BaseAdapter {

    List<MemoVO> list;

    public CalenderAdapter(List<MemoVO> list) {this.list = list;}

    public void setList(List<MemoVO> list) { this.list = list; }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int j) {
        return list.get(j);
    }

    @Override
    public long getItemId(int j) {
        return j;
    }

    @Override
    public View getView(int j, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        convertView = inflater.inflate(R.layout.listview_calender, parent, false);
        CheckBox checkBox = convertView.findViewById(R.id.checkBox);

        checkBox.setText(list.get(j).getTitle());
        return convertView;
    }
}
