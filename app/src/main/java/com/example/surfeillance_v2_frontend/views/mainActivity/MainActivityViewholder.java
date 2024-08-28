package com.example.surfeillance_v2_frontend.views.mainActivity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.surfeillance_v2_frontend.R;
import com.google.android.material.textview.MaterialTextView;
import org.jetbrains.annotations.NotNull;

public class MainActivityViewholder extends RecyclerView.ViewHolder {
    public MaterialTextView spotName;
    public MaterialTextView date;
    public TextView isDecent;


    public MainActivityViewholder(@NonNull @NotNull View itemView) {
        super(itemView);
        spotName = itemView.findViewById(R.id.spotTitle);
        date = itemView.findViewById(R.id.date);
        isDecent = itemView.findViewById(R.id.isDecent);

    }
}
