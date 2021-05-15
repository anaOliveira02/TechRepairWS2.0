package pt.isep.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.Date;

@JacksonXmlRootElement(localName = "tecnicos")
public class ListaTecnicoDTO {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "tecnico")
    private ArrayList<TecnicoDTO> tecnicos;

    public ListaTecnicoDTO() {
        tecnicos = new ArrayList<>();
    }

    public ArrayList<TecnicoDTO> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(ArrayList<TecnicoDTO> tecnicos) {
        this.tecnicos = tecnicos;
    }
}
