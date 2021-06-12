package pt.isep.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"nif", "nome"})
@JacksonXmlRootElement(localName = "cliente")
public class ClientePartialDTO {
    @JacksonXmlProperty(localName = "nif")
    private long nif;
    @JacksonXmlProperty(localName = "nome")
    private String nome;

    public ClientePartialDTO() {
    }
    public long getNif() {
        return nif;
    }

    public void setNif(long nif) {
        this.nif = nif;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
