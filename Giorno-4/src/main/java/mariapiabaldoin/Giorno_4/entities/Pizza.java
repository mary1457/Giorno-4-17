package mariapiabaldoin.Giorno_4.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "pizze")
@Getter
@Setter
@NoArgsConstructor

public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int informazioniNutrizionali;

    @Column(nullable = false)
    private double prezzo;

    @ManyToMany
    @JoinTable(name = "topping_pizze", joinColumns = @JoinColumn(name = "pizze"), inverseJoinColumns = @JoinColumn(name = "toppings"))
    private List<Topping> toppings;


    public Pizza(String nome, int informazioniNutrizionali, double prezzo, List<Topping> toppings) {
        this.nome = nome;
        this.informazioniNutrizionali = informazioniNutrizionali;
        this.prezzo = prezzo;
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Pizza{nome='" + nome + "', informazioni nutrizionali=" + informazioniNutrizionali + ", prezzo=" + prezzo + ", toppings=" + toppings + "}";
    }
}
