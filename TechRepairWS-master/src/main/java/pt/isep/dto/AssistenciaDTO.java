package pt.isep.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import pt.isep.model.Data;
import pt.isep.model.Equipamento;
import pt.isep.model.Estado;
import pt.isep.model.Marca;

@JsonPropertyOrder({"numAssist", "assunto", "estado", "equipamento", "marca", "modelo", "numSerie", "tecnico"})
@JacksonXmlRootElement(localName = "assistencia")
public class AssistenciaDTO {

    @JacksonXmlProperty(localName = "numAssist")
    private int numAssist;
    @JacksonXmlProperty(localName = "assunto")
    private String assunto;
    @JacksonXmlProperty(localName = "estado")
    private String estado;
    @JacksonXmlProperty(localName = "equipamento")
    private String equipamento;
    @JacksonXmlProperty(localName = "marca")
    private String marca;
    @JacksonXmlProperty(localName = "modelo")
    private String modelo;
    @JacksonXmlProperty(localName = "numSerie")
    private long numSerie;
    @JacksonXmlProperty(localName = "tecnico")
    private String tecnico;

    public AssistenciaDTO() {
    }

    public AssistenciaDTO(int numAssist, String assunto, String estado, String equipamento, String marca, String modelo, long numSerie, String tecnico) {
        this.numAssist = numAssist;
        this.assunto = assunto;
        this.estado = estado;
        this.equipamento = equipamento;
        this.marca = marca;
        this.modelo = modelo;
        this.numSerie = numSerie;
        this.tecnico = tecnico;
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


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
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

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

}
