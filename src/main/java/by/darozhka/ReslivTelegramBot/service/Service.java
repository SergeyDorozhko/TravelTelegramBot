package by.darozhka.ReslivTelegramBot.service;

import by.darozhka.ReslivTelegramBot.dao.bean.Bean;
import by.darozhka.ReslivTelegramBot.service.dto.BeanDto;

public interface Service <T extends BeanDto> {
    T create (T t);
    T update (T t);
    boolean delete (long id);
    T find(long id);
}
