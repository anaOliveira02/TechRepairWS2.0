package pt.isep.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"numCli", "nome", "email", "nif"})
@JacksonXmlRootElement(localName = "cliente")
public class ClienteDTO {
    @JacksonXmlProperty(localName = "numCli")
    private int numCli;
    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "email")
    private String email;
    @JacksonXmlProperty(localName = "nif")
    private long nif;

    public ClienteDTO(int numCli, String nome, String email, long nif) {
        this.numCli = numCli;
        this.nome = nome;
        this.email = email;
        this.nif = nif;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
