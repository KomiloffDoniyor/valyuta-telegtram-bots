package repository.implement;

import model.Currency;
import repository.CurrencyRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static config.DbConfig.connection;

public class CurrencyRepositoryImpl implements CurrencyRepository {


    @Override
    public boolean exitsById(Long id) throws SQLException {

        String SELECT_CURRENCY_ID = "SELECT * FROM currencies where id = " + id;
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CURRENCY_ID);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
//        if(resultSet.next()){
//            return new Currency(
//                    resultSet.getLong("id"),
//                    resultSet.getString("code"),
//                    resultSet.getString("ccy"),
//                    resultSet.getString("ccy_nm_ru"),
//                    resultSet.getString("ccy_nm_uz"),
//                    resultSet.getString("ccy_nm_uzc"),
//                    resultSet.getString("ccy_nm_en"),
//                    resultSet.getString("nominal"),
//                    resultSet.getString("rate"),
//                    resultSet.getString("diff"),
//                    resultSet.getString("date")
//            );
//        }


    }

    @Override
    public void saveAll(List<Currency> currencies) throws SQLException {

        for (Currency currency : currencies) {
            if (!exitsById(currency.getId())) {
                String INSERT_NEW_CURRENCY = "INSERT INTO currencies(code, ccy, ccy_nm_ru, ccy_nm_uz, ccy_nm_uzc, ccy_nm_en, nominal, rate, diff, date) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_CURRENCY);
                preparedStatement.setString(1, currency.getCode());
                preparedStatement.setString(2, currency.getCcy());
                preparedStatement.setString(3, currency.getCcyNm_RU());
                preparedStatement.setString(4, currency.getCcyNm_UZ());
                preparedStatement.setString(5, currency.getCcyNm_UZC());
                preparedStatement.setString(6, currency.getCcyNm_EN());
                preparedStatement.setString(7, currency.getNominal());
                preparedStatement.setString(8, currency.getRate());
                preparedStatement.setString(9, currency.getDiff());
                preparedStatement.setString(10, currency.getDate());
                preparedStatement.executeUpdate();
            }
        }

    }
}
