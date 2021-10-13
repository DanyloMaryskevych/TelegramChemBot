package com.epam;

import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class Util {

    public static SendMessage sendMessage(String message, Long chatId) {
        SendMessage sendNewMessage = new SendMessage();

        sendNewMessage.setText(message);
        sendNewMessage.setParseMode(ParseMode.MARKDOWN);
        sendNewMessage.setChatId(chatId);

        return sendNewMessage;
    }
}
