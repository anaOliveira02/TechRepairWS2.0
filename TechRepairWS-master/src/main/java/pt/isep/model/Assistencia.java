package pt.isep.model;

import java.io.Serializable;
import java.util.Date;

public class Assistencia implements Serializable {
    private int numAssist;
    private String assunto;
    private String estado;
    private String equipamento;
    private String marca;
    private String modelo;
    private long numSerie;
    private String tecnico;

    public Assistencia(int numAssist, String assunto, String estado, String equipamento, String marca, String modelo, long numSerie, String tecnico) {
        this.numAssist = numAssist;
        this.assunto = assunto;
        this.estado = estado;
        this.equipamento = equipamento;
        this.marca = marca;
        this.modelo = modelo;
        this.numSerie = numSerie;
        this.tecnico = tecnico;
    }

    public Assistencia(Assistencia assistencia) {
        setNumAssist(assistencia.numAssist);
        setAssunto(assistencia.assunto);
        setEstado(assistencia.estado);
        setEquipamento(assistencia.equipamento);
        setMarca(assistencia.marca);
        setModelo(assistencia.modelo);
        setNumSerie(assistencia.numSerie);
        setTecnico(assistencia.tecnico);
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

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getTecnico() {
        return tecnico;
    }

    @Override
    public String toString() {
        return "Assistencia{" +
                "numAssist=" + numAssist +
                ", assunto='" + assunto + '\'' +
                ", estado=" + estado +
                ", equipamento=" + equipamento +
                ", marca=" + marca +
                ", modelo='" + modelo + '\'' +
                ", numSerie=" + numSerie +
                ", tecnico=" +tecnico +
                '}';
    }
}
