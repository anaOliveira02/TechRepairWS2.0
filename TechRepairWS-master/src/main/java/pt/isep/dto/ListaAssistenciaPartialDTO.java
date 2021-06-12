package pt.isep.dto;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;


@JacksonXmlRootElement(localName = "assistencias")
public class ListaAssistenciaPartialDTO {
//    @ElementList(inline = true, required=false)
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "assistencias")
    private ArrayList<AssistenciaPartialDTO> assistencias;

    public ListaAssistenciaPartialDTO() {
    }

    public ArrayList<AssistenciaPartialDTO> getAssistencias() {
        return assistencias;
    }

    public void setAssistencias(ArrayList<AssistenciaPartialDTO> assistencias) {
        this.assistencias = assistencias;
    }

}
