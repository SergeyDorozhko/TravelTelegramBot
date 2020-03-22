package by.darozhka.ReslivTelegramBot;

import by.darozhka.ReslivTelegramBot.controller.BotController;
import by.darozhka.ReslivTelegramBot.service.GuideService;
import by.darozhka.ReslivTelegramBot.service.GuideServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

@SpringBootApplication
public class ReslivTelegramBotApplication {


    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(ReslivTelegramBotApplication.class, args);

    }

}
