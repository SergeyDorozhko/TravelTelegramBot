package by.darozhka.ReslivTelegramBot.dao.modelMapper;


import by.darozhka.ReslivTelegramBot.dao.bean.Bean;
import by.darozhka.ReslivTelegramBot.service.dto.BeanDto;
import org.modelmapper.ModelMapper;

import java.util.Objects;

public abstract class AbstractMapper<T extends Bean, K extends BeanDto> implements Mapper {
    private ModelMapper modelMapper;

    private Class<T> beanClass;
    private Class<K> dtoClass;


    public AbstractMapper(Class<T> beanClass, Class<K> dtoClass, ModelMapper modelMapper) {
        this.beanClass = beanClass;
        this.dtoClass = dtoClass;
        this.modelMapper = modelMapper;
    }

    public T toBean(BeanDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, beanClass);
    }

    public K toDTO(Bean bean) {
        return Objects.isNull(bean) ? null : modelMapper.map(bean, dtoClass);
    }
}

