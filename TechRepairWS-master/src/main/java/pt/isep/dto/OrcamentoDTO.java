package pt.isep.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import pt.isep.model.Data;
import pt.isep.model.Tecnico;

@JsonPropertyOrder({"numOrc", "dataOrcamento", "responsavel", "valor"})
@JacksonXmlRootElement(localName = "orcamento")
public class OrcamentoDTO {
    @JacksonXmlProperty(localName = "numOrc")
    private int numOrc;
    @JacksonXmlProperty(localName = "dataOrcamento")
    private DataDTO dataOrcamento;
    @JacksonXmlProperty(localName = "responsavel")
    private String responsavel;
    @JacksonXmlProperty(localName = "valor")
    private long valor;

    public OrcamentoDTO() {
    }

    public OrcamentoDTO(int numOrc, DataDTO dataOrcamento, String responsavel, long valor) {
        this.numOrc = numOrc;
        this.dataOrcamento = dataOrcamento;
        this.responsavel = responsavel;
        this.valor = valor;
    }

    public OrcamentoDTO(int numOrc, Data dataOrcamento, String responsavel, long valor) {

    }

    public int getNumOrc() {
        return numOrc;
    }

    public void setNumOrc(int numOrc) {
        this.numOrc = numOrc;
    }

    public DataDTO getDataOrcamento() {
        return dataOrcamento;
    }

    public void setDataOrcamento(DataDTO dataOrcamento) {
        this.dataOrcamento = dataOrcamento;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public long getValor() {return valor; }

    public void setValor(long valor) {this.valor = valor; }
}
