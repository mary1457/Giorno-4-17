package mariapiabaldoin.Giorno_4.repositories;

import mariapiabaldoin.Giorno_4.entities.Bevanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BevandeRepository extends JpaRepository<Bevanda, Long> {
}
