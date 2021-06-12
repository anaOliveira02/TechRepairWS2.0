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
    private DataDTO dataNascimento;

    public TecnicoDTO(int numTec, String nome, DataDTO dataNascimento) {
        this.numTec = numTec;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public TecnicoDTO() {
    }

    public TecnicoDTO(int numTec, String nome) {
    }

    public TecnicoDTO(int numTec, String nome, Data dataNascimento) {

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

    public DataDTO getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(DataDTO dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
