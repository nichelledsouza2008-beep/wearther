package com.wearther;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.Scanner;
public class App {
    public static void main (String args[]) 
    {
        Dotenv dotenv = Dotenv.load();
        String weatherkey = dotenv.get("OPENWEATHER_API_KEY");
        String groqkey = dotenv.get("GROQ");

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the city you reside in");
        String city = in.nextLine();

        WeatherService ws = new WeatherService(weatherkey);
        GroqService gs = new GroqService(groqkey);

        try
        {
            String weatherInfo = ws.getWeather(city);
            System.out.println("Weather Information:");
            System.out.println(weatherInfo);
            String outfitsuggestion = gs.getSuggestion(weatherInfo);
            System.out.println("According to the weather, here is a suggestion for your outfit:");
            System.out.println(outfitsuggestion);
        } 
        catch (Exception e) 
        {
            System.out.println("Error fetching weather data: " + e.getMessage());
        }
        in.close(); //ask why
    }
}