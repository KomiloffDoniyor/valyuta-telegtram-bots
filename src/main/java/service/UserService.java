package service;

import model.User;

public interface UserService {
    boolean exitsByChatId(Long chatId);

    void save(User user);
}
