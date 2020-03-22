package by.darozhka.ReslivTelegramBot.dao;

import by.darozhka.ReslivTelegramBot.dao.bean.Bean;

public interface Dao<T extends Bean> {
    T create (T t);
    T update (T t);
    boolean delete (long id);
    T find(long id);
}
