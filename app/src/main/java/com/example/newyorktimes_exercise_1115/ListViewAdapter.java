package com.example.newyorktimes_exercise_1115;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter
{
    MainActivity mainActivity;
    ArrayList<String> titles;
    ArrayList<String> dates;
    ArrayList<String> authors;

    public ListViewAdapter(MainActivity mA, ArrayList<String> t,
                           ArrayList<String> d, ArrayList<String> a)
    {
        mainActivity = mA;
        titles = t;
        dates = d;
        authors = a;
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
            convertView = mainActivity.getLayoutInflater().inflate(R.layout.customlayout, null);

            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
            TextView textView_date = (TextView)convertView.findViewById(R.id.textView_date);
            TextView textView_title = (TextView)convertView.findViewById(R.id.textView_Title);
            TextView textView_author = (TextView)convertView.findViewById(R.id.textView_author);

            textView_title.setText(titles.get(position));
            textView_date.setText(dates.get(position));
            textView_author.setText(authors.get(position));

            return null;
    }
}
