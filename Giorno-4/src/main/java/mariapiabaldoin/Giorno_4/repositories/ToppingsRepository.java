package mariapiabaldoin.Giorno_4.repositories;


import mariapiabaldoin.Giorno_4.entities.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ToppingsRepository extends JpaRepository<Topping, Long> {
}

