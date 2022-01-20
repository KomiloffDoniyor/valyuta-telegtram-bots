package repository;

import model.User;

public interface UserRepository {

    boolean exitsByChatId(Long chatId);

    void save(User user);
}
