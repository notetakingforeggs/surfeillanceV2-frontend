package com.example.surfeillance_v2_frontend.views.mainActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.surfeillance_v2_frontend.R;
import com.example.surfeillance_v2_frontend.model.entity.ForecastEntity;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MainActivityAdaptor extends RecyclerView.Adapter<MainActivityViewholder>{

    private List<ForecastEntity> forecastEntities;

    public MainActivityAdaptor(List<ForecastEntity> forecastEntities) {
        this.forecastEntities = forecastEntities;
    }

    @NonNull
    @NotNull
    @Override
    public MainActivityViewholder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
        // inflating layout
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.decent_surf_item, viewGroup, false);
        return new MainActivityViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MainActivityViewholder mainActivityViewholder, int i) {
        //TODO here i think is where I can put an apology page if there is no good surf.
        // No need to displayy is decent here as the sql query filters for that. maybe display that day and the next x days.

        ForecastEntity forecast = forecastEntities.get(i);
        mainActivityViewholder.spotName.setText(forecast.getName());
        mainActivityViewholder.date.setText(forecast.getDate());
    }

    @Override
    public int getItemCount() {
        return forecastEntities.size();
    }

    public void updateForecasts(List<ForecastEntity> newForecasts){
        this.forecastEntities.clear();
        this.forecastEntities.addAll(newForecasts);
        notifyDataSetChanged();
    }
}
