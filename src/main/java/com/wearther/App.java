package com.wearther;
import io.github.cdimascio.dotenv.Dotenv;
public class App {
    public static void main (String args[]) {
        Dotenv dotenv = Dotenv.load();
        String weatherkey = dotenv.get("OPENWEATHER_API_KEY");
        String groqkey = dotenv.get("GROQ");
        
        WeatherService ws = new WeatherService(weatherkey);

        try{
            String weatherInfo = ws.getWeather("Coimbatore");
            System.out.println(weatherInfo);
        } catch (Exception e) {
            System.out.println("Error fetching weather data: " + e.getMessage());
        }
    }
}