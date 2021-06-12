package pt.isep.dto;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


import java.util.ArrayList;


@JacksonXmlRootElement(localName = "clientes")
public class ListaClientePartialDTO {
    @JacksonXmlElementWrapper(useWrapping = false)
    //@ElementList(inline = true, required=false)
    @JacksonXmlProperty(localName = "cliente")
    private ArrayList<ClientePartialDTO> clientes;

    public ListaClientePartialDTO() {
    }

    public ArrayList<ClientePartialDTO> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<ClientePartialDTO> clientes) {
        this.clientes = clientes;
    }

}
