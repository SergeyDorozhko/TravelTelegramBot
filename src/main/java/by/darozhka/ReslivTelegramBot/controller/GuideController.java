package by.darozhka.ReslivTelegramBot.controller;

import by.darozhka.ReslivTelegramBot.service.GuideService;
import by.darozhka.ReslivTelegramBot.service.dto.GuideDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@Validated
@RequestMapping("/guides")
public class GuideController {
    private static final String ID_MUST_BE_POSITIVE = "Id must be positive.";

    private GuideService service;

    @Autowired
    public GuideController(GuideService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public GuideDto findById(@Valid
                             @PathVariable
                             @Positive(message = ID_MUST_BE_POSITIVE)
                                     long id) {
        return service.find(id);
    }


    @PostMapping
    public GuideDto create(@Valid
                           @RequestBody
                                   GuideDto guideDto) {
        return service.create(guideDto);
    }

    @PutMapping
    public GuideDto update(@Valid
                           @RequestBody
                                   GuideDto guideDto) {
        return service.update(guideDto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@Valid
                       @PathVariable
                       @Positive(message = ID_MUST_BE_POSITIVE)
                               long id) {
        service.delete(id);
    }
}
