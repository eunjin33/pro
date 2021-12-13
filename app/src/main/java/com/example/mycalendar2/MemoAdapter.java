package com.example.mycalendar2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MemoAdapter extends BaseAdapter {

    List<MemoVO> list;

    public MemoAdapter(){}

    public MemoAdapter(List<MemoVO> list) {this.list = list;}

    public void setList(List<MemoVO> list) {this.list = list;}

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        view = inflater.inflate(R.layout.listview_item, viewGroup, false);
        TextView txtTitle = view.findViewById(R.id.txtTitleList);
        TextView txtContent = view.findViewById(R.id.txtContentList);

        txtTitle.setText(list.get(i).getTitle());
        txtContent.setText(list.get(i).getContent());
        return view;
    }

}
