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
    private Data dataOrcamento;
    @JacksonXmlProperty(localName = "responsavel")
    private Tecnico responsavel;
    @JacksonXmlProperty(localName = "valor")
    private long valor;

    public OrcamentoDTO() {
    }

    public OrcamentoDTO(int numOrc, Data dataOrcamento, Tecnico responsavel, long valor) {
        this.numOrc = numOrc;
        this.dataOrcamento = dataOrcamento;
        this.responsavel = responsavel;
        this.valor = valor;
    }

    public int getNumOrc() {
        return numOrc;
    }

    public void setNumOrc(int numOrc) {
        this.numOrc = numOrc;
    }

    public Data getDataOrcamento() {
        return dataOrcamento;
    }

    public void setDataOrcamento(Data dataOrcamento) {
        this.dataOrcamento = dataOrcamento;
    }

    public Tecnico getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Tecnico responsavel) {
        this.responsavel = responsavel;
    }

    public long getValor() {return valor; }

    public void setValor(long valor) {this.valor = valor; }
}
