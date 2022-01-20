package service;

import com.google.gson.Gson;
import model.Currency;
import service.implement.CurrencyServiceImpl;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StoreDataToDbFromJson {

    public static void store() throws FileNotFoundException, SQLException {

        Gson gson = new Gson();
        List<Currency> currencyList = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/main/resources/currencies.json")))){
            Currency[] currencies = gson.fromJson(bufferedReader, Currency[].class);
            currencyList.addAll(Arrays.asList(currencies));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CurrencyService currencyService = new CurrencyServiceImpl();
        currencyService.saveAll(currencyList);

    }

}
