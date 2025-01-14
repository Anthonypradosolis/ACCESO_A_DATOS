package Datos.Auxiliares;


import Datos.Adestrador;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


import java.util.List;

/**
 * Esta clase sirve como contenedor para una lista de objetos {@link Adestrador}.
 * Se utiliza para manejar los datos de los entrenadores en formatos XML y JSON.
 * Las anotaciones de Jackson permiten la serialización y deserialización de estos objetos a los respectivos formatos
 * @author cristian
 * @version 1.0
 */
@JacksonXmlRootElement(localName = "Adestradores")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Adestradores {

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Adestrador> adestradores;

    public List<Adestrador> getAdestradores() {
        return adestradores;
    }

    public void setAdestradores(List<Adestrador> adestradores) {
        this.adestradores = adestradores;
    }
}