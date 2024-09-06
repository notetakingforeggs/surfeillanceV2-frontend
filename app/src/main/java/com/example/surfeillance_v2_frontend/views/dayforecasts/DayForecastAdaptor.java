package com.example.surfeillance_v2_frontend.views.dayforecasts;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

public class DayForecastAdaptor extends RecyclerView.Adapter<DayForecastAdaptor.DayForecastViewHolder> {

    @NonNull
    @Override
    public @NotNull DayForecastViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DayForecastAdaptor.DayForecastViewHolder dayForecastViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DayForecastViewHolder extends RecyclerView.ViewHolder {

        public DayForecastViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
        }
    }
}
