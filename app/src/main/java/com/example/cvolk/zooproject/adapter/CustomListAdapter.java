package com.example.cvolk.zooproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.cvolk.zooproject.R;
import com.example.cvolk.zooproject.data.DataFactory;
import com.example.cvolk.zooproject.model.animals.Animal;

import java.util.List;

public class CustomListAdapter extends ArrayAdapter<String> {

    public CustomListAdapter(@NonNull Context context, int resource, List<String> typeList) {
        super(context, resource, typeList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {

            int layoutId = 0;
            switch (getItem(position)) {
                case "Cat":
                    layoutId = R.layout.cat_item;
                    break;
                case "Primate":
                    layoutId = R.layout.primate_item;
                    break;
                case "Reptile":
                    layoutId = R.layout.reptile_item;
                    break;
            }

            convertView = LayoutInflater.from(parent.getContext()).inflate(layoutId, null);
        }

        // bind views
        TextView tvTypeName = convertView.findViewById(R.id.tvTypeName);
        TextView tvTypeCount = convertView.findViewById(R.id.tvTypeCount);

        // bind views with data
        String type = getItem(position);
        String typeCount = String.valueOf(DataFactory.getTypeCount(type));

        tvTypeName.setText(type);
        tvTypeCount.setText(typeCount);

        return convertView;
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return super.getItem(position);
    }
}
