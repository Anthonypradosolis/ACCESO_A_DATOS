package Hibernate.Metodos;

import Datos.Adestrador;
import Datos.Auxiliares.Adestradores;
import Datos.Auxiliares.Pokemons;
import Datos.Pokedex;
import Datos.Pokemon;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.util.List;

public class LecturaDatosXML {
    /**
     * Metodo que lee toda la informacion de Adestrador
     * Y lo guarda en un archivo xml
     */
    public void leerDatosAdestrador(List<Adestrador> adestradorL){
        try{
            XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(new FileWriter("adestrador.xml"));

            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeStartElement("Adestradores");

            for(Adestrador adestrador: adestradorL){
                xmlStreamWriter.writeStartElement("Adestrador");
                xmlStreamWriter.writeAttribute("id",String.valueOf(adestrador.getId()));
                xmlStreamWriter.writeStartElement("Nome");
                xmlStreamWriter.writeCharacters(adestrador.getNome());
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeStartElement("Nacemento");
                xmlStreamWriter.writeCharacters(String.valueOf(adestrador.getNacemento()));
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeEndElement();
            }
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
            xmlStreamWriter.flush();
            xmlStreamWriter.close();

        }catch (IOException | XMLStreamException e){
            System.out.println("Error al leer los datos de adestrador: "+e.getMessage());
        }
    }

    /**
     * Metodo que lee toda la informacion de Pokedex
     * Y lo guarda en un archivo xml
     */
    public void leerDatosPokedex(List<Pokedex> pokedexL){
        try{
            XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(new FileWriter("pokedex.xml"));

            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeStartElement("Pokedex");

            for(Pokedex pokedex: pokedexL){
                xmlStreamWriter.writeStartElement("Pokedex");
                xmlStreamWriter.writeAttribute("id",String.valueOf(pokedex.getId()));
                xmlStreamWriter.writeStartElement("Nome");
                xmlStreamWriter.writeCharacters(pokedex.getNome());
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeStartElement("Peso");
                xmlStreamWriter.writeCharacters(String.valueOf(pokedex.getPeso()));
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeStartElement("Misc");
                xmlStreamWriter.writeCharacters(pokedex.getMisc());
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeEndElement();
            }
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
            xmlStreamWriter.flush();
            xmlStreamWriter.close();

        }catch (IOException | XMLStreamException e){
            System.out.println("Error al leer los datos de pokedex: "+e.getMessage());
        }
    }

    /**
     * Exportar en un archivo dos entradas de la pokedex serializadas
     */
    public void exportarPokedex() {
        String archivo = "pokedex.txt";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("pokedex.txt"))) {
            while (true) {
                try {
                    Pokedex pokedex = (Pokedex) ois.readObject();

                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al exportar los datos de la pokedex: " + e.getMessage());
        }
    }

    public void escribAXMLAdestrador(){
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try (FileWriter fileWriter = new FileWriter("adestrador.xml", true)) {
            // Obtener la lista de objetos
            MetodosAdestrador metodosAdestrador = new MetodosAdestrador();
            List<Adestrador> list = metodosAdestrador.listarAdestrador();

            // Crear una clase contenedora que sirva como raíz para los objetos
            Adestradores contenedor = new Adestradores();
            contenedor.setAdestradores(list);

            // Escribir el contenedor en el archivo
            xmlMapper.writeValue(fileWriter, contenedor);

            System.out.println("Datos añadidos al archivo XML correctamente: adestrador.xml");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo XML: " + e.getMessage());
        }

    }

    public void escribirAXMLPokemon(){
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try (FileWriter fileWriter = new FileWriter("pokemon.xml", true)) {
            // Obtener la lista de objetos
            MetodosPokemon metodosPokemon = new MetodosPokemon();
            List<Pokemon> list = metodosPokemon.listarPokemons();

            // Crear una clase contenedora que sirva como raíz para los objetos
            Pokemons contenedor = new Pokemons();
            contenedor.setPokemons(list);

            // Escribir el contenedor en el archivo
            xmlMapper.writeValue(fileWriter, contenedor);

            System.out.println("Datos añadidos al archivo XML correctamente: pokemon.xml");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo XML: " + e.getMessage());
        }

    }

}
