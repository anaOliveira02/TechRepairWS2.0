package pt.isep.dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JsonPropertyOrder({"numAssis", "assunto", "estado", "equipamento", "marca", "modelo", "numSerie", "tecnico"})
@JacksonXmlRootElement(localName = "assistencia")
public class AssistenciaPartialDTO {
    @JacksonXmlProperty(localName = "numAssis")
    private int numAssis;
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

    public AssistenciaPartialDTO(){}

    public AssistenciaPartialDTO(int numAssis, String assunto, String estado, String equipamento, String marca, String modelo, long numSerie, String tecnico) {
        this.numAssis = numAssis;
        this.assunto = assunto;
        this.estado = estado;
        this.equipamento = equipamento;
        this.marca = marca;
        this.modelo = modelo;
        this.numSerie = numSerie;
        this.tecnico = tecnico;
    }

    public int getNumAssis() {
        return numAssis;
    }

    public void setNumAssis(int numAssis) {
        this.numAssis = numAssis;
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

    public String getTecnico() { return tecnico; }

    public void setTecnico(String tecnico) { this.tecnico = tecnico; }
}
