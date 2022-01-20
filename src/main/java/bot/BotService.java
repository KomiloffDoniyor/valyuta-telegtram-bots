package bot;

import enums.BotState;
import model.User;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import service.UserService;
import service.implement.UserServiceImpl;
import util.AboutBot;
import util.BotMenu;

import java.util.ArrayList;
import java.util.List;

public class BotService {

    public static UserService userService = new UserServiceImpl();

    public static SendMessage start(Update update) {

        registerUser(update);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        sendMessage.setText(AboutBot.INFO);
        sendMessage.setReplyMarkup(getMenuKeyboard());

        return sendMessage;
    }

    private static ReplyKeyboard getMenuKeyboard() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton(BotMenu.MENU));
        rows.add(keyboardRow1);

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(new KeyboardButton(BotMenu.HistoryOfOperations));
        keyboardRow2.add(new KeyboardButton(BotMenu.Settings));
        rows.add(keyboardRow2);

        replyKeyboardMarkup.setKeyboard(rows);
        return replyKeyboardMarkup;
    }
    private static void registerUser(Update update) {

        org.telegram.telegrambots.meta.api.objects.User from = update.getMessage().getFrom();
        if(!userService.exitsByChatId(update.getMessage().getChatId())){
           User user = new User(
                   update.getMessage().getChatId(),
                   from.getFirstName(),
                   from.getLastName(),
                   from.getUserName(),
                   update.getMessage().getContact() != null ? update.getMessage().getContact().getPhoneNumber(): "",
                   BotState.START
           );
           userService.save(user);
        }
    }
}
