package com.eshikhon.listview_gridview_n191;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter {
    private final Activity context;
    private final String[] fruits;
    private final Integer[] image;


    public CustomListAdapter(@NonNull Activity context,String[] fruits, Integer[] image) {
        super(context, R.layout.mycustomlist, fruits);

        this.context = context;
        this.fruits = fruits;
        this.image = image;
    }



    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mycustomlist, null, true);

        TextView fruitTV =  rowView.findViewById(R.id.tv);
        ImageView imageTV =  rowView.findViewById(R.id.image);

        fruitTV.setText(fruits[position]);
        imageTV.setImageResource(image[position]);

        return rowView;

    }

}
