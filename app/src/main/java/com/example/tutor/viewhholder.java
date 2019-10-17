package com.example.tutor;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputLayout;

public class viewhholder extends RecyclerView.ViewHolder {
    public ImageView image;
    public TextView name,desc;
    public LinearLayout linearLayout;
    public viewhholder(View itemView)
    {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.imageview_id);
        name = (TextView) itemView.findViewById(R.id.name_textview);
        desc = (TextView) itemView.findViewById(R.id.desc_textview);
        linearLayout = (LinearLayout) itemView.findViewById(R.id.recycleritem_id);
    }

}
