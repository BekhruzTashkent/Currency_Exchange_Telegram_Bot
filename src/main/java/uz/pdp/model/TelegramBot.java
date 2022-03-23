package uz.pdp.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TelegramBot extends TelegramLongPollingBot {

    Currency currency = new Currency();

    @Override
    public String getBotUsername() {
        return "t.me/Bekhruz_Karimov_Bot";
    }

    @Override
    public String getBotToken() {
        return "5107781135:AAGpSybfdXfg93m3B5-1B94H0ZV8R88eCfI";
    }

    @Override
    public void onUpdateReceived(Update update) {

        String inputText = update.getMessage().getText();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        ArrayList<Currency> currencies = new ArrayList();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            URL url = new URL("https://cbu.uz/uz/arkhiv-kursov-valyut/json/?=USD,RUB,EURO");
            URLConnection urlConnection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            Type type = new TypeToken<ArrayList<Currency>>() {
            }.getType();
            currencies = gson.fromJson(reader, type);


        } catch (IOException e) {
            e.printStackTrace();
        }


        if (inputText.equals("Exchange")) {



            sendMessage.setText("""
                    1)Name of currency
                    2)Amount of money(only 20,50,100)\s
                    Ex:USD 20,EURO 50,YUAN 100""");



        }
        else if(inputText.equals("USD 20")){
            for (Currency currency2 : currencies) {
                if (currency2.getCode().equals("840")) {
                    double number = Double.parseDouble(currency2.getRate())*20;
                    int value = (int)number;

                    sendMessage.setText("20$ = " + number+" sum");
        }}}
             else if(inputText.equals("USD 50")) {
                    for (Currency currency1 : currencies) {
                        if (currency1.getCode().equals("840")) {
                            double number = Double.parseDouble(currency1.getRate()) * 50;

                            sendMessage.setText("50$ = " + number+" sum");
                        }
                    }
                }
        else if(inputText.equals("USD 100")) {
            for (Currency currency1 : currencies) {
                if (currency1.getCode().equals("840")) {
                    double number = Double.parseDouble(currency1.getRate()) * 100;

                    sendMessage.setText("100$ = " + number+" sum");
                }
            }
        }
        else if(inputText.equals("EURO 20")) {
            for (Currency currency1 : currencies) {
                if (currency1.getCode().equals("978")) {
                    double number = Double.parseDouble(currency1.getRate()) * 20;

                    sendMessage.setText("20 euro = " + number+" sum");
                }
            }
        }
        else if(inputText.equals("EURO 50")) {
            for (Currency currency1 : currencies) {
                if (currency1.getCode().equals("978")) {
                    double number = Double.parseDouble(currency1.getRate()) * 50;

                    sendMessage.setText("50 euro = " + number+" sum");
                }
            }
        }
        else if(inputText.equals("EURO 100")) {
            for (Currency currency1 : currencies) {
                if (currency1.getCode().equals("978")) {
                    double number = Double.parseDouble(currency1.getRate()) * 100;

                    sendMessage.setText("100 euro = " + number+" sum");
                }
            }
        }
        else if(inputText.equals("YUAN 20")) {
            for (Currency currency1 : currencies) {
                if (currency1.getCode().equals("392")) {
                    double number = Double.parseDouble(currency1.getRate()) * 20;

                    sendMessage.setText("20 yuan = " + number+" sum");
                }
            }
        }
        else if(inputText.equals("YUAN 50")) {
            for (Currency currency1 : currencies) {
                if (currency1.getCode().equals("392")) {
                    double number = Double.parseDouble(currency1.getRate()) * 50;

                    sendMessage.setText("50 yuan = " + number+" sum");
                }
            }
        }
        else if(inputText.equals("YUAN 100")) {
            for (Currency currency1 : currencies) {
                if (currency1.getCode().equals("392")) {
                    double number = Double.parseDouble(currency1.getRate()) *100;

                    sendMessage.setText("100 yuan = " + number+" sum");
                }
            }
        }

        else {
            if (inputText.equals("EURO info")) {
                for (Currency currency : currencies) {
                    if (currency.getCode().equals("978")) {

                        sendMessage.setText("Information for date: "+
                                currency.getDate()+"\n_______________________________\n"+"\nRussian name: "+currency.getCcyNmRU()+
                                "\n_______________________________\n"+
                                "\n1 EURO = "+currency.getRate()+" SUM"+"\n_______________________________\n"+
                                "\nChanged for: +("+currency.getDiff()+") SUM"+
                                "\n_______________________________\n");



                    }
                }

            }


            else if (inputText.equals("YUAN info")) {
                Random rand = new Random();
                int answ = rand.nextInt(10) + 1;
                System.out.println(answ);

                for (Currency currency : currencies) {
                    if (currency.getCode().equals("392")) {
                        sendMessage.setText("Information for date: "+
                                currency.getDate()+"\n_______________________________\n"+"\nRussian name: "+currency.getCcyNmRU()+
                                "\n_______________________________\n"+
                                "\n1 EURO = "+currency.getRate()+" SUM"+"\n_______________________________\n"+
                                "\nChanged for: +("+currency.getDiff()+") SUM"+
                                "\n_______________________________\n");

                    }
                }


            } else if (inputText.equals("USD info")) {
                for (Currency currency : currencies) {
                    if (currency.getCode().equals("840")) {
                        sendMessage.setText("Information for date: "+
                                currency.getDate()+"\n_______________________________\n"+"\nRussian name: "+currency.getCcyNmRU()+
                                "\n_______________________________\n"+
                                "\n1 EURO = "+currency.getRate()+" SUM"+"\n_______________________________\n"+
                                "\nChanged for: +("+currency.getDiff()+") SUM"+
                                "\n_______________________________\n");

                    }
                }
            } else {
                sendMessage.setText(inputText+"⁉️");
            }
        }
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);  //size equals to screen
        replyKeyboardMarkup.setOneTimeKeyboard(false);  //button disappears after selecting

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow keyboardRowfirst = new KeyboardRow();
        KeyboardRow keyboardRowsecond = new KeyboardRow();
        KeyboardRow keyboardfourth = new KeyboardRow();


        keyboardRowfirst.add(new KeyboardButton("Exchange"));
        keyboardRowsecond.add(new KeyboardButton("USD info"));
        keyboardRowsecond.add(new KeyboardButton("EURO info"));
        keyboardRowsecond.add(new KeyboardButton("YUAN info"));



        keyboard.add(keyboardRowfirst);
        keyboard.add(keyboardRowsecond);
        keyboard.add(keyboardfourth);

        replyKeyboardMarkup.setKeyboard(keyboard);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}