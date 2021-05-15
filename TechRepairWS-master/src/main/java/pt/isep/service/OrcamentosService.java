package pt.isep.service;

import pt.isep.dao.Dados;
import pt.isep.dto.*;
import pt.isep.exception.ElementoNaoExistenteException;
import pt.isep.exception.NumParInvalidoException;
import pt.isep.exception.NumParNaoEncontrado;
import pt.isep.model.Assistencia;
import pt.isep.model.LojaReparacoes;
import pt.isep.model.Orcamento;

import java.util.ArrayList;

public class OrcamentosService {

    private static Object ListaOrcamentoDTO;

    public static void addOrcamento(OrcamentoDTO orcamento) {

        LojaReparacoes lojaReparacoes = Dados.carregarDados();
        Orcamento novoOrcamento = Converter.orcamentoDTO2Orcamento(orcamento);
        lojaReparacoes.adicionarOrcamento(novoOrcamento);
        Dados.guardarDados(lojaReparacoes);
    }

    public static void removeOrcamento(int numOrc) {
        LojaReparacoes drsn = Dados.carregarDados();
        if (numOrc != 0) {
            drsn.removeOrcamento(numOrc);
            Dados.guardarDados(drsn);
        } else {
            throw new ElementoNaoExistenteException("Assistência não encontrada");
        }
    }

    public static ListaOrcamentoDTO getOrcamentos() {
        ListaOrcamentoDTO listaOrcamentoDTO= null;
        LojaReparacoes drsn = Dados.carregarDados();
        ArrayList<Orcamento> orcamentos = drsn.getOrcamentos();
        ListaOrcamentoDTO = Converter.listaorcamentos2ListaOrcamentosDTO(orcamentos);
        return listaOrcamentoDTO;
    }

    public static Orcamento getOrcamento(int numOrc) {
        Orcamento resultado = null ;
        LojaReparacoes drsn = Dados.carregarDados();
        if (numOrc != 0) {
            resultado = drsn.getByNumOrc(numOrc);
            if(resultado == null){
                throw new NumParNaoEncontrado("Orçamento nao encontrado");
            }
            Dados.guardarDados(drsn);
            return resultado;
        } else {
            throw new NumParInvalidoException("Numero de Orçamento invalido");
        }
    }
}
