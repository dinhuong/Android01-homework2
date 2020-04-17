package com.example.currentweather;

import java.util.List;

public class GetWeatherResponse {
    /*{"coord":{"lon":106.67,"lat":10.75},
        "weather":[{"id":802,"main":"Clouds","description":"scattered clouds","icon":"03n"}],
        "base":"stations",
        "main":{"temp":302.15,"feels_like":305.73,"temp_min":302.15,"temp_max":302.15,"pressure":1010,"humidity":74},
        "visibility":10000,
        "wind":{"speed":3.1,"deg":120},
        "clouds":{"all":40},
        "dt":1587045848,
        "sys":{"type":1,"id":9314,"country":"VN","sunrise":1586990498,"sunset":1587035048},
        "timezone":25200,
        "id":1566083,
        "name":"Ho Chi Minh City",
        "cod":200
    }*/
    private List<WeatherBean> weather;
    private MainBean main;
    private WindBean wind;
    private int dt;
    private SysBean sys;

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public List<WeatherBean> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherBean> weather) {
        this.weather = weather;
    }

    public MainBean getMain() {
        return main;
    }

    public void setMain(MainBean main) {
        this.main = main;
    }

    public WindBean getWind() {
        return wind;
    }

    public void setWind(WindBean wind) {
        this.wind = wind;
    }

    public SysBean getSys() {
        return sys;
    }

    public void setSys(SysBean sys) {
        this.sys = sys;
    }

    class WeatherBean {
        /*{"id":802,
        "main":"Clouds",
        "description":"scattered clouds",
        "icon":"03n"}*/
        String main;

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        String description;
    }

    public class MainBean {
        /*{"temp":302.15,
        "feels_like":305.73,
        "temp_min":302.15,
        "temp_max":302.15,
        "pressure":1010,
        "humidity":74}*/
        float temp;

        public double getTemp() {
            return temp;
        }

        public void setTemp(float temp) {
            this.temp = temp;
        }
    }

    public class WindBean {
        /*{"speed":3.1,
        "deg":120}*/
        float speed;

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(float speed) {
            this.speed = speed;
        }
    }

    public class SysBean {
        /*{"type":1,
        "id":9314,
        "country":"VN",
        "sunrise":1586990498,
        "sunset":1587035048}*/
        String country;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }
}
