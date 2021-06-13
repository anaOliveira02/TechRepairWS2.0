package pt.isep.model;

import pt.isep.exception.EmailInvalidoException;
import pt.isep.exception.NifInvalidoException;
import pt.isep.exception.NomePessoaInvalidoException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Cliente implements Serializable {
    private String nome;
    private long nif;
    private int numCli;

    public Cliente(long nif, String nome, int numCli) {
        setNome(nome);
        setNif(nif);
        setNumCli(numCli);
    }

    public Cliente(Cliente cliente) {
        setNome(cliente.nome);
        setNif(cliente.nif);
        setNumCli(cliente.numCli);
    }

    public Cliente() {

    }

    public int getNumCli() {return numCli; }

    public void setNumCli(int numCli) {this.numCli = numCli; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(eNomeValido(nome)) {
            this.nome = nome;
        }else {
            throw new NomePessoaInvalidoException(nome+ ": Nome inválido");
        }
    }

    private boolean eNomeValido(String nome) {
        if(nome == null){
            return false;
        }
        if(nome.length() < 3){
            return false;
        }
        for(int i=0;i<nome.length();i++){
            if(nome.charAt(i) >= '0' &&  nome.charAt(i) <= '9')
                return false;
        }
        return true;
    }

    public long getNif() {
        return nif;
    }

    public void setNif(long nif) {
        if(numeroValido(nif)) {
            this.nif = nif;
        }else {
            throw new NifInvalidoException(nif + ": NIF inválido");
        }
    }

    private boolean numeroValido(long teste) throws NifInvalidoException {
        if (teste >= 100000000 && teste <= 999999999){
            return true;
        }
        else {
            return false;
        }
    }

    public String getIntroducao(){
        String intro;
        intro = nome + " - " + nif ;

        return intro;
    }

//    public ArrayList<Cliente> getSoEmpresas() {
//        ArrayList<Cliente> empresas = new ArrayList<>();
//        for (int i = 0; i < empresas.size(); i++) {
//            Cliente p = empresas.get(i);
//            if (p instanceof Empresa) {
//                Cliente clone = new Empresa((Empresa) p);
//                empresas.add(clone);
//            }
//        }
//        return empresas;
//    }

    @Override
    public String toString() {
        return "Cliente{" +
                " nome='" + nome + '\'' +
                ", nif=" + nif +
                ", numCli=" +
                '}';
    }
}
