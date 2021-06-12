package pt.isep.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"numOrc", "responsavel", "valor"})
@JacksonXmlRootElement(localName = "orcamento")
public class OrcamentoPartialDTO {
    @JacksonXmlProperty(localName = "numOrc")
    private int numOrc;
    @JacksonXmlProperty(localName = "responsavel")
    private String responsavel;
    @JacksonXmlProperty(localName = "valor")
    private long valor;

    public OrcamentoPartialDTO() {
    }
    public int getNumOrc() {
        return numOrc;
    }

    public void setNumOrc(int numOrc) {
        this.numOrc = numOrc;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }
}
