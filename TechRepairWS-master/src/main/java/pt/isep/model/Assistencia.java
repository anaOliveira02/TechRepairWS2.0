package pt.isep.model;

import java.io.Serializable;
import java.util.Date;

public class Assistencia implements Serializable {
    private int numAssist;
    private String assunto;
//    private Tecnico responsavel;
    private Date dataPat;
//    private Cliente cliente;
    private Estado estado;
    private Equipamento equipamento;
    private Marca marca;
    private String modelo;
    private long numSerie;
}
