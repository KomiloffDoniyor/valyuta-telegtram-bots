import bot.AppValuate;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import service.StoreDataToDbFromJson;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, SQLException {
        StoreDataToDbFromJson.store();

        try {
            TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
            api.registerBot(new AppValuate());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
