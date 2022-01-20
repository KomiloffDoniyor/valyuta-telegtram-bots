package repository.implement;

import model.User;
import repository.UserRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static config.DbConfig.connection;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public boolean exitsByChatId(Long chatId) {
        String SELECT_FIND_ID = "SELECT * FROM users where chat_id = " + chatId;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FIND_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void save(User user) {
        String INSERT_USER = "INSERT INTO users(chat_id, first_name, last_name, user_name, phone, bot_state) values (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setLong(1, user.getChatId());
            preparedStatement.setString(2, user.getFirstname());
            preparedStatement.setString(3, user.getLastname());
            preparedStatement.setString(4, user.getUsername());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getBotState().name());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
