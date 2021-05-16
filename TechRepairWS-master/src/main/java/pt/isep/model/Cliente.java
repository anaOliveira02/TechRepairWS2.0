package pt.isep.model;

import pt.isep.exception.EmailInvalidoException;
import pt.isep.exception.NifInvalidoException;
import pt.isep.exception.NomePessoaInvalidoException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Cliente implements Serializable {
    private int numCli;
    private String nome;
    private String email;
    private long nif;

    public Cliente(int numCli, String nome, String email, long nif) {
        setNumCli(numCli);
        setNome(nome);
        setEmail(email);
        setNif(nif);
    }

    public Cliente(Cliente cliente) {
        setNumCli(cliente.numCli);
        setNome(cliente.nome);
        setEmail(cliente.email);
        setNif(cliente.nif);
    }

    public int getNumCli() {
        return numCli;
    }

    public void setNumCli(int numCli) {
        this.numCli = numCli;
    }

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

    public ArrayList<Cliente> getSoEmpresas() {
        ArrayList<Cliente> empresas = new ArrayList<>();
        for (int i = 0; i < empresas.size(); i++) {
            Cliente p = empresas.get(i);
            if (p instanceof Empresa) {
                Cliente clone = new Empresa((Empresa) p);
                empresas.add(clone);
            }
        }
        return empresas;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "CLI" + numCli +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", nif=" + nif +
                '}';
    }
}
