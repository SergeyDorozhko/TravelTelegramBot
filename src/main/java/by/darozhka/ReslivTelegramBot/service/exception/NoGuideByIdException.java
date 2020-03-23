package by.darozhka.ReslivTelegramBot.service.exception;

public class NoGuideByIdException extends ServiceException {

    private static final String MESSAGE = "No guide with id: ";
    public NoGuideByIdException(long id) {
        super(MESSAGE + id);
    }
}
