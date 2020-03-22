package by.darozhka.ReslivTelegramBot.dao;

import by.darozhka.ReslivTelegramBot.dao.bean.Guide;
import by.darozhka.ReslivTelegramBot.dao.bean.Guide_;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class GuideDaoImpl implements GuideDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public String find(String city) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
        Root<Guide> root = criteriaQuery.from(Guide.class);

        criteriaQuery.select(root.get(Guide_.CITY_INFO)).where(criteriaBuilder.equal(root.get(Guide_.CITY), city));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public Guide create(Guide guide) {
        return null;
    }

    @Override
    public Guide update(Guide guide) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public Guide find(long id) {
        return null;
    }
}
