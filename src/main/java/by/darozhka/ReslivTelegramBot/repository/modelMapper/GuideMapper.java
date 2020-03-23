package by.darozhka.ReslivTelegramBot.repository.modelMapper;

import by.darozhka.ReslivTelegramBot.repository.bean.Guide;
import by.darozhka.ReslivTelegramBot.service.dto.GuideDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GuideMapper extends AbstractMapper<Guide, GuideDto> {

    @Autowired
    public GuideMapper(ModelMapper modelMapper) {
        super(Guide.class, GuideDto.class, modelMapper);
    }
}

