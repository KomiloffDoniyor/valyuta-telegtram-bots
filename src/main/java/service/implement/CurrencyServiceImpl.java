package service.implement;

import model.Currency;
import repository.CurrencyRepository;
import repository.implement.CurrencyRepositoryImpl;
import service.CurrencyService;

import java.sql.SQLException;
import java.util.List;

public class CurrencyServiceImpl implements CurrencyService {
    public static CurrencyRepository currencyRepository = new CurrencyRepositoryImpl();
    @Override
    public Currency save(Currency currency) {
        return null;
    }

    @Override
    public void saveAll(List<Currency> currencies) throws SQLException {
        currencyRepository.saveAll(currencies);
    }

    @Override
    public List<Currency> findAll() {
        return null;
    }

    @Override
    public Currency findByChatId(Long chatId) {
        return null;
    }
}
