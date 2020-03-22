package by.darozhka.ReslivTelegramBot.service;

import by.darozhka.ReslivTelegramBot.dao.GuideDao;
import by.darozhka.ReslivTelegramBot.dao.modelMapper.GuideMapper;
import by.darozhka.ReslivTelegramBot.service.dto.GuideDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuideServiceImpl implements GuideService {

    private GuideDao dao;
    private GuideMapper mapper;

    @Autowired
    public GuideServiceImpl(GuideDao dao, GuideMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public String find(String name) {
        String cityInfo = null;
        try {
            cityInfo = dao.find(name.toLowerCase());
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            cityInfo = "There is no information about this city.";
        }
        return cityInfo;
    }

    @Override
    public GuideDto create(GuideDto guideDto) {
        return null;
    }

    @Override
    public GuideDto update(GuideDto guideDto) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public GuideDto find(long id) {
        return null;
    }
}
