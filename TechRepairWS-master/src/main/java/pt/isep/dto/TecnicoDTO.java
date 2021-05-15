package pt.isep.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import pt.isep.model.Data;

@JsonPropertyOrder ({"numTec", "nome", "dataNascimento", "email"})
@JacksonXmlRootElement(localName = "tecnico")
public class TecnicoDTO {
    @JacksonXmlProperty(localName = "numTec")
    private int numTec;
    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "dataNascimento")
    private Data dataNascimento;
    @JacksonXmlProperty(localName = "email")
    private String email;

    public TecnicoDTO(int numTec, String nome, Data dataNascimento, String email) {
        this.numTec = numTec;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public TecnicoDTO() {
    }

    public TecnicoDTO(int numTec, String nome) {
    }

    public int getNumTec() {
        return numTec;
    }

    public void setNumTec(int numTec) {
        this.numTec = numTec;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
