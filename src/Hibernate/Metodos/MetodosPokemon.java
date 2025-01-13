package Hibernate.Metodos;

import Datos.Adestrador;
import Datos.Pokedex;
import Datos.Pokemon;
import Hibernate.Utilidad.Utilidad;
import org.hibernate.query.NativeQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Date;
import java.util.List;

public class MetodosPokemon {

    /**
     * Insertar 12 pokemons en la tabla pokemon(6 para cada Adestrador)
     */
    public void insertarPokemons(String nome, Date nacemento, int pokedexEntryId, int adestradorId) {
        try (Session session = Utilidad.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();


            Pokedex pokedexEntry = session.get(Pokedex.class, pokedexEntryId);
            Adestrador adestrador = session.get(Adestrador.class, adestradorId);


            if (pokedexEntry != null && adestrador != null) {
                Pokemon pokemon = new Pokemon();
                pokemon.setNome(nome);
                pokemon.setNacemento(nacemento);
                pokemon.setPokemonentry(pokedexEntry);
                pokemon.setAdestrador(adestrador);


                session.save(pokemon);
                transaction.commit();
                System.out.println("Pokemon creado exitosamente");
            } else {
                System.out.println("Pokedex entry o Adestrador no encontrados");
            }
        } catch (Exception e) {
            System.out.println("Error al crear el pokemon: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Pokemon> listarPokemons(){
        List<Pokemon> pokemons = null;
        try(Session session = Utilidad.getSessionFactory().openSession()){
            Query<Pokemon> query = session.createQuery("from Pokemon", Pokemon.class);
            pokemons = query.list();
            pokemons.forEach(System.out::println);
        } catch (Exception e){
            System.out.println("Error al listar los pokemons: "+e.getMessage());
        }
        return pokemons;
    }

    public Pokemon obtenerPokemonPorId(int id){
        Pokemon pokemon = null;
        try(Session session = Utilidad.getSessionFactory().openSession()){
            pokemon = session.createQuery("FROM Pokemon WHERE id = :id", Pokemon.class)
                    .setParameter("id", id)
                    .uniqueResult();
            session.close();
        } catch (Exception e){
            System.out.println("Error al obtener el pokemon: "+e.getMessage());
        }
        return pokemon;
    }




    public void borrarTablaPokemon() {
        try (Session session = Utilidad.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            NativeQuery<?> query = session.createNativeQuery("DELETE FROM pokemon");
            session.createNativeQuery("ALTER SEQUENCE pokemon_id_seq RESTART WITH 1").executeUpdate();
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al borrar la tabla --> " + e.getMessage());
        }
    }


}
