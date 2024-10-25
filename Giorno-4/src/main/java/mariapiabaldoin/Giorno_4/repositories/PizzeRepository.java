package mariapiabaldoin.Giorno_4.repositories;

import mariapiabaldoin.Giorno_4.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PizzeRepository extends JpaRepository<Pizza, Long> {
}
