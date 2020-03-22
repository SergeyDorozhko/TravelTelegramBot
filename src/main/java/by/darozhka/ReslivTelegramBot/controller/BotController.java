package by.darozhka.ReslivTelegramBot.controller;

import by.darozhka.ReslivTelegramBot.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class BotController extends TelegramLongPollingBot {
    private GuideService service;

    @Autowired
    public BotController(GuideService service) {
        super();
        this.service = service;
    }


    @Override
    public String getBotToken() {
        return "1097774258:AAF_SEyicYlQI5aTm1dQ8Th0WiIV81HyHXk";
    }

    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        sendMsg(update.getMessage().getChatId().toString(), message);
    }

    private synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(
                service.find(s));
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {

        }
    }


    @Override
    public String getBotUsername() {
        return "HaveToSeeBot";
    }
}
