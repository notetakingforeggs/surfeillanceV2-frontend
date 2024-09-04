package com.example.surfeillance_v2_frontend.views.weeklyForecasts;

import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.surfeillance_v2_frontend.R;
import com.example.surfeillance_v2_frontend.model.entity.ForecastEntity;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class WeeklyForecastAdaptor extends RecyclerView.Adapter<WeeklyForecastAdaptor.ForecastViewHolder> {

    private List<ForecastEntity> forecastEntities;

    public WeeklyForecastAdaptor(List<ForecastEntity> forecastEntities) {
        this.forecastEntities = forecastEntities;
        System.out.println("constructor of adaptor, forecast list size is " + forecastEntities.size());
    }

    @NonNull
    @NotNull
    @Override
    // on creation of the recyclerview and everything else:...
    public ForecastViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        // Inflating the layout of the recycler view item (making it into a view object in memory)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weekly_forecast_item, parent, false);

        // sending this view into the constructor of the recyclerview viewholder so now the various different views from ids
        // are also now object attributes in memory
        return new ForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ForecastViewHolder forecastViewHolder, int position) {
        // for the nth item in the recycler view, get the nth forecast from the list of entites we are putting in the recycler view
        Log.i("what position?", "onBindViewHolder: " + position);
        int forecastGroupStartingNumber = ((position ) * 3);

        ForecastEntity sixAmForecast = forecastEntities.get(forecastGroupStartingNumber);
        ForecastEntity twelvePmForecast = forecastEntities.get(forecastGroupStartingNumber + 1);
        ForecastEntity sixPmForecast = forecastEntities.get(forecastGroupStartingNumber + 2);


        forecastViewHolder.forecastDate.setText(sixAmForecast.getDate());
        // TODO there is an issue with out of bounds error for max size

        forecastViewHolder.forecast6amDetails.setText(compileTinyForecast(sixAmForecast));
        forecastViewHolder.forecast12pmDetails.setText(compileTinyForecast(twelvePmForecast));
        forecastViewHolder.forecast6pmDetails.setText(compileTinyForecast(sixPmForecast));
    }

    @Override
    public int getItemCount() {
        return forecastEntities.size();
    }

    public String compileTinyForecast(ForecastEntity forecast) {
        return ("Waves: " + forecast.getWaveHeight() + " M, at " + forecast.getWavePeriod() + " seconds, wind at " + forecast.getWindSpeed());
    }


    public void updateForecasts(List<ForecastEntity> newForecasts) {
        this.forecastEntities.clear();
        this.forecastEntities.addAll(newForecasts);
        notifyDataSetChanged();
    }

    public static class ForecastViewHolder extends RecyclerView.ViewHolder {
        TextView forecastDate, forecast6amDetails, forecast12pmDetails, forecast6pmDetails;

        public ForecastViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            forecastDate = itemView.findViewById(R.id.forecast_date);
            forecast6amDetails = itemView.findViewById(R.id.forecast_6am_details);
            forecast6pmDetails = itemView.findViewById(R.id.forecast_6pm_details);
            forecast12pmDetails = itemView.findViewById(R.id.forecast_12pm_details);

        }
    }

}
