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
    private String email;

    public Tecnico(int numTec, String nome, Data dataNascimento, String email) {
        setNumTec(numTec);
        setNome(nome);
        this.dataNascimento = dataNascimento;
        setEmail(email);
    }

    public Tecnico(Tecnico tecnico) {
        setNumTec(tecnico.numTec);
        setNome(tecnico.nome);
        this.dataNascimento = tecnico.dataNascimento;
        setEmail(tecnico.email);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (emailValido(email)){
            this.email = email;
        } else {
            throw new EmailInvalidoException(email + ": email inválido");
        }
    }

    private boolean emailValido(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

//    public Tecnico removeTecnicoPosicao(int pos) {
//        LojaReparacoes loja;
//        loja.validaNumTec(pos);
//        return loja.tecnicos.remove(pos);
//    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "TEC" + numTec +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", email='" + email + '\'' +
                '}';
    }
}
