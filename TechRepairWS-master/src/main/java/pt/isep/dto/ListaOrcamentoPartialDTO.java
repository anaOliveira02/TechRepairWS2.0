package pt.isep.dto;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


import java.util.ArrayList;


@JacksonXmlRootElement(localName = "orcamentos")
public class ListaOrcamentoPartialDTO {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "orcamento")
    private ArrayList<OrcamentoPartialDTO> orcamentos;

    public ListaOrcamentoPartialDTO() {
    }

    public ArrayList<OrcamentoPartialDTO> getOrcamentos() {
        return orcamentos;
    }

    public void setOrcamentos(ArrayList<OrcamentoPartialDTO> orcamentos) {
        this.orcamentos = orcamentos;
    }

}
