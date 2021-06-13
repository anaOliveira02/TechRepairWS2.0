package pt.isep.service;

//import pt.isep.dao.Dados;
//import pt.isep.dto.*;
//import pt.isep.exception.*;
//import pt.isep.model.*;
//
//import java.util.ArrayList;
//
//public class ClientesService {
//
//    private static Object ListaClienteDTO;
//
////    public static void addClienteParticular(Particular clienteNovo/*, int numPar, long telemovel*/ ) {
////        addClientePart(clienteNovo/*, numPar, telemovel*/);
////    }
//
////    public static void addCliente(ParticularDTO clienteNovo) {
////        LojaReparacoes drsn = Dados.carregarDados();
////        Particular novo = Converter.clienteDTO2Cliente(clienteNovo);
////        drsn.adicionarClientePart(novo);
////        Dados.guardarDados(drsn);
////    }
//
////    public static void addClienteEmpresa(EmpresaDTO clienteNovo) {
////        LojaReparacoes drsn = Dados.carregarDados();
////        Empresa novo = Converter.empresaDTO2Empresa(clienteNovo);
////        drsn.adicionarClienteEmpresa(novo);
////        Dados.guardarDados(drsn);
////    }
//
//    public static void addCliente(ClienteDTO clienteNovo) {
//        LojaReparacoes drsn = Dados.carregarDados();
//        Cliente novo = Converter.clienteDTO2Cliente(clienteNovo);
//        drsn.adicionarCliente(novo);
//        Dados.guardarDados(drsn);
//    }
//
//    public static void removeCliente(int numCli) {
//        LojaReparacoes drsn = Dados.carregarDados();
//        //Particular p = drsn.getByNumPar(numPar);
//        if (numCli != 0) {
//            drsn.removeClienteNumCli(numCli);
//            Dados.guardarDados(drsn);
//        } else {
//            throw new ElementoNaoExistenteException("Cliente não encontrado");
//        }
//    }
//
////    public static void removeClienteEmpresa(int numEmp) {
////        LojaReparacoes drsn = Dados.carregarDados();
////        if (numEmp != 0) {
////            drsn.removeClienteNumEmp(numEmp);
////            Dados.guardarDados(drsn);
////        } else {
////            throw new ElementoNaoExistenteException("Cliente não encontrado");
////        }
////    }
//
//    public static Cliente getCliente(int numCli) {
//        Cliente resultado = null ;
//        LojaReparacoes drsn = Dados.carregarDados();
//        if (numCli != 0) {
//            resultado = drsn.getByNumCli(numCli);
//            if(resultado == null){
//                throw new NumTecNaoEncontradoException("Tecnico nao encontrado");
//            }
//            Dados.guardarDados(drsn);
//            return resultado;
//        } else {
//            throw new NumTecInvalidoException("Numero de tecnico invalido");
//        }
//    }
////    public static Particular getClientePart(int numPar) {
////        Particular resultado = null ;
////        LojaReparacoes drsn = Dados.carregarDados();
////        if (numPar != 0) {
////            resultado = drsn.getByNumPar(numPar);
////            if(resultado == null){
////                throw new NumParNaoEncontrado("Cliente Particular nao encontrado");
////            }
////            Dados.guardarDados(drsn);
////            return resultado;
////        } else {
////            throw new NumParInvalidoException("Numero de Cliente Particular invalido");
////        }
////    }
////
////    public static Empresa getClienteEmp(int numEmp) {
////        Empresa resultado = null ;
////        LojaReparacoes drsn = Dados.carregarDados();
////        if (numEmp != 0) {
////            resultado = drsn.getByNumEmp(numEmp);
////            if(resultado == null){
////                throw new NumParNaoEncontrado("Empresa nao encontrada");
////            }
////            Dados.guardarDados(drsn);
////            return resultado;
////        } else {
////            throw new NumParInvalidoException("Numero de Cliente Empresa invalido");
////        }
////    }
//
//    public static ListaClienteDTO getClientes() {
//        ListaClienteDTO listaClienteDTO= null;
//        LojaReparacoes drsn = Dados.carregarDados();
//        ArrayList<Cliente> clientes = drsn.getClientes();
//        listaClienteDTO = Converter.listaClientes2ListaClienteDTO(clientes);
//        return listaClienteDTO;
//    }
//}

import pt.isep.dao.Dados;
import pt.isep.dto.*;
import pt.isep.exception.ConversaoException;
import pt.isep.model.Assistencia;
import pt.isep.model.Cliente;
import pt.isep.model.LojaReparacoes;
import pt.isep.model.Tecnico;

import java.util.ArrayList;

public class ClientesService {

    public static ListaClientePartialDTO getClientes() {
        LojaReparacoes lojaReparacoes = Dados.carregarDados();
        ArrayList<Cliente> clientes = lojaReparacoes.getClientes();
        ListaClientePartialDTO listaClienteDTO = Converter.listaCliente2ListaClientePartialDTO(clientes);
        return listaClienteDTO;
    }

    public static ClienteDTO getCliente(int nr) {
        LojaReparacoes lojaReparacoes = Dados.carregarDados();
        Cliente cliente = lojaReparacoes.getCliente(nr);
        if (cliente == null) {
            return null;
        }
        ClienteDTO clienteDTO = Converter.cliente2ClienteDTO(cliente);
        if(clienteDTO != null){
            return clienteDTO;
        }else{
            throw new ConversaoException("ClienteFullDTO");
        }

    }



//    public static void addCliente(ClienteDTO clienteDTO) {
//
//        Cliente cliente = Converter.clienteDTO2Cliente(clienteDTO);
//        if (cliente != null) {
//            LojaReparacoes lojaReparacoes = Dados.carregarDados();
//            lojaReparacoes.addCliente(cliente);
//            Dados.guardarDados(lojaReparacoes);
//        } else {
//            throw new ConversaoException("ClienteDTO");
//        }
//    }

    public static void addCliente(ClientePartialDTO clienteDTO) {

        Cliente cliente = Converter.clienteDTO2Cliente(clienteDTO);
        if (cliente != null) {
            LojaReparacoes lojaReparacoes = Dados.carregarDados();
            lojaReparacoes.addCliente(cliente);
            Dados.guardarDados(lojaReparacoes);
        } else {
            throw new ConversaoException("ClienteDTO");
        }
    }

    public static void updateCliente(int nr, ClientePartialDTO clienteDTO) {
        Cliente cliente = Converter.clienteDTO2Cliente(clienteDTO);
        if (cliente != null) {
            LojaReparacoes lojaReparacoes = Dados.carregarDados();
            lojaReparacoes.updateCliente(nr, cliente);
            Dados.guardarDados(lojaReparacoes);
        } else {
            throw new ConversaoException("ClienteDTO");
        }
    }

    public static void removeCliente(int nr) {
        LojaReparacoes lojaReparacoes = Dados.carregarDados();
        lojaReparacoes.removeClienteNumCli(
                nr);
        Dados.guardarDados(lojaReparacoes);
    }
}
