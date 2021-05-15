package pt.isep.service;

import pt.isep.dao.Dados;
import pt.isep.model.LojaReparacoes;
import pt.isep.model.Particular;

public class ClientesService {

    public static void addClienteParticular(Particular clienteNovo/*, int numPar, long telemovel*/ ) {
        addCliente(clienteNovo/*, numPar, telemovel*/);
    }

    public static void addCliente(Particular clienteNovo /*, int numPar, long telemovel*/) {
        LojaReparacoes drsn = Dados.carregarDados();
        //int instituicaoSelecionada = drsn.getInstituicaoPosicaoByNif(nif);
        //if (instituicaoSelecionada != -1) {
            drsn.adicionarCliente(clienteNovo);
            Dados.guardarDados(drsn);
//        } else {
//            throw new NifNaoEncontradoException("Instituicao nao encontrada");
//        }
    }
}
