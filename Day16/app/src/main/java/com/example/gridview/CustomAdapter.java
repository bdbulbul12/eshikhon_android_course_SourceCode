package com.example.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    Context context;
    String [] cricketerName;
    int [] cricketerImg;
    LayoutInflater inflater;



    CustomAdapter(Context context,String[] cricketerName,int [] cricketerImg){

        this.context=context;
        this.cricketerName=cricketerName;
        this.cricketerImg=cricketerImg;

    }


    @Override
    public int getCount() {
        return cricketerName.length;
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
             view=inflater.inflate(R.layout.sample_view,viewGroup,false);
        }

        ImageView imageView = view.findViewById(R.id.imageViewId);
        TextView textView = view.findViewById(R.id.textViewId);

        imageView.setImageResource(cricketerImg[i]);
        textView.setText(cricketerName[i]);

        return view;
    }
}
