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

    public static void addAssistencia(AssistenciaDTO assistencia) {

        LojaReparacoes lojaReparacoes = Dados.carregarDados();
        Assistencia novaAssistencia = Converter.assistenciaDTO2Assistencia(assistencia);
        lojaReparacoes.adicionarAssistencia(novaAssistencia);
        Dados.guardarDados(lojaReparacoes);
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

    public static void updateAssistencia(int nr, AssistenciaDTO assistenciaDTO) {
        Assistencia assistencia = Converter.assistenciaDTO2Assistencia(assistenciaDTO);
        if (assistencia != null) {
            LojaReparacoes lojaReparacoes = Dados.carregarDados();
            lojaReparacoes.updateAssistencia(nr, assistencia);
            Dados.guardarDados(lojaReparacoes);
        } else {
            throw new ConversaoException("AssistenciaDTO");
        }
    }

    public static AssistenciaDTO getAssistencia(int nr) {
        LojaReparacoes lojaReparacoes = Dados.carregarDados();
        Assistencia assistencia = lojaReparacoes.getAssistencia(nr);
        if (assistencia == null) {
            return null;
        }
        AssistenciaDTO assistenciaDTO = Converter.assistencia2AssistenciaDTO(assistencia);
        if(assistenciaDTO != null){
            return assistenciaDTO;
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
