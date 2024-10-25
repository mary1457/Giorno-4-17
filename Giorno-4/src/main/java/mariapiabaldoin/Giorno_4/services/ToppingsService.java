package mariapiabaldoin.Giorno_4.services;

import lombok.extern.slf4j.Slf4j;
import mariapiabaldoin.Giorno_4.entities.Topping;
import mariapiabaldoin.Giorno_4.repositories.ToppingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ToppingsService {

    @Autowired
    private ToppingsRepository toppingRepository;


    public void saveTopping(Topping newTopping) {
        toppingRepository.save(newTopping);
        log.info("Il topping " + newTopping.getNome() + " è stato salvato correttamente!");
    }


    public Optional<Topping> findById(long toppingId) {
        return toppingRepository.findById(toppingId);
    }


    public void findByIdAndUpdate(long toppingId, Topping updatedTopping) {
        Optional<Topping> foundTopping = this.findById(toppingId);

        if (foundTopping.isPresent()) {
            Topping topping = foundTopping.get();
            topping.setNome(updatedTopping.getNome());
            topping.setInformazioniNutrizionali(updatedTopping.getInformazioniNutrizionali());
            topping.setPrezzo(updatedTopping.getPrezzo());

            toppingRepository.save(topping);
            log.info("Il topping con id " + toppingId + " è stato modificato correttamente");
        } else {
            log.warn("Topping con id " + toppingId + " non trovato");
        }
    }


    public void findByIdAndDelete(long toppingId) {
        Optional<Topping> foundTopping = this.findById(toppingId);

        if (foundTopping.isPresent()) {
            toppingRepository.delete(foundTopping.get());
            log.info("Il topping con id " + toppingId + " è stato cancellato correttamente");
        } else {
            log.warn("Topping con id " + toppingId + " non trovato");
        }
    }
}

