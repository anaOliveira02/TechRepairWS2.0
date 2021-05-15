package pt.isep.service;

import pt.isep.dao.Dados;
import pt.isep.dto.*;
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

    public static ListaAssistenciaDTO getAssistencias() {
        ListaAssistenciaDTO listaAssistenciaDTO= null;
        LojaReparacoes drsn = Dados.carregarDados();
        ArrayList<Assistencia> assistencias = drsn.getAssistencias();
        ListaClienteDTO = Converter.listaassistencias2ListaAssistenciasDTO(assistencias);
        return listaAssistenciaDTO;
    }

    public static Assistencia getAssistencia(int numAssist) {
        Assistencia resultado = null ;
        LojaReparacoes drsn = Dados.carregarDados();
        if (numAssist != 0) {
            resultado = drsn.getByNumAssist(numAssist);
            if(resultado == null){
                throw new NumParNaoEncontrado("Assistencia nao encontrada");
            }
            Dados.guardarDados(drsn);
            return resultado;
        } else {
            throw new NumParInvalidoException("Numero de Assistencia invalida");
        }
    }
}
