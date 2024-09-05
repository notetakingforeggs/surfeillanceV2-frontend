package com.example.surfeillance_v2_frontend.views.mainactivity;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.surfeillance_v2_frontend.R;
import com.example.surfeillance_v2_frontend.views.OnItemClickListener;
import com.google.android.material.textview.MaterialTextView;
import org.jetbrains.annotations.NotNull;

public class MainActivityViewholder extends RecyclerView.ViewHolder {
    public MaterialTextView spotName;
    public MaterialTextView date;


    public MainActivityViewholder(@NonNull @NotNull View itemView, OnItemClickListener listener) {
        super(itemView);
        spotName = itemView.findViewById(R.id.spotTitle);
        date = itemView.findViewById(R.id.date);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 listener.onItemClick(getAdapterPosition());
            }
        });


    }
}
