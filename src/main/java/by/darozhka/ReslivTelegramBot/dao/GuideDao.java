package by.darozhka.ReslivTelegramBot.dao;

import by.darozhka.ReslivTelegramBot.dao.bean.Guide;

public interface GuideDao extends Dao<Guide> {

    String find(String city);
}
