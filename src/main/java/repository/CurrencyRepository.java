package repository;

import model.Currency;

import java.sql.SQLException;
import java.util.List;

public interface CurrencyRepository {

    boolean exitsById(Long id) throws SQLException;

    void saveAll(List<Currency> currencies) throws SQLException;

}
