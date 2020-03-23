package by.darozhka.ReslivTelegramBot.controller;

import by.darozhka.ReslivTelegramBot.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@PropertySource("classpath:telegramBot.properties")
public class BotController extends TelegramLongPollingBot {
    private static final String BOT_NAME = "bot.name";
    private static final String BOT_TOKEN = "bot.token";
    private static final String START_COMMAND = "/start";
    private static final String BOT_GREETING = "bot.greeting";

    private GuideService service;

    private Environment env;

    @Autowired
    public BotController(GuideService service, Environment env) {
        super();
        this.service = service;
        this.env = env;
    }


    @Override
    public String getBotToken() {
        return env.getProperty(BOT_TOKEN);
    }

    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        sendMessage(update.getMessage().getChatId().toString(), message);
    }

    private void sendMessage(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        if (s.equals(START_COMMAND)) {
            sendMessage.setText(env.getProperty(BOT_GREETING));
        } else {
            sendMessage.setText(
                    service.find(s));
        }
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {

        }
    }


    @Override
    public String getBotUsername() {
        return env.getProperty(BOT_NAME);
    }
}
