package pt.isep.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import pt.isep.exception.AssistenciaExistenteException;
import pt.isep.exception.ElementoNaoExistenteException;
import pt.isep.exception.NumParDuplicadoException;
import pt.isep.exception.TecnicoExistenteException;
import pt.isep.model.Tecnico;

import javax.servlet.http.Part;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LojaReparacoes implements Serializable {

    private ArrayList<Tecnico> tecnicos = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Particular> particulares = new ArrayList<>();
    private ArrayList<Empresa> empresas = new ArrayList<>();
    private ArrayList<Assistencia> assistencias = new ArrayList<>();
    private ArrayList<Orcamento> orcamentos = new ArrayList<>();

    public void adicionarTecnico(Tecnico novo){
        for (int i = 0; i < tecnicos.size(); i++) {
            Tecnico actual = tecnicos.get(i);
            if(novo.getNumTec() == actual.getNumTec()){
                throw new TecnicoExistenteException("Tecnico já existe");
            }
        }
        tecnicos.add(novo);
    }

    public void adicionarAssistencia(Assistencia novo){
        for (int i = 0; i < assistencias.size(); i++) {
            Assistencia actual = assistencias.get(i);
            if(novo.getNumAssist() == actual.getNumAssist()){
                throw new AssistenciaExistenteException("Assistencia já existe");
            }
        }
        assistencias.add(novo);
    }

    public void addClientePart(Particular novoCliente){
        for (int i = 0; i < particulares.size(); i++) {
            Particular p = particulares.get(i);
            if (p.getNumPar() == novoCliente.getNumPar()) {
                throw new NumParDuplicadoException(novoCliente.getNumPar()+"");
            }
        }
        particulares.add(novoCliente);
    }

//    public Tecnico removerTecnicoNumTec(int numTec) {
//        Tecnico tecnico = getByNumTec(numTec);
//        if (tecnico != null) {
//            tecnicos.remove(tecnico);
//            return tecnico;
//        }
//        return null;
//    }

    public Tecnico getByNumTec(int numTec) {
        for (int i = 0; i < tecnicos.size(); i++) {
            Tecnico p = tecnicos.get(i);
            if (p.getNumTec() == numTec) {
                return new Tecnico((Tecnico) p);
            } else {
                return new Tecnico(p);
            }
        }
        return null;
    }

    public Particular getByNumPar(int numPar) {
        for (int i = 0; i < particulares.size(); i++) {
            Particular p = particulares.get(i);
            if (p.getNumPar() == numPar) {
                return new Particular((Particular) p);
            } else {
                return new Particular(p);
            }
        }
        return null;
    }

    public Empresa getByNumEmp(int numEmp) {
        for (int i = 0; i < empresas.size(); i++) {
            Empresa p = empresas.get(i);
            if (p.getNumEmp() == numEmp) {
                return new Empresa((Empresa) p);
            } else {
                return new Empresa(p);
            }
        }
        return null;
    }

    public Assistencia getByNumAssist(int numAssist) {
        for (int i = 0; i < assistencias.size(); i++) {
            Assistencia p = assistencias.get(i);
            if (p.getNumAssist() == numAssist) {
                return new Assistencia((Assistencia) p);
            } else {
                return new Assistencia(p);
            }
        }
        return null;
    }

    public Cliente getByNumCli(int numCli) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente p = clientes.get(i);
            if (p.getNumCli() == numCli) {
                return new Cliente((Cliente) p);
            } else {
                return new Cliente(p);
            }
        }
        return null;
    }

    public ArrayList<Tecnico> getTecnicos() {
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        for (int i = 0; i < this.tecnicos.size(); i++) {
            Tecnico p = this.tecnicos.get(i);
            tecnicos.add(new Tecnico( p ));
        }
        return tecnicos;
    }

    public ArrayList<Cliente> getClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        for (int i = 0; i < this.clientes.size(); i++) {
            Cliente p = this.clientes.get(i);
            clientes.add(new Cliente( p ));
        }
        return clientes;
    }

    public ArrayList<Assistencia> getAssistencias() {
        ArrayList<Assistencia> assistencias = new ArrayList<>();
        for (int i = 0; i < this.assistencias.size(); i++) {
            Assistencia p = this.assistencias.get(i);
            assistencias.add(new Assistencia( p ));
        }
        return assistencias;
    }

    public ArrayList<Tecnico> getTecnicosAntes(Data limite) {
        ArrayList<Tecnico> tecnicosAntes = new ArrayList<>();
        for (int i = 0; i < tecnicos.size(); i++) {
            Tecnico t = tecnicos.get(i);
            if (!t.getDataNascimento().ePosterior(limite)) {
                tecnicosAntes.add(t);
            }
        }
        return tecnicosAntes;
    }

    public ArrayList<Particular> getParticulares() {
        return (ArrayList<Particular>) clientes.clone();
    }

    public ArrayList<Empresa> getEmpresas() {
        return (ArrayList<Empresa>) clientes.clone();
    }

    public ArrayList<Cliente> getCliente() {
        return (ArrayList<Cliente>) clientes.clone();
    }

    public void adicionarClientePart(Particular clienteNovo) {
        //validaPosicaoInstituicao(posicaoInstituicao);
        //for (int i = 0; i < instituicoes.size(); i++) {
            //Instituicao instituicao = instituicoes.get(i);
            List<Particular> clientesExistentes = getParticulares();
            for (int indiceExistentes = 0; indiceExistentes < clientesExistentes.size(); indiceExistentes++) {
                if(clientesExistentes.get(indiceExistentes).getNumPar() == clienteNovo.getNumPar()){
                    throw new NumParDuplicadoException("Impossivel adicionar um cliente já existente");
                }
            }
        particulares.add(clienteNovo);
    }

    public void adicionarClienteEmpresa(Empresa clienteNovo) {
        //validaPosicaoInstituicao(posicaoInstituicao);
        //for (int i = 0; i < instituicoes.size(); i++) {
        //Instituicao instituicao = instituicoes.get(i);
        List<Empresa> clientesExistentes = getEmpresas();
        for (int indiceExistentes = 0; indiceExistentes < clientesExistentes.size(); indiceExistentes++) {
            if(clientesExistentes.get(indiceExistentes).getNumEmp() == clienteNovo.getNumEmp()){
                throw new NumParDuplicadoException("Impossivel adicionar um cliente já existente");
            }
        }
        empresas.add(clienteNovo);
    }

    public void adicionarCliente(Cliente clienteNovo) {
        //validaPosicaoInstituicao(posicaoInstituicao);
        //for (int i = 0; i < instituicoes.size(); i++) {
        //Instituicao instituicao = instituicoes.get(i);
        List<Cliente> clientesExistentes = getCliente();
        for (int indiceExistentes = 0; indiceExistentes < clientesExistentes.size(); indiceExistentes++) {
            if(clientesExistentes.get(indiceExistentes).getNumCli() == clienteNovo.getNumCli()){
                throw new NumParDuplicadoException("Impossivel adicionar um cliente já existente");
            }
        }
        clientes.add(clienteNovo);
    }

    @Override
    public String toString() {
        return "LojaReparacoes{" +
                "tecnicos=" + tecnicos +
                ", clientes=" + clientes +
                '}';
    }

    public Tecnico removeTecnicoNumTec(int numTec) {
        Tecnico tecnico = getByNumTec(numTec);
        if (tecnico != null) {
            tecnicos.remove(tecnico);
            return tecnico;
        }
        return null;
    }

    public Particular removeClienteNumPar(int numPar) {
        Particular particular = getByNumPar(numPar);
        if (particular != null) {
            particulares.remove(particular);
            return particular;
        }
        return null;
    }

    public Empresa removeClienteNumEmp(int numEmp) {
        Empresa empresa = getByNumEmp(numEmp);
        if (empresa != null) {
            empresas.remove(empresa);
            return empresa;
        }
        return null;
    }

    public Assistencia removeAssistencia(int numAssist) {
        Assistencia assistencia = getByNumAssist(numAssist);
        if (assistencia != null) {
            assistencias.remove(assistencia);
            return assistencia;
        }
        return null;
    }
}
