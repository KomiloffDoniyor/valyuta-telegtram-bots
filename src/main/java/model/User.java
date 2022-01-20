package model;

import enums.BotState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private Long chatId;
    private String firstname;
    private String lastname;
    private String username;
    private String phone;
    private BotState botState;

    public User(Long chatId, String firstname, String lastname, String username, String phone, BotState botState) {
        this.chatId = chatId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.phone = phone;
        this.botState = botState;
    }
}
