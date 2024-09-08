package com.example.surfeillance_v2_frontend.views.dayforecasts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.surfeillance_v2_frontend.R;
import com.example.surfeillance_v2_frontend.model.data.Forecast;
import com.example.surfeillance_v2_frontend.model.entity.ForecastEntity;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DayForecastAdaptor extends RecyclerView.Adapter<DayForecastAdaptor.DayForecastViewHolder> {

    private List<ForecastEntity> forecasts;
    private DayForecastViewHolder viewholder;

    public DayForecastAdaptor(List<ForecastEntity> forecasts) {
        this.forecasts = forecasts;
    }

    @NonNull
    @Override
    public @NotNull DayForecastViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hour_forecast_item, parent, false);
        return new DayForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DayForecastAdaptor.DayForecastViewHolder dayForecastViewHolder, int i) {
        ForecastEntity forecastForThisHour = forecasts.get(i);
     dayForecastViewHolder.forecast_time.setText(forecastForThisHour.getTime());
     dayForecastViewHolder.waveHeight.setText(String.valueOf(forecastForThisHour.getWaveHeight()));
     dayForecastViewHolder.wavePeriod.setText(String.valueOf(forecastForThisHour.getWavePeriod()));
     dayForecastViewHolder.waveDirection.setText(String.valueOf(forecastForThisHour.getWaveDirection()));
     dayForecastViewHolder.windSpeed.setText(String.valueOf(forecastForThisHour.getWindSpeed()));
     dayForecastViewHolder.windDirection.setText(String.valueOf(forecastForThisHour.getWindDirection()));
     dayForecastViewHolder.windGusts.setText(String.valueOf(forecastForThisHour.getWindGusts()));
    }

    @Override
    public int getItemCount() {
        return forecasts.size();
    }

    public void updateForecasts(List<ForecastEntity> forecasts) {
        this.forecasts.clear();
        this.forecasts.addAll(forecasts);
        notifyDataSetChanged();
    }

    public class DayForecastViewHolder extends RecyclerView.ViewHolder {
        private TextView forecast_time, waveHeight, wavePeriod, waveDirection, windSpeed, windDirection, windGusts;

        public DayForecastViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            forecast_time = itemView.findViewById(R.id.forecast_time);
            waveHeight = itemView.findViewById(R.id.waveHeight);
            wavePeriod = itemView.findViewById(R.id.wavePeriod);
            waveDirection = itemView.findViewById(R.id.waveDirection);
            windSpeed = itemView.findViewById(R.id.windSpeed);
            windDirection = itemView.findViewById(R.id.windDirection);
            windGusts = itemView.findViewById(R.id.windGusts);


        }
    }
}
