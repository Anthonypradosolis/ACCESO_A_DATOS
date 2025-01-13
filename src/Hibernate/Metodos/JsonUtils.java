package Hibernate.Metodos;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonUtils {

    public <T> void guardarJson(String rutaArchivo, List<T> objetos){
        ObjectMapper mapper = new ObjectMapper();
        try{
            mapper.writeValue(new File(rutaArchivo),objetos);
            System.out.println();
        }catch (IOException e){
            System.out.println("Error al guardar en JSON"+ e.getMessage());
        }
    }

    public <T> List<T> importarJson(String rutaArchivo, Class<T[]> clazz){
        ObjectMapper mapper = new ObjectMapper();
        try{
            // Leer el archivo y convertirlo en un array de objetos
            T[] array = mapper.readValue(new File(rutaArchivo), clazz);
            return Arrays.asList(array); // Convertir el array en una lista
        } catch (IOException e){
            System.out.println("Error al importar JSON"+ e.getMessage());
            return new ArrayList<>();
        }
    }
}
