package com.example.listviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    int[] flowers;
    String [] flowerNames;
    Context context;
    LayoutInflater inflater;

    CustomAdapter(Context context,String[] flowerNames,int [] flowers){
        this.context=context;
        this.flowerNames=flowerNames;
        this.flowers=flowers;

    }



    @Override
    public int getCount() {
        return flowerNames.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.sample_view,viewGroup,false);
        }

        ImageView imageView = view.findViewById(R.id.imageViewId);
        TextView textView = view.findViewById(R.id.flowerNameId);

        imageView.setImageResource(flowers[i]);
        textView.setText(flowerNames[i]);

        return view;
    }
}
