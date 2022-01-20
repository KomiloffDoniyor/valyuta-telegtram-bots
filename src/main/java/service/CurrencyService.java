package service;

import model.Currency;

import java.sql.SQLException;
import java.util.List;

public interface CurrencyService {

    Currency save(Currency currency);

    void saveAll(List<Currency> currencies) throws SQLException;

    List<Currency> findAll();

    Currency findByChatId(Long chatId);


}
