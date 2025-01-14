package Hibernate.Metodos;

import Datos.Adestrador;
import Datos.Auxiliares.Adestradores;
import Datos.Auxiliares.Pokemons;
import Datos.Pokemon;
import Hibernate.Utilidad.Utilidad;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUtils {

    public <T> void guardarJson(String rutaArchivo, List<T> objetos){
        ObjectMapper mapper = new ObjectMapper();
        try{
            mapper.writeValue(new File(rutaArchivo),objetos);
        }catch (IOException e){
            System.out.println("Error al guardar en JSON"+ e.getMessage());
        }
    }

    public List<Adestrador> leerJSONAdestradores(){
        ObjectMapper mapper = new ObjectMapper();
        Adestradores contenedor = null;
        try{
            contenedor = mapper.readValue(new File("/home/accesodatos/IdeaProjects/ACCESO_A_DATOS/adestradores.json"), Adestradores.class);
            for(Adestrador adestrador: contenedor.getAdestradores()){
                System.out.println(adestrador);
            }
        } catch (IOException e){
            System.out.println("Error al importar JSON"+ e.getMessage());
        }
        return contenedor.getAdestradores();
    }

    public void insertarAdestrador(List<Adestrador> pokeList){
        try(Session session = Utilidad.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            for(Adestrador adestrador: pokeList){
                session.save(adestrador);
            }
            transaction.commit();
            System.out.println("Adestradores insertados en la Pokedex");
        }
    }

    public List<Pokemon> leerJSONPokemon(){
        ObjectMapper mapper = new ObjectMapper();
        Pokemons contenedor = null;
        try{
            contenedor = mapper.readValue(new File("/home/accesodatos/IdeaProjects/ACCESO_A_DATOS/pokemons.json"),Pokemons.class);
            for(Pokemon pokemon : contenedor.getPokemons()){
                System.out.println(pokemon);
            }
        } catch (IOException e){
            System.out.println("Error al importar JSON"+ e.getMessage());
        }
        return contenedor.getPokemons();
    }

    public void insertarPokemonsInPokedex(List<Pokemon> pokeList){
        try(Session session = Utilidad.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            for(Pokemon pokemon: pokeList){
                session.save(pokemon);
            }
            transaction.commit();
            System.out.println("Pokemons insertados en la Pokedex");
        }
    }
}
