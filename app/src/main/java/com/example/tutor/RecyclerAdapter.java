package com.example.tutor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<viewhholder>
{
    private List<User> users;
    private Context context;
    public RecyclerAdapter(Context context,List<User> users)
    {
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public viewhholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new viewhholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewhholder holder, final int position) {
        User sampleuser = users.get(position);
        holder.name.setText(sampleuser.subjectname);
        holder.desc.setText(sampleuser.userdesc);

        //Glider for smooth transitions
        Glide.with(context).load(sampleuser.subimage).into(holder.image);


        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Item "+ position + " Clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
