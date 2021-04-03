package com.example.lab005a.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.lab005a.Model.Fruit;
import com.example.lab005a.R;

import java.util.List;

public class ListAdapter extends BaseAdapter {

    private List<Fruit> mFruit;

    public ListAdapter (List<Fruit> fList){
        this.mFruit = fList;
    }

    @Override
    public int getCount() {
        return mFruit.isEmpty() ? 0:mFruit.size();
    }

    @Override
    public Object getItem(int position) {
        return mFruit.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = (Fruit) getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.id = (TextView) convertView.findViewById(R.id.tv_id);
            viewHolder.name = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.color = (TextView) convertView.findViewById(R.id.tv_color);
            convertView.setTag(viewHolder);
        }

        ViewHolder vh = (ViewHolder) convertView.getTag();
        vh.id.setText(fruit.getId());
        vh.name.setText(fruit.getfName());
        vh.color.setText(fruit.getfColor());
        return convertView;

    }

    private class ViewHolder{
        private TextView id, name, color;
    }


}
