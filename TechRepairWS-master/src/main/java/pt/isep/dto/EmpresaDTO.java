package pt.isep.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"numCli", "nome", "email", "nif", "numEmp", "telefone"})
@JacksonXmlRootElement(localName = "empresa")
public class EmpresaDTO {

    @JacksonXmlProperty(localName = "numCli")
    private int numCli;
    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "email")
    private String email;
    @JacksonXmlProperty(localName = "nif")
    private long nif;
    @JacksonXmlProperty(localName = "numEmp")
    private int numEmp;
    @JacksonXmlProperty(localName = "telefone")
    private long telefone;

    public EmpresaDTO() {
    }

    public EmpresaDTO(int numCli, String nome, String email, long nif, int numEmp, long telefone) {
        this.numCli = numCli;
        this.nome = nome;
        this.email = email;
        this.nif = nif;
        this.numEmp = numEmp;
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getNumEmp() {
        return numEmp;
    }

    public void setNumEmp(int numEmp) {
        this.numEmp = numEmp;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
}
