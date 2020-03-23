package by.darozhka.ReslivTelegramBot.repository.modelMapper;


import by.darozhka.ReslivTelegramBot.repository.bean.Bean;
import by.darozhka.ReslivTelegramBot.service.dto.BeanDto;


public interface Mapper<K extends BeanDto, T extends Bean> {
    K toDTO(T bean);

    T toBean(K dto);
}
