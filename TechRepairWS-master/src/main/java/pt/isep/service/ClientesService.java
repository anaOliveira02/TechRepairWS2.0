package pt.isep.service;

import pt.isep.dao.Dados;
import pt.isep.dto.*;
import pt.isep.exception.*;
import pt.isep.model.*;

import java.util.ArrayList;

public class ClientesService {

    private static Object ListaClienteDTO;

//    public static void addClienteParticular(Particular clienteNovo/*, int numPar, long telemovel*/ ) {
//        addClientePart(clienteNovo/*, numPar, telemovel*/);
//    }

    public static void addClientePart(ParticularDTO clienteNovo) {
        LojaReparacoes drsn = Dados.carregarDados();
        Particular novo = Converter.particularDTO2Particular(clienteNovo);
        drsn.adicionarClientePart(novo);
        Dados.guardarDados(drsn);
    }

    public static void addClienteEmpresa(EmpresaDTO clienteNovo) {
        LojaReparacoes drsn = Dados.carregarDados();
        Empresa novo = Converter.empresaDTO2Empresa(clienteNovo);
        drsn.adicionarClienteEmpresa(novo);
        Dados.guardarDados(drsn);
    }

    public static void addCliente(Cliente clienteNovo) {
        LojaReparacoes drsn = Dados.carregarDados();
        drsn.adicionarCliente(clienteNovo);
        Dados.guardarDados(drsn);
    }

    public static void removeClienteParticular(int numPar) {
        LojaReparacoes drsn = Dados.carregarDados();
        if (numPar != 0) {
            drsn.removeClienteNumPar(numPar);
            Dados.guardarDados(drsn);
        } else {
            throw new ElementoNaoExistenteException("Técnico não encontrado");
        }
    }

    public static void removeClienteEmpresa(int numEmp) {
        LojaReparacoes drsn = Dados.carregarDados();
        if (numEmp != 0) {
            drsn.removeClienteNumEmp(numEmp);
            Dados.guardarDados(drsn);
        } else {
            throw new ElementoNaoExistenteException("Técnico não encontrado");
        }
    }

    public static Cliente getCliente(int numCli) {
        Cliente resultado = null ;
        LojaReparacoes drsn = Dados.carregarDados();
        if (numCli != 0) {
            resultado = drsn.getByNumCli(numCli);
            if(resultado == null){
                throw new NumTecNaoEncontradoException("Tecnico nao encontrado");
            }
            Dados.guardarDados(drsn);
            return resultado;
        } else {
            throw new NumTecInvalidoException("Numero de tecnico invalido");
        }
    }
    public static Particular getClientePart(int numPar) {
        Particular resultado = null ;
        LojaReparacoes drsn = Dados.carregarDados();
        if (numPar != 0) {
            resultado = drsn.getByNumPar(numPar);
            if(resultado == null){
                throw new NumParNaoEncontrado("Cliente Particular nao encontrado");
            }
            Dados.guardarDados(drsn);
            return resultado;
        } else {
            throw new NumParInvalidoException("Numero de Cliente Particular invalido");
        }
    }

    public static Empresa getClienteEmp(int numEmp) {
        Empresa resultado = null ;
        LojaReparacoes drsn = Dados.carregarDados();
        if (numEmp != 0) {
            resultado = drsn.getByNumEmp(numEmp);
            if(resultado == null){
                throw new NumParNaoEncontrado("Empresa nao encontrada");
            }
            Dados.guardarDados(drsn);
            return resultado;
        } else {
            throw new NumParInvalidoException("Numero de Cliente Empresa invalido");
        }
    }

    public static ListaClienteDTO getClientes() {
        ListaClienteDTO listaClienteDTO= null;
        LojaReparacoes drsn = Dados.carregarDados();
        ArrayList<Cliente> clientes = drsn.getClientes();
        listaClienteDTO = Converter.listaClientes2ListaClienteDTO(clientes);
        return listaClienteDTO;
    }
}
