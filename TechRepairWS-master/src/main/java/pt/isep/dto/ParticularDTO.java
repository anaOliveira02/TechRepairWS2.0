package pt.isep.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"numCli", "nome", "email", "nif", "numPar", "telemovel"})
@JacksonXmlRootElement(localName = "particular")
public class ParticularDTO {

    @JacksonXmlProperty(localName = "numCli")
    private int numCli;
    @JacksonXmlProperty(localName = "nome")
    private String nome;
    @JacksonXmlProperty(localName = "email")
    private String email;
    @JacksonXmlProperty(localName = "nif")
    private long nif;
    @JacksonXmlProperty(localName = "numPar")
    private int numPar;
    @JacksonXmlProperty(localName = "telemovel")
    private long telemovel;

    public ParticularDTO() {
    }

    public ParticularDTO(int numCli, String nome, String email, long nif, int numPar, long telemovel) {
        this.numCli = numCli;
        this.nome = nome;
        this.email = email;
        this.nif = nif;
        this.numPar = numPar;
        this.telemovel = telemovel;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getNif() {
        return nif;
    }

    public void setNif(long nif) {
        this.nif = nif;
    }

    public int getNumPar() {
        return numPar;
    }

    public void setNumPar(int numPar) {
        this.numPar = numPar;
    }

    public long getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(long telemovel) {
        this.telemovel = telemovel;
    }
}
