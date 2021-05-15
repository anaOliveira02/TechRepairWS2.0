package pt.isep.service;

import pt.isep.dao.Dados;
import pt.isep.dto.Converter;
import pt.isep.dto.ListaTecnicoDTO;
import pt.isep.dto.TecnicoDTO;
import pt.isep.exception.ElementoNaoExistenteException;
import pt.isep.exception.NumTecInvalidoException;
import pt.isep.exception.NumTecNaoEncontradoException;
import pt.isep.model.LojaReparacoes;
import pt.isep.model.Tecnico;

import java.util.ArrayList;

public class TecnicosService {
    private static Object ListaTecnicoDTO;

    public static void addTecnico(TecnicoDTO tecnico) {
        //traduzir dto em modelo
        LojaReparacoes lojaReparacoes = Dados.carregarDados();
        Tecnico novoTecnico = Converter.tecnicoDTO2Tecnico(tecnico);

        //LojaReparacoes lojaReparacoes = Dados.carregarDados();
        lojaReparacoes.adicionarTecnico(novoTecnico);
        Dados.guardarDados(lojaReparacoes);

        //poderia ser preciso traduzir modelo > DTO
    }

    public static void removeTecnico(int numTec) {
        LojaReparacoes drsn = Dados.carregarDados();
        if (numTec != 0) {
            drsn.removeTecnicoNumTec(numTec);
            Dados.guardarDados(drsn);
        } else {
            throw new ElementoNaoExistenteException("Técnico não encontrado");
        }
    }

    public static ListaTecnicoDTO getTecnicos() {
        ListaTecnicoDTO listaTecnicoDTO= null;
        LojaReparacoes drsn = Dados.carregarDados();
        ArrayList<Tecnico> tecnicos = drsn.getTecnicos();
        ListaTecnicoDTO = Converter.listaTecnicos2ListaTecnicoDTO(tecnicos);
        return listaTecnicoDTO;
    }

    public static Tecnico getTecnico(int numTec) {
        Tecnico resultado = null ;
        LojaReparacoes drsn = Dados.carregarDados();
        if (numTec != 0) {
            resultado = drsn.getByNumTec(numTec);
            if(resultado == null){
                throw new NumTecNaoEncontradoException("Tecnico nao encontrado");
            }
            Dados.guardarDados(drsn);
            return resultado;
        } else {
            throw new NumTecInvalidoException("Numero de tecnico invalido");
        }
    }


}
