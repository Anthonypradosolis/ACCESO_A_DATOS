import Datos.Adestrador;
import Datos.Pokedex;
import Datos.Pokemon;
import Hibernate.Metodos.*;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        MetodosAdestrador metodosAdestrador = new MetodosAdestrador();
        MetodosPokemon metodosPokemon = new MetodosPokemon();
        MetodosPokedex metodosPokedex = new MetodosPokedex();

/**
        Adestrador adestrador1 = new Adestrador(1, "Ash", Date.valueOf("1990-05-22"));
        Adestrador adestrador2 = new Adestrador(2, "Misty", Date.valueOf("1992-07-04"));

        metodosAdestrador.crearAdestrador(adestrador1);
        metodosAdestrador.crearAdestrador(adestrador2);


        metodosPokedex.crearPokemon_enPokedex (new Pokedex("Pikachu", 6.0, "Electric type"));
        metodosPokedex.crearPokemon_enPokedex (new Pokedex("Bulbasaur", 7.0, "Grass/Poison type"));
        metodosPokedex.crearPokemon_enPokedex (new Pokedex("Charmander", 8.5, "Fire type"));
        metodosPokedex.crearPokemon_enPokedex (new Pokedex("Squirtle", 9.0, "Water type"));
        metodosPokedex.crearPokemon_enPokedex (new Pokedex("Caterpie", 2.9, "Bug type"));
        metodosPokedex.crearPokemon_enPokedex (new Pokedex("Weedle", 3.2, "Bug/Poison type"));
        metodosPokedex.crearPokemon_enPokedex (new Pokedex("Pidgey", 4.0, "Normal/Flying type"));
        metodosPokedex.crearPokemon_enPokedex (new Pokedex("Rattata", 3.5, "Normal type"));
        metodosPokedex.crearPokemon_enPokedex (new Pokedex("Spearow", 4.0, "Normal/Flying type"));
        metodosPokedex.crearPokemon_enPokedex (new Pokedex("Ekans", 6.9, "Poison type"));
        metodosPokedex.crearPokemon_enPokedex (new Pokedex("Toxtricity", 40.0, "Electric/Poison type"));
        metodosPokedex.crearPokemon_enPokedex (new Pokedex("Gardevoir", 48.4, "Psychic/Fairy type"));




        metodosPokemon.insertarPokemons("Pikachu", Date.valueOf("2023-01-01"),1, 1);
        metodosPokemon.insertarPokemons("Bulbasaur", Date.valueOf("2023-01-01"), 2, 1);
        metodosPokemon.insertarPokemons("Charmander", Date.valueOf("2023-01-01"), 3,1);
        metodosPokemon.insertarPokemons("Squirtle", Date.valueOf("2023-01-01"), 4, 1);
        metodosPokemon.insertarPokemons("Caterpie", Date.valueOf("2023-01-01"), 5, 1);
        metodosPokemon.insertarPokemons("Weedle", Date.valueOf("2023-01-01"), 6, 1);


        metodosPokemon.insertarPokemons("Pidgey", Date.valueOf("2023-01-01"), 7, 2);
        metodosPokemon.insertarPokemons("Rattata", Date.valueOf("2023-01-01"), 8,2);
        metodosPokemon.insertarPokemons("Spearow", Date.valueOf("2023-01-01"), 9, 2);
        metodosPokemon.insertarPokemons("Ekans", Date.valueOf("2023-01-01"), 10, 2);
        metodosPokemon.insertarPokemons("Toxtricity", Date.valueOf("2023-01-01"), 11, 2);
        metodosPokemon.insertarPokemons("Gardevoir", Date.valueOf("2023-01-01"), 12, 2);

        Pokemon pikachu = metodosPokemon.obtenerPokemonPorId(1);
        Pokemon bulbasaur = metodosPokemon.obtenerPokemonPorId(2);
        Pokemon charmander = metodosPokemon.obtenerPokemonPorId(3);
        Pokemon squirtle = metodosPokemon.obtenerPokemonPorId(4);
        Pokemon caterpie = metodosPokemon.obtenerPokemonPorId(5);
        Pokemon weedle = metodosPokemon.obtenerPokemonPorId(6);

        Pokemon pidgey = metodosPokemon.obtenerPokemonPorId(7);
        Pokemon rattata = metodosPokemon.obtenerPokemonPorId(8);
        Pokemon spearow = metodosPokemon.obtenerPokemonPorId(9);
        Pokemon ekans = metodosPokemon.obtenerPokemonPorId(10);
        Pokemon toxtricity = metodosPokemon.obtenerPokemonPorId(11);
        Pokemon gardevoir = metodosPokemon.obtenerPokemonPorId(12);


        adestrador1.addPokemon(pikachu);
        adestrador1.addPokemon(bulbasaur);
        adestrador1.addPokemon(charmander);
        adestrador1.addPokemon(squirtle);
        adestrador1.addPokemon(caterpie);
        adestrador1.addPokemon(weedle);


        adestrador2.addPokemon(pidgey);
        adestrador2.addPokemon(rattata);
        adestrador2.addPokemon(spearow);
        adestrador2.addPokemon(ekans);
        adestrador2.addPokemon(toxtricity);
        adestrador2.addPokemon(gardevoir);



/**
        metodosPokemon.borrarTablaPokemon();
        metodosPokedex.borrarTablaPokedex();
        metodosAdestrador.borrarTablaAdestrador();
**/

        metodosPokemon.listarPokemons();
        metodosAdestrador.listarAdestrador();

        List<Pokemon> listaPokemon = metodosPokemon.listarPokemons();
        List<Adestrador> listaAdestrador = metodosAdestrador.listarAdestrador();
/**
        JsonUtils jsonUtils = new JsonUtils();
        jsonUtils.guardarJson("pokemons.json", listaPokemon);
        jsonUtils.guardarJson("adestradores.json", listaAdestrador);
**/
        LecturaDatosXML lecturaDatosXML = new LecturaDatosXML();

        lecturaDatosXML.escribAXMLNuevo();

        /**
        jsonUtils.leerJSONPokemon();
        jsonUtils.leerJSONAdestradores();
        **/


    }
}