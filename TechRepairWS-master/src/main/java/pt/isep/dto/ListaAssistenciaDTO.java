package pt.isep.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "clientes")
public class ListaAssistenciaDTO {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "assistencia")
    private ArrayList<AssistenciaDTO> assistencias;

    public ListaAssistenciaDTO() {
    }

    public ArrayList<AssistenciaDTO> getAssistencias() {
        return assistencias;
    }

    public void setAssistencias(ArrayList<AssistenciaDTO> assistencias) {
        this.assistencias = assistencias;
    }
}
