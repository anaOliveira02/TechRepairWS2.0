package pt.isep.model;

import java.io.Serializable;
import java.util.Date;

public class Assistencia implements Serializable {
    private int numAssist;
    private String assunto;
    private Data dataPat;
    private Estado estado;
    private Equipamento equipamento;
    private Marca marca;
    private String modelo;
    private long numSerie;

    public Assistencia(int numAssist, String assunto, Data dataPat, Estado estado, Equipamento equipamento, Marca marca, String modelo, long numSerie) {
        this.numAssist = numAssist;
        this.assunto = assunto;
        this.dataPat = dataPat;
        this.estado = estado;
        this.equipamento = equipamento;
        this.marca = marca;
        this.modelo = modelo;
        this.numSerie = numSerie;
    }

    public Assistencia(Assistencia assistencia) {
        setNumAssist(assistencia.numAssist);
        setAssunto(assistencia.assunto);
        setDataPat(assistencia.dataPat);
        setEstado(assistencia.estado);
        setEquipamento(assistencia.equipamento);
        setMarca(assistencia.marca);
        setModelo(assistencia.modelo);
        setNumSerie(assistencia.numSerie);
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

    @Override
    public String toString() {
        return "Assistencia{" +
                "numAssist=" + numAssist +
                ", assunto='" + assunto + '\'' +
                ", dataPat=" + dataPat +
                ", estado=" + estado +
                ", equipamento=" + equipamento +
                ", marca=" + marca +
                ", modelo='" + modelo + '\'' +
                ", numSerie=" + numSerie +
                '}';
    }
}
