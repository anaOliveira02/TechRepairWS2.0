package pt.isep.dto;

import pt.isep.model.*;

import java.util.ArrayList;
import java.util.Date;

public class Converter {

    private static DataDTO dataDTO;

    public static Tecnico tecnicoDTO2Tecnico(TecnicoDTO tecnico) {
        //Data novaData = dataDTO2data(tecnico.getDataNascimento());
        return new Tecnico(tecnico.getNumTec(), tecnico.getNome(), tecnico.getDataNascimento(), tecnico.getEmail());
    }

    public static Empresa empresaDTO2Empresa(EmpresaDTO empresa) {
        //Data novaData = dataDTO2data(tecnico.getDataNascimento());
        return new Empresa(empresa.getNumCli(), empresa.getNome(), empresa.getEmail(), empresa.getNif(), empresa.getNumEmp(), empresa.getTelefone());
    }

    public static Particular particularDTO2Particular(ParticularDTO particular) {
        //Data novaData = dataDTO2data(tecnico.getDataNascimento());
        return new Particular(particular.getNumCli(), particular.getNome(), particular.getEmail(), particular.getNif(), particular.getNumPar(), particular.getTelemovel());
    }

    public static Assistencia assistenciaDTO2Assistencia(AssistenciaDTO assistencia) {
        //Data novaData = dataDTO2data(tecnico.getDataNascimento());
        return new Assistencia(assistencia.getNumAssist(), assistencia.getAssunto(), assistencia.getDataPat(), assistencia.getEstado(), assistencia.getEquipamento(), assistencia.getMarca(), assistencia.getModelo(), assistencia.getNumSerie());
    }

    public static Orcamento orcamentoDTO2Orcamento(OrcamentoDTO orcamento) {
        //Data novaData = dataDTO2data(tecnico.getDataNascimento());
        return new Orcamento(orcamento.getNumOrc(), orcamento.getDataOrcamento(), orcamento.getResponsavel());
    }

/*    public static ListaTecnicoDTO listaTecnicos2ListaTecnicosDTO(ArrayList<Tecnico> tecnicos) {
        ListaTecnicoDTO listaTecnicoDTO = new ListaTecnicoDTO();
        for (int i = 0; i < tecnicos.size(); i++) {
            listaTecnicoDTO.getClientes().add(new TecnicoDTO(tecnicos.get(i).getNumTec(),
                    tecnicos.get(i).getNome(), tecnicos.get(i).getDataNascimento()));
        }
        return listaTecnicoDTO;
    }*/

    public static Data dataDTO2data(DataDTO dataDTO){
        Converter.dataDTO = dataDTO;
        return new Data(dataDTO.getDia(), dataDTO.getMes(), dataDTO.getAno());
    }

    public static ListaTecnicoDTO listaTecnicos2ListaTecnicoDTO(ArrayList<Tecnico> tecnicos) {
        ListaTecnicoDTO listaTecnicoDTO = new ListaTecnicoDTO();
        for (int i = 0; i < tecnicos.size(); i++) {
            //Data data = dataDTO2data(tecnicos.get(i).getDataNascimento());
            listaTecnicoDTO.getTecnicos().add(new TecnicoDTO(tecnicos.get(i).getNumTec(),tecnicos.get(i).getNome(), tecnicos.get(i).getDataNascimento(), tecnicos.get(i).getEmail()));
        }
        return listaTecnicoDTO;
    }

    public static ListaClienteDTO listaClientes2ListaClienteDTO(ArrayList<Cliente> clientes) {
        ListaClienteDTO listaClienteDTO = new ListaClienteDTO();
        for (int i = 0; i < clientes.size(); i++) {
            //Data data = dataDTO2data(tecnicos.get(i).getDataNascimento());
            listaClienteDTO.getClientes().add(new ClienteDTO(clientes.get(i).getNumCli(),clientes.get(i).getNome(), clientes.get(i).getEmail(), clientes.get(i).getNif()));
        }
        return listaClienteDTO;
    }

    public static ListaAssistenciaDTO listaassistencias2ListaAssistenciasDTO(ArrayList<Assistencia> assistencias) {
        ListaAssistenciaDTO listaAssistenciaDTO = new ListaAssistenciaDTO();
        for (int i = 0; i < assistencias.size(); i++) {
            //Data data = dataDTO2data(tecnicos.get(i).getDataNascimento());
            listaAssistenciaDTO.getAssistencias().add(new AssistenciaDTO(assistencias.get(i).getNumAssist(),assistencias.get(i).getAssunto(), assistencias.get(i).getDataPat(), assistencias.get(i).getEstado(), assistencias.get(i).getEquipamento(), assistencias.get(i).getMarca(), assistencias.get(i).getModelo(), assistencias.get(i).getNumSerie()));
        }
        return listaAssistenciaDTO;
    }

    public static ListaOrcamentoDTO listaorcamentos2ListaOrcamentosDTO(ArrayList<Orcamento> orcamentos) {
        ListaOrcamentoDTO listaOrcamentoDTO = new ListaOrcamentoDTO();
        for (int i = 0; i < orcamentos.size(); i++) {
            //Data data = dataDTO2data(tecnicos.get(i).getDataNascimento());
            listaOrcamentoDTO.getOrcamentos().add(new OrcamentoDTO(orcamentos.get(i).getNumOrc(),orcamentos.get(i).getDataOrcamento(), orcamentos.get(i).getResponsavel()));
        }
        return listaOrcamentoDTO;
    }

//    private static Data date2dataDTO(Date dataNascimento) {
//
//    }
}
