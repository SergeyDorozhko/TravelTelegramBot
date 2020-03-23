package by.darozhka.ReslivTelegramBot.service;


import by.darozhka.ReslivTelegramBot.controller.configuration.ControllerConfig;
import by.darozhka.ReslivTelegramBot.repository.GuideRepository;
import by.darozhka.ReslivTelegramBot.repository.configuration.RepositoryConfig;
import by.darozhka.ReslivTelegramBot.service.configuration.ServiceConfig;
import by.darozhka.ReslivTelegramBot.service.dto.GuideDto;
import by.darozhka.ReslivTelegramBot.service.exception.ServiceException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.telegram.telegrambots.ApiContextInitializer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RepositoryConfig.class, ServiceConfig.class, ControllerConfig.class})
@Transactional
public class GuideServiceTest {
    static {
        ApiContextInitializer.init();
    }

    @Autowired
    GuideService guideService;

    @Autowired
    GuideRepository repository;

    @Test
    public void findByIdTestPositive() {
        GuideDto guide = guideService.find(2);
        String expectedCity = "minsk";
        Assert.assertEquals(expectedCity, guide.getCity()); //if error first of all check init file.
    }


    @Test(expected = ServiceException.class)
    public void findByIdTestNegative() {
        GuideDto guide = guideService.find(200);
    }


    @Test
    @Rollback
    public void createTestPositive() {

        long allBeforeCreate = repository.findAll().size();

        GuideDto guideDto = new GuideDto();
        guideDto.setCity("TestCity");
        guideDto.setCityInfo("TestInfo");


        guideService.create(guideDto);

        long actual = repository.findAll().size();
        Assert.assertEquals( allBeforeCreate + 1, actual);

    }


    @Test(expected = DataIntegrityViolationException.class)
    public void createTestNegative() {

        GuideDto guideDto = new GuideDto();
        guideDto.setCityInfo("TestInfo");
        guideService.create(guideDto);
    }


    @Test
    @Rollback
    public void updateTest() {

        GuideDto guideDto = guideService.find(1);
        guideDto.setCity("TestCity");
        guideDto.setCityInfo("TestInfo");

        guideService.update(guideDto);

        GuideDto actual = guideService.find(1);
        Assert.assertEquals(guideDto, actual);
    }


    @Test
    @Rollback
    public void deleteTestPositive() {

        long allBeforeCreate = repository.findAll().size();

        guideService.delete(1);

        long actual = repository.findAll().size();
        Assert.assertEquals(allBeforeCreate - 1, actual);

    }


    @Test(expected = EmptyResultDataAccessException.class)
    public void deleteTestNegative() {

        guideService.delete(-2);

    }


    @Test
    public void findByCityExist() {
        String expected = "I want to recommend for You to visit the museum of Second World War and you do not have to visit the National Library.";
        String actual = guideService.find("minsk");

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void findByCityNotExist() {
        String expected = "There is no information about this city.";
        String actual = guideService.find("test");

        Assert.assertEquals(expected, actual.substring(0,40));
    }
}
