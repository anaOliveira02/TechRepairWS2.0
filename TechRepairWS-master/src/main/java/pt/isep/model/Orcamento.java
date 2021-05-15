package pt.isep.model;

import java.io.Serializable;
import java.util.Date;

public class Orcamento implements Serializable {
    private int numOrc;
    private Date dataOrcamento;
    private Tecnico responsavel;
}
