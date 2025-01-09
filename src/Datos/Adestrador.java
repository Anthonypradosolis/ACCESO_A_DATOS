package Datos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@Entity
@JacksonXmlRootElement
@Table(name = "Adestrador")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Adestrador implements Serializable {
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
    @Column(name = "nacemento")
    @JacksonXmlProperty
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("nacemento")
    private Date nacemento;

    @OneToMany(mappedBy = "adestrador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonProperty
    private List<Pokemon> pokemons = new ArrayList<>();

    public Adestrador(){

    }
    public Adestrador(int id, String nome, Date nacemento){
        this.id=id;
        this.nome=nome;
        this.nacemento=nacemento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNacemento() {
        return nacemento;
    }

    public void setNacemento(Date nacemento) {
        this.nacemento = nacemento;
    }

    @Override
    public String toString() {
        return "Adestrador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nacemento=" + nacemento +
                '}';
    }
}
