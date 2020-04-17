package com.example.currentweather;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String apikey = "23a99067ef13e7f322b6478c4cebfbb1";

    @BindView(R.id.et_city_name)
    EditText etCityName;
    @BindView(R.id.bt_search)
    Button btSearch;
    @BindView(R.id.tv_weather)
    TextView tvWeather;
    @BindView(R.id.tv_date_time)
    TextView tvDateTime;
    @BindView(R.id.tv_country)
    TextView tvCountry;
    @BindView(R.id.tv_speed_wind)
    TextView tvSpeedWind;
    @BindView(R.id.tv_temperature)
    TextView tvTemperature;
    @BindView(R.id.tv_description)
    TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                APIService service = RetrofitConfiguration.getInstance().create(APIService.class);

                Call<GetWeatherResponse> call = service.search(etCityName.getText().toString(), apikey);

                call.enqueue(new Callback<GetWeatherResponse>() {
                    @Override
                    public void onResponse(Call<GetWeatherResponse> call, Response<GetWeatherResponse> response) {
                        if (response.code() == 200) {
                            GetWeatherResponse respond = response.body();

                            GetWeatherResponse.WeatherBean respondWeather = respond.getWeather().get(0);
                            tvWeather.setText("weather: " + respondWeather.getMain());
                            tvDescription.setText("description: " + respondWeather.getDescription());

                            Date date = new Date(respond.getDt() * 1000L);
                            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE yyyy-MM-dd");
                            tvDateTime.setText("date: " + dateFormat.format(date));

                            GetWeatherResponse.SysBean respondSys = respond.getSys();
                            tvCountry.setText("country: " + respondSys.getCountry());

                            GetWeatherResponse.WindBean respondWind = respond.getWind();
                            tvSpeedWind.setText("speed wind: " + (int) respondWind.getSpeed());

                            GetWeatherResponse.MainBean respondMain = respond.getMain();
                            tvTemperature.setText("temperature: " + (int) respondMain.getTemp() / 10);
                        }
                        else if (response.code()==404) {
                            Toast.makeText(MainActivity.this, "city not found", Toast.LENGTH_LONG).show();
                        }else if (response.code()==401){
                            Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<GetWeatherResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

}
