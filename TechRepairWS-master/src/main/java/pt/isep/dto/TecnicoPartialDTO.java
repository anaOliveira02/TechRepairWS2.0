package pt.isep.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JsonPropertyOrder({"numTec", "nome"})
@JacksonXmlRootElement(localName = "pessoa")
public class TecnicoPartialDTO {
    @JacksonXmlProperty(localName = "numTec")
    private long numTec;
    @JacksonXmlProperty(localName = "nome")
    private String nome;

    public TecnicoPartialDTO() {
    }
    public long getNumTec() {
        return numTec;
    }

    public void setNumTec(long nif) {
        this.numTec = nif;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
