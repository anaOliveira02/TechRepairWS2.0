package pt.isep.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "clientes")
public class ListaOrcamentoDTO {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "orcamento")
    private ArrayList<OrcamentoDTO> orcamentos;

    public ListaOrcamentoDTO() {
    }

    public ArrayList<OrcamentoDTO> getOrcamentos() {
        return orcamentos;
    }

    public void setOrcamentos(ArrayList<OrcamentoDTO> orcamentos) {
        this.orcamentos = orcamentos;
    }
}
