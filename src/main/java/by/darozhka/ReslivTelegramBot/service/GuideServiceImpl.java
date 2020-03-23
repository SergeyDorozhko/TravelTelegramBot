package by.darozhka.ReslivTelegramBot.service;

import by.darozhka.ReslivTelegramBot.repository.GuideRepository;
import by.darozhka.ReslivTelegramBot.repository.bean.Guide;
import by.darozhka.ReslivTelegramBot.repository.modelMapper.GuideMapper;
import by.darozhka.ReslivTelegramBot.service.dto.GuideDto;
import by.darozhka.ReslivTelegramBot.service.exception.NoGuideByIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GuideServiceImpl implements GuideService {
    private static final String CITY_NOT_FOUND = "There is no information about this city. Available cities: ";
    private GuideRepository repository;
    private GuideMapper mapper;

    @Autowired
    public GuideServiceImpl(GuideRepository repository, GuideMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public String find(String city) {
        Optional<Guide> guide = repository.findByCity(city.toLowerCase());
        if (guide.isPresent()) {
            return guide.get().getCityInfo();
        }
        return CITY_NOT_FOUND
                + repository.findAll().stream()
                .map(cityGuide -> cityGuide.getCity())
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public GuideDto create(GuideDto guideDto) {
        return mapper.toDTO(
                repository.save(
                        mapper.toBean(guideDto)));
    }

    @Transactional
    @Override
    public GuideDto update(GuideDto guideDto) {
        return create(guideDto);
    }

    @Transactional
    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public GuideDto find(long id) {
        Optional<Guide> guide = repository.findById(id);
        if (guide.isPresent()) {
            return mapper.toDTO(guide.get());
        }
        throw new NoGuideByIdException(id);
    }
}
