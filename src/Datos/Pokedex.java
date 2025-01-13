package Datos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@JacksonXmlRootElement
@Table(name = "Pokedex")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pokedex implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JacksonXmlProperty(isAttribute = true)
    @JsonProperty("id")
    private int id;
    @Column(name = "nome")
    @JsonProperty("nome")
    private String nome;
    @Column(name = "peso")
    @JsonProperty("peso")
    private double peso;
    @Column(name = "misc")
    @JsonProperty("misc")
    private String misc;

    @OneToMany(mappedBy = "pokemonentry", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Pokemon> pokemon;

    public Pokedex(){

    }
    public Pokedex(String nome, double peso, String misc){
        this.nome=nome;
        this.peso=peso;
        this.misc=misc;
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getMisc() {
        return misc;
    }

    public void setMisc(String misc) {
        this.misc = misc;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }
    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public String toString() {
        return "Pokedex{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", peso=" + peso +
                ", misc='" + misc + '\'' +
                '}';
    }
}
