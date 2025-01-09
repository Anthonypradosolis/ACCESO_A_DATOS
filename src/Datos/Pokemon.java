package Datos;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Pokemon")
public class Pokemon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JacksonXmlProperty(isAttribute = true)
    @JsonProperty("id")
    private int id;

    @Column(name = "nome")
    @JacksonXmlProperty
    @JsonProperty("nome")
    private String nome;

    @Column(name ="nacemento")
    @JacksonXmlProperty
    @JsonProperty("nacemento")
    private Date nacemento;

    @ManyToOne
    @JoinColumn(name ="pokedexentry",referencedColumnName = "id", nullable = true)
    private Pokedex pokemonentry;

    @ManyToOne
    @JoinColumn(name ="adestrador",referencedColumnName = "id", nullable = true)
    private Adestrador adestrador;

    public Pokemon() {
    }

    public Pokemon(String nome, Date nacemento, Pokedex pokemonentry, Adestrador adestrador) {
        this.nome = nome;
        this.nacemento = nacemento;
        this.pokemonentry = pokemonentry;
        this.adestrador = adestrador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNacemento() {
        return nacemento;
    }

    public void setNacemento(Date nacemento) {
        this.nacemento = nacemento;
    }

    public Pokedex getPokemonentry() {
        return pokemonentry;
    }

    public void setPokemonentry(Pokedex pokemonentry) {
        this.pokemonentry = pokemonentry;
    }

    public Adestrador getAdestrador() {
        return adestrador;
    }

    public void setAdestrador(Adestrador adestrador) {
        this.adestrador = adestrador;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nacemento=" + nacemento +
                ", pokemonentry=" + pokemonentry +
                ", adestrador=" + adestrador +
                '}';
    }
}
