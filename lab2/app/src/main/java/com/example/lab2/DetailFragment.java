package com.example.lab2;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailFragment extends Fragment {

    //private LinearLayout bgElement;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
       // LinearLayout bgElement = getView().findViewById(R.id.detailFragment);
        return view;
    }

    // textView refreshing
    public void setText(String item) {
        TextView view = (TextView) getView().findViewById(R.id.valuesString);
        view.setText(item);

//        if (item == "Green")
//        {
//            bgElement.setBackgroundColor(Color.GREEN);
//        }
//        else
//        {
//            if (item == "Red")
//            {
//                bgElement.setBackgroundColor(Color.RED);
//            }
//            else
//            {
//                if (item == "Pink")
//                {
//                    bgElement.setBackgroundColor(Color.GRAY);
//                }
//                else
//                {
//                    bgElement.setBackgroundColor(Color.BLUE);
//                }
//            }
//        }
    }
}
