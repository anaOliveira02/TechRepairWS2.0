package pt.isep.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import pt.isep.exception.*;
import pt.isep.model.Tecnico;

import javax.servlet.http.Part;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LojaReparacoes implements Serializable {

    private ArrayList<Tecnico> tecnicos = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    //private ArrayList<Particular> particulares = new ArrayList<>();
    //private ArrayList<Empresa> empresas = new ArrayList<>();
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

    public void adicionarOrcamento(Orcamento novo){
        for (int i = 0; i < orcamentos.size(); i++) {
            Orcamento actual = orcamentos.get(i);
            if(novo.getNumOrc() == actual.getNumOrc()){
                throw new AssistenciaExistenteException("Orçamento já existe");
            }
        }
        orcamentos.add(novo);
    }

    public void addCliente(Cliente novoCliente){
        for (int i = 0; i < clientes.size(); i++) {
            Cliente p = clientes.get(i);
            if (p.getNumCli() == novoCliente.getNumCli()) {
                throw new NumParDuplicadoException(novoCliente.getNumCli()+"");
            }
        }
        clientes.add(novoCliente);
    }

    public void addAssistencia(Assistencia assistencia){
        for (int i = 0; i < assistencias.size(); i++) {
            Assistencia p = assistencias.get(i);
            if (p.getNumAssist() == assistencia.getNumAssist()) {
                throw new NumParDuplicadoException(assistencia.getNumAssist()+"");
            }
        }
        assistencias.add(assistencia);
    }


    public Tecnico getByNumTec(int numTec) {
        for (int i = 0; i < tecnicos.size(); i++) {
            Tecnico p = tecnicos.get(i);
            if (p.getNumTec() == numTec) {
                return new Tecnico((Tecnico) p);

            }
        }
        return null;
    }

//    public Particular getByNumPar(int numPar) {
//        for (int i = 0; i < particulares.size(); i++) {
//            Particular p = particulares.get(i);
//            if (p.getNumPar() == numPar) {
//                return new Particular((Particular) p);
//
//            }
//        }
//        return null;
//    }

//    public Empresa getByNumEmp(int numEmp) {
//        for (int i = 0; i < empresas.size(); i++) {
//            Empresa p = empresas.get(i);
//            if (p.getNumEmp() == numEmp) {
//                return new Empresa((Empresa) p);
//
//            }
//        }
//        return null;
//    }

    public Assistencia getByNumAssist(int numAssist) {
        for (int i = 0; i < assistencias.size(); i++) {
            Assistencia p = assistencias.get(i);
            if (p.getNumAssist() == numAssist) {
                return new Assistencia((Assistencia) p);

            }
        }
        return null;
    }

    public Orcamento getByNumOrc(int numOrc) {
        for (int i = 0; i < orcamentos.size(); i++) {
            Orcamento p = orcamentos.get(i);
            if (p.getNumOrc() == numOrc) {
                return new Orcamento((Orcamento) p);

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

    public int getPosicaoByNumAssis(int numAssis) {
        for (int i = 0; i < assistencias.size(); i++) {
            Assistencia p = assistencias.get(i);
            if (p.getNumAssist() == numAssis) {
                return i;
            }
        }
        return -1;
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

    public ArrayList<Orcamento> getOrcamentos() {
        ArrayList<Orcamento> orcamentos = new ArrayList<>();
        for (int i = 0; i < this.orcamentos.size(); i++) {
            Orcamento p = this.orcamentos.get(i);
            orcamentos.add(new Orcamento( p ));
        }
        return orcamentos;
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

    public Tecnico getTecnico(int nr) {
        Tecnico tecnico = getByNumTec(nr);
        if (tecnico != null) {
            Tecnico copia = new Tecnico(tecnico);
            return copia;
        }
        return null;
    }

    public Orcamento getOrcamento(int nr) {
        Orcamento orcamento = getByNumOrc(nr);
        if (orcamento != null) {
            Orcamento copia = new Orcamento(orcamento);
            return copia;
        }
        return null;
    }

    public Cliente getCliente(int nr) {
        Cliente cliente = getByNumCli(nr);
        if (cliente != null) {
            Cliente copia = new Cliente(cliente);
            return copia;
        }
        return null;
    }

    public Assistencia getAssistencia(int nr) {
        Assistencia assistencia = getByNumAssist(nr);
        if (assistencia != null) {
            Assistencia copia = new Assistencia(assistencia);
            return copia;
        }
        return null;
    }

    public void addTecnico(Tecnico tecnico) throws NumeroTecnicoDuplicadoException {
        Tecnico f = getByNumTec(tecnico.getNumTec());
        if (f == null) {
            addTecnico(tecnico);
        } else {
            throw new NumeroTecnicoDuplicadoException(f.getNumTec() + ": Número de Tecnico já existe");
        }
    }

    public void addOrcamento(Orcamento orcamento) throws NumeroTecnicoDuplicadoException {
        Orcamento f = getByNumOrc(orcamento.getNumOrc());
        if (f == null) {
            addOrcamento(orcamento);
        } else {
            throw new NumeroTecnicoDuplicadoException(f.getNumOrc() + ": Número de Orçamento já existe");
        }
    }

//    public ArrayList<Particular> getParticulares() {
//        return (ArrayList<Particular>) clientes.clone();
//    }

//    public ArrayList<Empresa> getEmpresas() {
//        return (ArrayList<Empresa>) clientes.clone();
//    }

    public ArrayList<Cliente> getCliente() {
        return (ArrayList<Cliente>) clientes.clone();
    }

//    public void adicionarClientePart(Particular clienteNovo) {
//            List<Particular> clientesExistentes = getParticulares();
//            for (int indiceExistentes = 0; indiceExistentes < clientesExistentes.size(); indiceExistentes++) {
//                if(clientesExistentes.get(indiceExistentes).getNumPar() == clienteNovo.getNumPar()){
//                    throw new NumParDuplicadoException("Impossivel adicionar um cliente já existente");
//                }
//            }
//        particulares.add(clienteNovo);
//    }

//    public void adicionarClienteEmpresa(Empresa clienteNovo) {
//        List<Empresa> clientesExistentes = getEmpresas();
//        for (int indiceExistentes = 0; indiceExistentes < clientesExistentes.size(); indiceExistentes++) {
//            if(clientesExistentes.get(indiceExistentes).getNumEmp() == clienteNovo.getNumEmp()){
//                throw new NumParDuplicadoException("Impossivel adicionar um cliente já existente");
//            }
//        }
//        empresas.add(clienteNovo);
//    }

    public void adicionarCliente(Cliente clienteNovo) {
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
        else {
            throw new NumParNaoEncontrado("O tecnico não foi encontrado");
        }
    }

    public Assistencia removeAssistenciaPosicao(int pos) {
        validaPosicaoAssistencia(pos);
        return assistencias.remove(pos);
    }

    private void validaPosicaoAssistencia(int pos) {
        if (pos < 0 || pos > assistencias.size()) {
            throw new ElementoNaoExistenteException("A posição " + pos + " não é válida para assistencias");
        }
    }

//    public Cliente removeClienteNumCli(int numCli) {
//        Cliente cliente = getByNumCli(numCli);
//        if (cliente != null) {
//            clientes.remove(cliente);
//            return cliente;
//        }
//        else {
//            throw new NumParNaoEncontrado("O cliente não foi encontrado");
//        }
//    }

//    public Particular removeClienteNumPar(int numPar) {
//        Particular particular = getByNumPar(numPar);
//        if (particular != null) {
//            particulares.remove(particular);
//            return particular;
//        } else {
//            throw new NumParNaoEncontrado("O cliente não foi encontrado");
//        }
//    }

    public Cliente removeClienteNumCli(int numCli) {
        Cliente cliente = getByNumCli(numCli);
        if (cliente != null) {
            clientes.remove(cliente);
            return cliente;
        } else {
            throw new NumParNaoEncontrado("O cliente não foi encontrado");
        }
    }

    public Assistencia removeAssistencia(int numAssist) {
        Assistencia assistencia = getByNumAssist(numAssist);
        if (assistencia != null) {
            assistencias.remove(assistencia);
            return assistencia;
        }
        else {
            throw new AssistenciaExistenteException("A assistencia não foi encontrada");
        }
    }

    public Orcamento removeOrcamento(int numOrc) {
        Orcamento orcamento = getByNumOrc(numOrc);
        if (orcamento != null) {
            orcamentos.remove(orcamento);
            return orcamento;
        } else {
            throw new NumParNaoEncontrado("O orçamento não foi encontrado");
        }
    }

    public ArrayList<Tecnico> getNTecnicosMaisVelhos(int n) {
        Tecnico tecnico;
        boolean flag = false;
        ArrayList<Tecnico>  lista = new ArrayList<>();
        if(n <= 0){
            return lista;
        }

        ArrayList<Tecnico> tecnicos = getTecnicos();
        for (int indice = 0; indice < tecnicos.size(); indice++) {
            tecnico = tecnicos.get(indice);
            Tecnico copiaTecnico = new Tecnico(tecnico);
            for (int indiceMaisVelhos = 0; indiceMaisVelhos < lista.size() && indiceMaisVelhos < n; indiceMaisVelhos++) {
                if (copiaTecnico.getDataNascimento().eAnterior(lista.get(indiceMaisVelhos).getDataNascimento())) {
                    lista.add(indiceMaisVelhos, copiaTecnico);
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                lista.add(copiaTecnico);
            }
        }

        for(int i = lista.size()-1; i > n-1 ; i--){
            lista.remove(i);
        }

        return lista;
    }

//    public ArrayList<Cliente> getSoEmpresas() {
//        ArrayList<Cliente>  lista = new ArrayList<>();
//        Cliente p = null;
//        ArrayList<Cliente> empresas = p.getSoEmpresas();
//
//        lista.addAll(p.getSoEmpresas());
//        return lista;
//    }

    public ArrayList<Tecnico> getTodosTecnicosDataNascAnteriorA(Data data) {
        Tecnico tecnico;
        boolean flag = false;
        ArrayList<Tecnico>  lista = new ArrayList<>();
            ArrayList<Tecnico> tecnicos = getTecnicos();
            for (int indice = 0; indice < tecnicos.size(); indice++) {
                tecnico = tecnicos.get(indice);
                Tecnico copiaTecnico = new Tecnico(tecnico);
                if (tecnico.getDataNascimento().eAnterior(data)) {
                    lista.add(copiaTecnico);
                }
            }
        return lista;
    }

    public void updateTecnico(int nr, Tecnico tecnico) throws ElementoNaoExistenteException {
        removeTecnicoNumTec(nr);
        addTecnico(tecnico);
    }

    public void updateCliente(int nr, Cliente cliente) throws ElementoNaoExistenteException {
        removeClienteNumCli(nr);
        addCliente(cliente);
    }

    public void updateAssistencia(int nr, Assistencia assistencia) throws ElementoNaoExistenteException {
        removeAssistencia(nr);
        addAssistencia(assistencia);
    }

    public void updateOrcamento(int nr, Orcamento orcamento) throws ElementoNaoExistenteException {
        removeOrcamento(nr);
        addOrcamento(orcamento);
    }
}
