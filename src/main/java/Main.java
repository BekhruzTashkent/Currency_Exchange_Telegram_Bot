import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import uz.pdp.model.Currency;
import uz.pdp.model.TelegramBot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


public class Main {


    public static void main(String[] args) {


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            URL url = new URL("https://cbu.uz/uz/arkhiv-kursov-valyut/json/");
            URLConnection urlConnection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            Type type = new TypeToken<ArrayList<Currency>>() {
            }.getType();
            ArrayList<Currency> currencies = gson.fromJson(reader, type);
            currencies.forEach(currency -> {
                if (currency.getCode().equals("840")) {
                    System.out.println(currency.toString());
                }
                if (currency.getCode().equals("978")) {
                    System.out.println(currency.toString());
                }
                if (currency.getCode().equals("392")) {
                    System.out.println(currency.toString());

                }

            });


        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new TelegramBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }
}

