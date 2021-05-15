package pt.isep.model;

import java.io.Serializable;

public class Empresa extends Cliente implements Serializable {
    private int numEmp;
    private long telefone;

    public Empresa(int numCli, String nome, String email, long nif, int numEmp, long telefone) {
        super(numCli, nome, email, nif);
        this.numEmp = numEmp;
        setTelefone(telefone);}

    public Empresa(Cliente cliente, int numEmp, long telefone) {
        super(cliente);
        this.numEmp = numEmp;
        setTelefone(telefone);
    }

    public Empresa(Empresa empresa) {
        super(empresa);
        this.numEmp = empresa.numEmp;
        setTelefone(telefone);
    }

    public int getNumEmp() {
        return numEmp;
    }

    public void setNumEmp(int numEmp) {
        this.numEmp = numEmp;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    @Override
    public String getIntroducao(){
        String intro = numEmp + " - " + super.getIntroducao() + " - " + telefone ;
        return intro;
    }

    @Override
    public String toString() {
        return "Empresa{" + super.toString() +
                "EMP" + numEmp +
                ", telefone=" + telefone +
                '}';
    }
}
