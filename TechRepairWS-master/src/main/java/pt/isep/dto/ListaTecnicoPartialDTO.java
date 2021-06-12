package pt.isep.dto;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


import java.util.ArrayList;


@JacksonXmlRootElement(localName = "tecnicos")
public class ListaTecnicoPartialDTO {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "tecnico")
    private ArrayList<TecnicoPartialDTO> tecnicos;

    public ListaTecnicoPartialDTO() {
    }

    public ArrayList<TecnicoPartialDTO> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(ArrayList<TecnicoPartialDTO> tecnicos) {
        this.tecnicos = tecnicos;
    }

}
