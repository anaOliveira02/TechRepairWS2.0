package pt.isep.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "clientes")
public class ListaClienteDTO {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "cliente")
    private ArrayList<ClienteDTO> clientes;

    public ListaClienteDTO() {
    }

    public ArrayList<ClienteDTO> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<ClienteDTO> clientes) {
        this.clientes = clientes;
    }
}
