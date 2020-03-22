package by.darozhka.ReslivTelegramBot.service;

import by.darozhka.ReslivTelegramBot.service.dto.GuideDto;

public interface GuideService extends Service<GuideDto> {
    String find(String name);
}
