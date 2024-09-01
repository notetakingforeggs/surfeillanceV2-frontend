package com.example.surfeillance_v2_frontend.views.weeklyForecasts;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.surfeillance_v2_frontend.model.entity.ForecastEntity;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class WeeklyForecastAdaptor extends RecyclerView.Adapter {

    private List<ForecastEntity> forecastEntities;

    public WeeklyForecastAdaptor(List<ForecastEntity> forecastEntities) {
        this.forecastEntities = forecastEntities;
    }

    @NonNull
    @Override
    public @NotNull RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
