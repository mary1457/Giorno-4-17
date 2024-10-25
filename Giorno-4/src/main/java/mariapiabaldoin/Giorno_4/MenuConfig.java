package mariapiabaldoin.Giorno_4;


import mariapiabaldoin.Giorno_4.entities.Bevanda;
import mariapiabaldoin.Giorno_4.entities.Pizza;
import mariapiabaldoin.Giorno_4.entities.Topping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class MenuConfig {

    @Bean
    public Topping tomato() {
        return new Topping("Tomato", 0, 0);
    }


    @Bean
    public Topping cheese() {
        return new Topping("Cheese", 92, 0.69);
    }

    @Bean
    public Topping ham() {
        return new Topping("Ham", 35, 0.99);
    }

    @Bean
    public Topping onions() {
        return new Topping("Onions", 22, 0.69);
    }

    @Bean
    public Topping pineapple() {
        return new Topping("Pineapple", 24, 0.79);
    }

    @Bean
    public Topping salame() {
        return new Topping("Salame", 86, 0.99);
    }


    @Bean
    public Pizza pizzaMargherita() {
        List<Topping> tList = new ArrayList<>();
        tList.add(tomato());
        tList.add(cheese());

        return new Pizza("Margherita", 1104, 4.99, tList);
    }

    @Bean
    public Pizza pizzaHawaiian() {
        List<Topping> tList = new ArrayList<>();
        tList.add(tomato());
        tList.add(cheese());
        tList.add(ham());
        tList.add(pineapple());
        return new Pizza("Hawaiian", 1024, 6.49, tList);
    }

    @Bean
    public Pizza pizzaSalame() {
        List<Topping> tList = new ArrayList<>();
        tList.add(tomato());
        tList.add(cheese());
        tList.add(salame());


        return new Pizza("Salame", 1160, 5.99, tList);
    }


    @Bean
    public Bevanda lemonade() {
        return new Bevanda("Lemonade", 128, 1.29);
    }

    @Bean
    public Bevanda water() {
        return new Bevanda("Water", 0, 1.29);
    }

    @Bean
    public Bevanda wine() {
        return new Bevanda("Wine", 607, 7.49);
    }


}


