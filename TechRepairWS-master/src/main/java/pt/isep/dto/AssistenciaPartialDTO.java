package pt.isep.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JsonPropertyOrder({"numAssis", "assunto", "tecnico"})
@JacksonXmlRootElement(localName = "assistencia")
public class AssistenciaPartialDTO {

    @JacksonXmlProperty(localName = "numAssis")
    private int numAssis;
    @JacksonXmlProperty(localName = "assunto")
    private String assunto;
    @JacksonXmlProperty(localName = "tecnico")
    private String tecnico;

    public AssistenciaPartialDTO() {
    }
    public int getNumAssis() {
        return numAssis;
    }

    public void setNumAssis(int numAssis) {
        this.numAssis = numAssis;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }
}
