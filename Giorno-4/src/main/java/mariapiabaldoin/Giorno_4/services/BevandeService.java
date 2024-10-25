package mariapiabaldoin.Giorno_4.services;

import lombok.extern.slf4j.Slf4j;
import mariapiabaldoin.Giorno_4.entities.Bevanda;
import mariapiabaldoin.Giorno_4.repositories.BevandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class BevandeService {

    @Autowired
    private BevandeRepository bevandeRepository;


    public void saveBevanda(Bevanda newBevanda) {
        bevandeRepository.save(newBevanda);
        log.info("La bevanda " + newBevanda.getNome() + " è stata salvata correttamente!");
    }


    public Optional<Bevanda> findById(long bevandaId) {
        return bevandeRepository.findById(bevandaId);
    }


    public void findByIdAndUpdate(long bevandaId, Bevanda updatedBevanda) {
        Optional<Bevanda> foundBevanda = this.findById(bevandaId);

        if (foundBevanda.isPresent()) {
            Bevanda bevanda = foundBevanda.get();
            bevanda.setNome(updatedBevanda.getNome());
            bevanda.setInformazioniNutrizionali(updatedBevanda.getInformazioniNutrizionali());
            bevanda.setPrezzo(updatedBevanda.getPrezzo());

            bevandeRepository.save(bevanda);
            log.info("La bevanda con id " + bevandaId + " è stata modificata correttamente");
        } else {
            log.warn("Bevanda con id " + bevandaId + " non trovata");
        }
    }


    public void findByIdAndDelete(long bevandaId) {
        Optional<Bevanda> foundBevanda = this.findById(bevandaId);

        if (foundBevanda.isPresent()) {
            bevandeRepository.delete(foundBevanda.get());
            log.info("La bevanda con id " + bevandaId + " è stata cancellata correttamente");
        } else {
            log.warn("Bevanda con id " + bevandaId + " non trovata");
        }
    }
}
