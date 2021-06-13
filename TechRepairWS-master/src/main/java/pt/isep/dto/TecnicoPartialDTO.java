package pt.isep.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import pt.isep.model.Data;


@JsonPropertyOrder({"numTec", "nome", "dataNascimento"})
@JacksonXmlRootElement(localName = "tecnico")
public class TecnicoPartialDTO {
    @JacksonXmlProperty(localName = "numTec")
    private int numTec;
    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "dataNascimento")
    private Data dataNascimento;

    public TecnicoPartialDTO() {
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
}
