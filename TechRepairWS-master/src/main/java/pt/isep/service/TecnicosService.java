//package pt.isep.service;
//
//import pt.isep.dao.Dados;
//import pt.isep.dto.Converter;
//import pt.isep.dto.ListaTecnicoDTO;
//import pt.isep.dto.TecnicoDTO;
//import pt.isep.exception.ElementoNaoExistenteException;
//import pt.isep.exception.NumTecInvalidoException;
//import pt.isep.exception.NumTecNaoEncontradoException;
//import pt.isep.model.LojaReparacoes;
//import pt.isep.model.Tecnico;
//
//import java.util.ArrayList;
//
//public class TecnicosService {
//    private static Object ListaTecnicoDTO;
//
//    public static void addTecnico(TecnicoDTO tecnico) {
//
//        LojaReparacoes lojaReparacoes = Dados.carregarDados();
//        Tecnico novoTecnico = Converter.tecnicoDTO2Tecnico(tecnico);
//
//        lojaReparacoes.adicionarTecnico(novoTecnico);
//        Dados.guardarDados(lojaReparacoes);
//    }
//
//    public static void removeTecnico(int numTec) {
//        LojaReparacoes drsn = Dados.carregarDados();
//
//            if (numTec != 0) {
//                drsn.removeTecnicoNumTec(numTec);
//                Dados.guardarDados(drsn);
//            } else {
//                throw new ElementoNaoExistenteException("Técnico não encontrado");
//            }
//
//    }
//
//    public static ListaTecnicoDTO getTecnicos() {
//        ListaTecnicoDTO listaTecnicoDTO= null;
//        LojaReparacoes drsn = Dados.carregarDados();
//        ArrayList<Tecnico> tecnicos = drsn.getTecnicos();
//        ListaTecnicoDTO = Converter.listaTecnicos2ListaTecnicoDTO(tecnicos);
//        return listaTecnicoDTO;
//    }
//
//    public static Tecnico getTecnico(int numTec) {
//        Tecnico resultado = null ;
//        LojaReparacoes drsn = Dados.carregarDados();
//        if (numTec != 0) {
//            resultado = drsn.getByNumTec(numTec);
//            if(resultado == null){
//                throw new NumTecNaoEncontradoException("Tecnico nao encontrado");
//            }
//            Dados.guardarDados(drsn);
//            return resultado;
//        } else {
//            throw new NumTecInvalidoException("Numero de tecnico invalido");
//        }
//    }
//
//
//}

package pt.isep.service;


import pt.isep.dao.Dados;
import pt.isep.dto.*;
import pt.isep.exception.ConversaoException;
import pt.isep.exception.NumParNaoEncontrado;
import pt.isep.model.Assistencia;
import pt.isep.model.LojaReparacoes;
import pt.isep.model.Tecnico;

import java.util.ArrayList;

public class TecnicosService {

    public static ListaTecnicoPartialDTO getTecnicos() {
        LojaReparacoes lojaReparacoes = Dados.carregarDados();
        ArrayList<Tecnico> tecnicos = lojaReparacoes.getTecnicos();
        ListaTecnicoPartialDTO listaTecnicoDTO = Converter.listaTecnico2ListaTecnicoPartialDTO(tecnicos);
        return listaTecnicoDTO;
    }

//    public static TecnicoDTO getTecnico(int nr) {
//        LojaReparacoes lojaReparacoes = Dados.carregarDados();
//        Tecnico tecnico = lojaReparacoes.getTecnico(nr);
//        if (tecnico == null) {
//            return null;
//        }
//        TecnicoDTO tecnicoDTO = Converter.tecnico2TecnicoDTO(tecnico);
//        if(tecnicoDTO != null){
//            return tecnicoDTO;
//        }else{
//            throw new ConversaoException("TecnicoFullDTO");
//        }
//
//    }

    public static TecnicoPartialDTO getTecnico(int numTec) {
        LojaReparacoes drsn = Dados.carregarDados();
        Tecnico tecnico = drsn.getTecnico(numTec);
        TecnicoPartialDTO tecnicoPartialDTO = Converter.tecnico2TecnicoPartialDTO(tecnico);
        return tecnicoPartialDTO;
    }

//    public static void addTecnico(TecnicoDTO tecnicoDTO) {
//
//        Tecnico tecnico = Converter.tecnicoDTO2Tecnico(tecnicoDTO);
//        if (tecnico != null) {
//            LojaReparacoes lojaReparacoes = Dados.carregarDados();
//            lojaReparacoes.addTecnico(tecnico);
//            Dados.guardarDados(lojaReparacoes);
//        } else {
//            throw new ConversaoException("TecnicoDTO");
//        }
//    }

    public static void addTecnico(TecnicoPartialDTO dto) {
        Tecnico c = Converter.tecnicoDtoToTecnico(dto);
        if (c != null) {
            LojaReparacoes drsn = Dados.carregarDados();
            drsn.addTecnico(c);
            Dados.guardarDados(drsn);
        } else {
            throw new ConversaoException("TecnicoDTO");
        }
    }

//    public static void updateTecnico(int nr, TecnicoDTO tecnicoDTO) {
//        Tecnico tecnico = Converter.tecnicoDtoToTecnico(tecnicoDTO);
//        if (tecnico != null) {
//            LojaReparacoes lojaReparacoes = Dados.carregarDados();
//            lojaReparacoes.updateTecnico(nr, tecnico);
//            Dados.guardarDados(lojaReparacoes);
//        } else {
//            throw new ConversaoException("TecnicoDTO");
//        }
//    }

    public static void updateTecnico(int numTec, TecnicoPartialDTO dto) {
        LojaReparacoes drsn = Dados.carregarDados();
        Tecnico tecnico = (Tecnico) drsn.getByNumTec(numTec);
        //int posicao = drsn.getPosicaoByNumTec((numTec));
        if (tecnico != null) {
            tecnico.setNome(dto.getNome());
            tecnico.setNumTec(dto.getNumTec());
            tecnico.setDataNascimento(dto.getDataNascimento());
            drsn.removeTecnicoNumTec(numTec);
            drsn.addTecnico((tecnico));
            Dados.guardarDados(drsn);
        } else {
            throw new NumParNaoEncontrado("NumTec nao encontrado");
        }
    }

    public static void removeTecnico(int nr) {
        LojaReparacoes lojaReparacoes = Dados.carregarDados();
        lojaReparacoes.removeTecnicoNumTec(nr);
        Dados.guardarDados(lojaReparacoes);
    }
}
