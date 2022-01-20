package bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import util.BotMenu;
import util.BotSettings;

public class AppValuate extends TelegramLongPollingBot {

    @Override
    public String getBotToken() {
        return BotSettings.TOKEN;
    }

    @Override
    public String getBotUsername() {
        return BotSettings.USERNAME;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()){
            Message message = update.getMessage();
            SendMessage sendMessage = null;

            if(message.hasText()){
                String text = message.getText();
                switch (text){
                    case BotMenu.START:
                        sendMessage = BotService.start(update);
                        break;
                }

            }
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }else if(update.hasCallbackQuery()){

        }
    }
}
