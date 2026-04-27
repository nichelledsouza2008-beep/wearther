package com.wearther;
import io.github.cdimascio.dotenv.Dotenv;
public class App {
    public static void main (String args[]) {
        Dotenv dotenv = Dotenv.load();
        String weatherkey = dotenv.get("OPENWEATHER_API_KEY");
        String groqkey = dotenv.get("GROQ");
        System.out.println("Weather Key: " + weatherkey);
        System.out.println("Groq Key: " + groqkey);
    }
}