package pt.isep.model;

import java.io.Serializable;

public class Particular extends Cliente implements Serializable {
    private int numPar;
    private long telemovel;

    public Particular(int numCli, String nome, String email, long nif, int numPar, long telemovel) {
        super(numCli, nome, email, nif);
        this.numPar = numPar;
        setTelemovel(telemovel);
    }

    public Particular(Cliente cliente, int numPar, long telemovel) {
        super(cliente);
        this.numPar = numPar;
        setTelemovel(telemovel);
    }

    public Particular(Particular particular) {
        super(particular);
        this.numPar = particular.numPar;
        this.telemovel = particular.telemovel;
    }

    public int getNumPar() {
        return numPar;
    }

    public void setNumPar(int numPar) {
        this.numPar = numPar;
    }

    public long getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(long telemovel) {
        this.telemovel = telemovel;
    }

    @Override
    public String getIntroducao(){
        String intro = numPar + " - " + super.getIntroducao() + " - " + telemovel ;
        return intro;
    }

    @Override
    public String toString() {
        return "Particular{" + super.toString() +
                "PAR" + numPar +
                ", telemovel=" + telemovel +
                '}';
    }
}
