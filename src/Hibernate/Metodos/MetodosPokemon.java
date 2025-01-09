package Hibernate.Metodos;

import Datos.Pokemon;
import Hibernate.Utilidad.Utilidad;
import org.hibernate.query.NativeQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class MetodosPokemon {

    /**
     * Inserta 12 pokemon en la tabla Pokemon(6 para cada adestrador)
     */
    public void insertarPokemon(Pokemon pokemon) {
        try(Session session = Utilidad.getSessionFactory().openSession()){
         Transaction transaction = session.beginTransaction();
         session.save(pokemon);
         transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al insertar los pokemons: " + e.getMessage());
        }
    }

    public List<Pokemon> listarPokemon(){
        List<Pokemon> pokemon = null;
        try(Session session = Utilidad.getSessionFactory().openSession()){
            Query<Pokemon> query = session.createQuery("from Pokemon", Pokemon.class);
            pokemon = query.list();
            pokemon.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error al listar los pokemons: " + e.getMessage());
        }
        return pokemon;
    }

}
