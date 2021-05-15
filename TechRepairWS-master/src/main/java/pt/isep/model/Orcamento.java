package pt.isep.model;

import java.io.Serializable;
import java.util.Date;

public class Orcamento implements Serializable {
    private int numOrc;
    private Data dataOrcamento;
    private Tecnico responsavel;

    public Orcamento(int numOrc, Data dataOrcamento, Tecnico responsavel) {
        this.numOrc = numOrc;
        this.dataOrcamento = dataOrcamento;
        this.responsavel = responsavel;
    }

    public Orcamento(Orcamento orcamento) {
        setNumOrc(orcamento.numOrc);
        setDataOrcamento(orcamento.dataOrcamento);
        setResponsavel(orcamento.responsavel);
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

    @Override
    public String toString() {
        return "Orcamento{" +
                "numOrc=" + numOrc +
                ", dataOrcamento=" + dataOrcamento +
                ", responsavel=" + responsavel +
                '}';
    }
}
