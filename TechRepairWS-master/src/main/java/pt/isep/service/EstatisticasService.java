package pt.isep.service;

import pt.isep.dao.Dados;
import pt.isep.dto.Converter;
import pt.isep.dto.DataDTO;
import pt.isep.dto.ListaClienteDTO;
import pt.isep.dto.ListaTecnicoDTO;
import pt.isep.model.Cliente;
import pt.isep.model.Data;
import pt.isep.model.LojaReparacoes;
import pt.isep.model.Tecnico;

import java.util.ArrayList;

public class EstatisticasService {
    public static ListaTecnicoDTO getNTecnicosMaisVelhas(int n) {
        ListaTecnicoDTO listaTecnicoDTO = null;
        LojaReparacoes drsn = Dados.carregarDados();
        ArrayList<Tecnico> tecnicos = drsn.getNTecnicosMaisVelhos(n);
        listaTecnicoDTO = Converter.listaTecnicos2ListaTecnicoDTO(tecnicos);
        return listaTecnicoDTO;
    }
    public static ListaTecnicoDTO getSoEmpresas() {
        ListaClienteDTO listaClienteDTO = null;
        LojaReparacoes drsn = Dados.carregarDados();
        ArrayList<Cliente> clientes = drsn.getSoEmpresas();
        listaClienteDTO = Converter.listaClientes2ListaClienteDTO(clientes);
        return listaClienteDTO;
    }
    public static ListaTecnicoDTO getNascidosAntesDe(DataDTO dataDTO) {
        ListaTecnicoDTO listaTecnicoDTO = null;
        Data data = Converter.dataDTO2data(dataDTO);
        LojaReparacoes drsn = Dados.carregarDados();
        ArrayList<Tecnico> pessoas = drsn.getTodosTecnicosDataNascAnteriorA(data);
        listaTecnicoDTO = Converter.listaTecnicos2ListaTecnicoDTO(tecnicos);
        return listaTecnicoDTO;
    }
}
