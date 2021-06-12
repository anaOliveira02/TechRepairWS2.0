package pt.isep.model;

import pt.isep.dto.DataDTO;

import java.io.Serializable;
import java.util.Date;

public class Orcamento implements Serializable {
    private int numOrc;
    private Data dataOrcamento;
    private String responsavel;
    private long valor;

    public Orcamento(int numOrc, DataDTO data, String responsavel, long valor) {

    }
    public Orcamento(int numOrc, Data dataOrcamento, String responsavel, long valor) {
        this.numOrc = numOrc;
        this.dataOrcamento = dataOrcamento;
        this.responsavel = responsavel;
        this.valor = valor;
    }

    public Orcamento(Orcamento orcamento) {
        setNumOrc(orcamento.numOrc);
        setDataOrcamento(orcamento.dataOrcamento);
        setResponsavel(orcamento.responsavel);
        setValor(orcamento.valor);
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

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public long getValor() {return valor; }

    public void setValor(long valor) {this.valor = valor; }

    @Override
    public String toString() {
        return "Orcamento{" +
                "numOrc=" + numOrc +
                ", dataOrcamento=" + dataOrcamento +
                ", responsavel=" + responsavel +
                ", valor=" +
                '}';
    }
}
