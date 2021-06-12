package pt.isep.service;

import pt.isep.dao.Dados;
import pt.isep.dto.*;
import pt.isep.exception.ConversaoException;
import pt.isep.exception.ElementoNaoExistenteException;
import pt.isep.exception.NumParInvalidoException;
import pt.isep.exception.NumParNaoEncontrado;
import pt.isep.model.Assistencia;
import pt.isep.model.LojaReparacoes;
import pt.isep.model.Orcamento;
import pt.isep.model.Tecnico;

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
            throw new ElementoNaoExistenteException("Orçamento não encontrada");
        }
    }

    public static ListaOrcamentoPartialDTO getOrcamentos() {
        LojaReparacoes lojaReparacoes = Dados.carregarDados();
        ArrayList<Orcamento> orcamentos = lojaReparacoes.getOrcamentos();
        ListaOrcamentoPartialDTO listaOrcamentoPartialDTO = Converter.listaOrcamento2ListaOrcamentoPartialDTO(orcamentos);
        return listaOrcamentoPartialDTO;
    }

//    public static ListaOrcamentoDTO getOrcamentos() {
//        ListaOrcamentoDTO listaOrcamentoDTO= null;
//        LojaReparacoes drsn = Dados.carregarDados();
//        ArrayList<Orcamento> orcamentos = drsn.getOrcamentos();
//        ListaOrcamentoDTO = Converter.listaorcamentos2ListaOrcamentosDTO(orcamentos);
//        return listaOrcamentoDTO;
//    }

//    public static Orcamento getOrcamento(int numOrc) {
//        Orcamento resultado = null ;
//        LojaReparacoes drsn = Dados.carregarDados();
//        if (numOrc != 0) {
//            resultado = drsn.getByNumOrc(numOrc);
//            if(resultado == null){
//                throw new NumParNaoEncontrado("Orçamento nao encontrado");
//            }
//            Dados.guardarDados(drsn);
//            return resultado;
//        } else {
//            throw new NumParInvalidoException("Numero de Orçamento invalido");
//        }
//    }

    public static OrcamentoDTO getOrcamento(int nr) {
        LojaReparacoes lojaReparacoes = Dados.carregarDados();
        Orcamento orcamento = lojaReparacoes.getOrcamento(nr);
        if (orcamento == null) {
            return null;
        }
        OrcamentoDTO orcamentoDTO = Converter.orcamento2OrcamentoDTO(orcamento);
        if(orcamentoDTO != null){
            return orcamentoDTO;
        }else{
            throw new ConversaoException("OrçamentoFullDTO");
        }

    }

    public static void updateOrcamento(int nr, OrcamentoDTO orcamentoDTO) {
        Orcamento orcamento = Converter.orcamentoDTO2Orcamento(orcamentoDTO);
        if (orcamento != null) {
            LojaReparacoes lojaReparacoes = Dados.carregarDados();
            lojaReparacoes.updateOrcamento(nr, orcamento);
            Dados.guardarDados(lojaReparacoes);
        } else {
            throw new ConversaoException("OrcamentoDTO");
        }
    }
}
