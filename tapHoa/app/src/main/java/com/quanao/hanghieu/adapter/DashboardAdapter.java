package com.quanao.hanghieu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.quanao.hanghieu.R;
import com.quanao.hanghieu.MainActivity;
import com.quanao.hanghieu.data.Categories;

import java.util.ArrayList;

public class DashboardAdapter extends BaseAdapter {
    private ArrayList<Categories> listData;
    private LayoutInflater layoutInflater;
    private Context context;
    private MainActivity home;

    public DashboardAdapter(MainActivity home, ArrayList<Categories> arrayList) {
        this.home = home;
        this.listData = arrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            convertView = layoutInflater.inflate(R.layout.fragment_dashboard,null);
            holder = new ViewHolder();
            holder.imageView =(ImageView)convertView.findViewById(R.id.imageView_category);
            holder.textView = (TextView) convertView.findViewById(R.id.textView_Name);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }
        Categories categories = this.listData.get(position);
        holder.textView.setText(categories.getName());
        return convertView;
    }
    static class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
