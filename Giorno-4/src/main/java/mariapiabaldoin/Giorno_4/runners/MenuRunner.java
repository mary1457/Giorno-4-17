package mariapiabaldoin.Giorno_4.runners;

import lombok.extern.slf4j.Slf4j;
import mariapiabaldoin.Giorno_4.MenuConfig;
import mariapiabaldoin.Giorno_4.entities.Bevanda;
import mariapiabaldoin.Giorno_4.entities.Pizza;
import mariapiabaldoin.Giorno_4.entities.Topping;
import mariapiabaldoin.Giorno_4.services.BevandeService;
import mariapiabaldoin.Giorno_4.services.PizzeService;
import mariapiabaldoin.Giorno_4.services.ToppingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MenuRunner implements CommandLineRunner {

    @Autowired
    private PizzeService pizzeService;

    @Autowired
    private ToppingsService toppingsService;

    @Autowired
    private BevandeService bevandaService;

    @Autowired
    private MenuConfig menuConfig;

    @Override
    public void run(String... args) {


        Topping tomato = menuConfig.tomato();
        Topping cheese = menuConfig.cheese();
        Topping ham = menuConfig.ham();
        Topping pineapple = menuConfig.pineapple();
        Topping salame = menuConfig.salame();

        Pizza margherita = menuConfig.pizzaMargherita();
        Pizza hawaiian = menuConfig.pizzaHawaiian();

        Bevanda lemonade = menuConfig.lemonade();
        Bevanda water = menuConfig.water();
        Bevanda wine = menuConfig.wine();


        toppingsService.saveTopping(tomato);
        toppingsService.saveTopping(cheese);
        toppingsService.saveTopping(ham);
        toppingsService.saveTopping(pineapple);
        toppingsService.saveTopping(salame);


        pizzeService.savePizza(margherita);
        pizzeService.savePizza(hawaiian);


        bevandaService.saveBevanda(lemonade);
        bevandaService.saveBevanda(water);
        bevandaService.saveBevanda(wine);

        log.info("Tutti gli elementi del menu sono stati salvati correttamente nel database.");
    }
}
