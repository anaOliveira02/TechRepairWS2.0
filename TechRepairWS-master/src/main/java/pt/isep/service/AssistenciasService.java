package pt.isep.service;

import pt.isep.dao.Dados;
import pt.isep.dto.*;
import pt.isep.exception.ConversaoException;
import pt.isep.exception.ElementoNaoExistenteException;
import pt.isep.exception.NumParInvalidoException;
import pt.isep.exception.NumParNaoEncontrado;
import pt.isep.model.*;

import java.util.ArrayList;

public class AssistenciasService {

    private static Object ListaClienteDTO;

//    public static void addAssistencia(AssistenciaDTO assistencia) {
//
//        LojaReparacoes lojaReparacoes = Dados.carregarDados();
//        Assistencia novaAssistencia = Converter.assistenciaDTO2Assistencia(assistencia);
//        lojaReparacoes.adicionarAssistencia(novaAssistencia);
//        Dados.guardarDados(lojaReparacoes);
//    }

    public static void addAssistencia(AssistenciaPartialDTO dto) {
        Assistencia c = Converter.assistenciaDtoToAssistencia(dto);
        if (c != null) {
            LojaReparacoes drsn = Dados.carregarDados();
            drsn.addAssistencia(c);
            Dados.guardarDados(drsn);
        } else {
            throw new ConversaoException("AssistenciaDTO");
        }
    }

    public static void removeAssistencia(int numAssist) {
        LojaReparacoes drsn = Dados.carregarDados();
        if (numAssist != 0) {
            drsn.removeAssistencia(numAssist);
            Dados.guardarDados(drsn);
        } else {
            throw new ElementoNaoExistenteException("Assistência não encontrada");
        }
    }

    public static ListaAssistenciaPartialDTO getAssistencias() {

        LojaReparacoes lojaReparacoes = Dados.carregarDados();
        ArrayList<Assistencia> assistencias = lojaReparacoes.getAssistencias();
        ListaAssistenciaPartialDTO listaAssistenciaDTO = Converter.listaAssistencia2ListaAssistenciaPartialDTO(assistencias);
        return listaAssistenciaDTO;
    }

//    public static Assistencia getAssistencia(int numAssist) {
//        Assistencia resultado = null ;
//        LojaReparacoes drsn = Dados.carregarDados();
//        if (numAssist != 0) {
//            resultado = drsn.getByNumAssist(numAssist);
//            if(resultado == null){
//                throw new NumParNaoEncontrado("Assistencia nao encontrada");
//            }
//            Dados.guardarDados(drsn);
//            return resultado;
//        } else {
//            throw new NumParInvalidoException("Numero de Assistencia invalida");
//        }
//    }

//    public static void updateAssistencia(int nr, AssistenciaDTO assistenciaDTO) {
//        Assistencia assistencia = Converter.assistenciaDTO2Assistencia(assistenciaDTO);
//        if (assistencia != null) {
//            LojaReparacoes lojaReparacoes = Dados.carregarDados();
//            lojaReparacoes.updateAssistencia(nr, assistencia);
//            Dados.guardarDados(lojaReparacoes);
//        } else {
//            throw new ConversaoException("AssistenciaDTO");
//        }
//    }

    public static void updateAssistencia(int numAssis, AssistenciaPartialDTO dto) {
        LojaReparacoes drsn = Dados.carregarDados();
        Assistencia assistencia = (Assistencia) drsn.getByNumAssist(numAssis);
        int posicao = drsn.getPosicaoByNumAssis((numAssis));
        if (assistencia != null) {
            assistencia.setNumAssist(dto.getNumAssis());
            assistencia.setAssunto(dto.getAssunto());
            assistencia.setEquipamento(dto.getEquipamento());
            assistencia.setEstado(dto.getEstado());
            assistencia.setMarca(dto.getMarca());
            assistencia.setModelo(dto.getModelo());
            assistencia.setNumSerie(dto.getNumSerie());
            assistencia.setTecnico(dto.getTecnico());
            drsn.removeAssistenciaPosicao(posicao);
            drsn.addAssistencia((assistencia));
            Dados.guardarDados(drsn);
        } else {
            throw new NumParNaoEncontrado("NumAssis nao encontrado");
        }
    }

//    public static AssistenciaDTO getAssistencia(int nr) {
//        LojaReparacoes lojaReparacoes = Dados.carregarDados();
//        Assistencia assistencia = lojaReparacoes.getAssistencia(nr);
//        if (assistencia == null) {
//            return null;
//        }
//        AssistenciaDTO assistenciaDTO = Converter.assistencia2AssistenciaDTO(assistencia);
//        if(assistenciaDTO != null){
//            return assistenciaDTO;
//        }else{
//            throw new ConversaoException("AssistenciaFullDTO");
//        }
//
//    }

    public static AssistenciaDTO getAssistencia(int numAssis) {
//        LojaReparacoes drsn = Dados.carregarDados();
//        Assistencia assistencia = drsn.getAssistencia(numAssis);
//        AssistenciaPartialDTO assistenciaPartial = Converter.assistencia2AssistenciaPartialDTO(assistencia);
//        return assistenciaPartial;

        LojaReparacoes lojaReparacoes = Dados.carregarDados();
        Assistencia cliente = lojaReparacoes.getAssistencia(numAssis);
        if (cliente == null) {
            return null;
        }
        AssistenciaDTO clienteDTO = Converter.assistencia2AssistenciaDTO(cliente);
        if(clienteDTO != null){
            return clienteDTO;
        }else{
            throw new ConversaoException("AssistenciaFullDTO");
        }
    }

//    public ListaAssistenciaPartialDTO getAssistencias() {
//        LojaReparacoes lojaReparacoes = Dados.carregarDados();
//        ArrayList<Assistencia> assistencias = lojaReparacoes.getAssistencias();
//        ListaAssistenciaPartialDTO listaAssistenciaDTO = Converter.listaAssistencia2ListaAssistenciaPartialDTO(assistencias);
//        return listaAssistenciaDTO;
//    }
}
