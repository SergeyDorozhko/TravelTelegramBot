package by.darozhka.ReslivTelegramBot.repository;

import by.darozhka.ReslivTelegramBot.repository.bean.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuideRepository extends JpaRepository<Guide, Long> {

    Optional<Guide> findByCity(String city);
}
