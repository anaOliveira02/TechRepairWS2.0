package pt.isep.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import pt.isep.model.Data;
import pt.isep.model.Equipamento;
import pt.isep.model.Estado;
import pt.isep.model.Marca;

@JsonPropertyOrder({"numAssist", "assunto", "dataPat", "estado", "equipamento", "marca", "modelo", "numSerie"})
@JacksonXmlRootElement(localName = "assistencia")
public class AssistenciaDTO {

    @JacksonXmlProperty(localName = "numAssist")
    private int numAssist;
    @JacksonXmlProperty(localName = "assunto")
    private String assunto;
    @JacksonXmlProperty(localName = "dataPat")
    private Data dataPat;
    @JacksonXmlProperty(localName = "estado")
    private Estado estado;
    @JacksonXmlProperty(localName = "equipamento")
    private Equipamento equipamento;
    @JacksonXmlProperty(localName = "marca")
    private Marca marca;
    @JacksonXmlProperty(localName = "modelo")
    private String modelo;
    @JacksonXmlProperty(localName = "numSerie")
    private long numSerie;

    public AssistenciaDTO(int numAssist, String assunto, Data dataPat, Estado estado, Equipamento equipamento, Marca marca, String modelo, long numSerie) {
        this.numAssist = numAssist;
        this.assunto = assunto;
        this.dataPat = dataPat;
        this.estado = estado;
        this.equipamento = equipamento;
        this.marca = marca;
        this.modelo = modelo;
        this.numSerie = numSerie;
    }

    public int getNumAssist() {
        return numAssist;
    }

    public void setNumAssist(int numAssist) {
        this.numAssist = numAssist;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Data getDataPat() {
        return dataPat;
    }

    public void setDataPat(Data dataPat) {
        this.dataPat = dataPat;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public long getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(long numSerie) {
        this.numSerie = numSerie;
    }

}
