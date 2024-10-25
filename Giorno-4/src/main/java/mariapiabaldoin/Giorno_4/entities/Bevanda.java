package mariapiabaldoin.Giorno_4.entities;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bevande")
@Getter
@Setter
@NoArgsConstructor


public class Bevanda {

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

    public Bevanda(String nome, int informazioniNutrizionali, double prezzo) {
        this.nome = nome;
        this.informazioniNutrizionali = informazioniNutrizionali;
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Bevanda{nome='" + getNome() + "', informazioni nutrizionali=" + getInformazioniNutrizionali() + ", prezzo=" + getPrezzo() + "}";
    }
}

