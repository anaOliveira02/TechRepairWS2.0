package pt.isep.model;

import pt.isep.dto.DataDTO;
import pt.isep.exception.EmailInvalidoException;
import pt.isep.exception.NomePessoaInvalidoException;
import pt.isep.exception.NumTecInvalidoException;

import java.io.Serializable;
import java.util.regex.Pattern;

public class Tecnico implements Serializable {
    private int numTec;
    private String nome;
    private Data dataNascimento;

    public Tecnico(int numTec, String nome, Data dataNascimento) {
        setNumTec(numTec);
        setNome(nome);
        this.dataNascimento = dataNascimento;
    }

    public Tecnico(Tecnico tecnico) {
        setNumTec(tecnico.numTec);
        setNome(tecnico.nome);
        this.dataNascimento = tecnico.dataNascimento;
    }

    public int getNumTec() {
        return numTec;
    }

    public void setNumTec(int numTec) {
        this.numTec = numTec;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(eNomeValido(nome)) {
            this.nome = nome;
        }else {
            throw new NomePessoaInvalidoException(nome+ ": nome inválido");
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

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    @Override
    public String toString() {
        return "Tecnico{" +
                "TEC" + numTec +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
