package mariapiabaldoin.Giorno_4.services;

import lombok.extern.slf4j.Slf4j;
import mariapiabaldoin.Giorno_4.entities.Pizza;
import mariapiabaldoin.Giorno_4.repositories.PizzeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class PizzeService {

    @Autowired
    private PizzeRepository pizzeRepository;


    public void savePizza(Pizza newPizza) {
        pizzeRepository.save(newPizza);
        log.info("La pizza " + newPizza.getNome() + " è stata salvata correttamente!");
    }


    public Optional<Pizza> findById(long pizzaId) {
        return pizzeRepository.findById(pizzaId);
    }


    public void findByIdAndUpdate(long pizzaId, Pizza updatedPizza) {
        Optional<Pizza> foundPizza = this.findById(pizzaId);

        if (foundPizza.isPresent()) {
            Pizza pizza = foundPizza.get();
            pizza.setNome(updatedPizza.getNome());
            pizza.setInformazioniNutrizionali(updatedPizza.getInformazioniNutrizionali());
            pizza.setPrezzo(updatedPizza.getPrezzo());
            pizza.setToppings(updatedPizza.getToppings());

            pizzeRepository.save(pizza);
            log.info("La pizza con id " + pizzaId + " è stata modificata correttamente");
        } else {
            log.warn("Pizza con id " + pizzaId + " non trovata");
        }
    }


    public void findByIdAndDelete(long pizzaId) {
        Optional<Pizza> foundPizza = this.findById(pizzaId);

        if (foundPizza.isPresent()) {
            pizzeRepository.delete(foundPizza.get());
            log.info("La pizza con id " + pizzaId + " è stata cancellata correttamente");
        } else {
            log.warn("Pizza con id " + pizzaId + " non trovata");
        }
    }
}
