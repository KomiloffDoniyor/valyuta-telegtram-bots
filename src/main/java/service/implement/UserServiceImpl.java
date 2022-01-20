package service.implement;

import model.User;
import repository.UserRepository;
import repository.implement.UserRepositoryImpl;
import service.UserService;

public class UserServiceImpl implements UserService {
    public static UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public boolean exitsByChatId(Long chatId) {
        return userRepository.exitsByChatId(chatId);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
