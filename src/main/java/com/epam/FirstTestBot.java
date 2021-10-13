package com.epam;

import com.epam.tasks.Task;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Arrays;
import java.util.List;

import static com.epam.Util.sendMessage;

public class FirstTestBot extends TelegramLongPollingBot {
    private Task task;

    public static final String START = "/start";

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {

        // check for new message
        if (update.hasMessage()) {
            Message message = update.getMessage();

            // check if new message is text
            if (message.hasText()) {
                String text = message.getText();
                Long chatId = message.getChatId();

                if (text.equals(START)) {
                    execute(sendMessage("/mol - n mol\n/molConc - molar concentration", chatId));
                } else if (Aliases.getMap().containsKey(text)) {
                    task = Aliases.getMap().get(text);
                    execute(sendMessage(task.message(), chatId));
                }
                else {
                    if (task != null) {
                        List<String> data = Arrays.asList(text.split(" "));
                        if (task.validate(data)) execute(sendMessage(task.calculate(), chatId));
                    } else {
                        execute(sendMessage("Another task?", chatId));
                    }
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return null;
    }

    @Override
    public String getBotToken() {
        return System.getenv("token");
    }

}
