package pt.isep.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"numCli", "nome", "nif"})
@JacksonXmlRootElement(localName = "cliente")
public class ClienteDTO {
    @JacksonXmlProperty(localName = "numCli")
    private int numCli;
    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "nif")
    private long nif;

    public ClienteDTO(int numCli, String nome, long nif) {
        this.numCli = numCli;
        this.nome = nome;
        this.nif = nif;
    }

    public ClienteDTO() {
    }

    public int getNumCli() {
        return numCli;
    }

    public void setNumCli(int numCli) {
        this.numCli = numCli;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getNif() {
        return nif;
    }

    public void setNif(long nif) {
        this.nif = nif;
    }
}
