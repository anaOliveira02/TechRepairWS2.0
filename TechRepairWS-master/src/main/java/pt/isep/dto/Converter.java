package pt.isep.dto;

import pt.isep.model.*;

import java.util.ArrayList;
import java.util.Date;

public class Converter {

//    private static DataDTO dataDTO;
//
//
//
//
//
//
//
    public static ListaTecnicoDTO listaTecnicos2ListaTecnicoDTO(ArrayList<Tecnico> tecnicos) {
        ListaTecnicoDTO listaTecnicoDTO = new ListaTecnicoDTO();
        for (int i = 0; i < tecnicos.size(); i++) {
            listaTecnicoDTO.getTecnicos().add(new TecnicoDTO(tecnicos.get(i).getNumTec(),tecnicos.get(i).getNome(), tecnicos.get(i).getDataNascimento()));
        }
        return listaTecnicoDTO;
    }
//
    public static ListaClienteDTO listaClientes2ListaClienteDTO(ArrayList<Cliente> clientes) {
        ListaClienteDTO listaClienteDTO = new ListaClienteDTO();
        for (int i = 0; i < clientes.size(); i++) {
            //Data data = dataDTO2data(tecnicos.get(i).getDataNascimento());
            listaClienteDTO.getClientes().add(new ClienteDTO(clientes.get(i).getNumCli(),clientes.get(i).getNome(), clientes.get(i).getNif()));
        }
        return listaClienteDTO;
    }
//
    public static ListaAssistenciaDTO listaassistencias2ListaAssistenciasDTO(ArrayList<Assistencia> assistencias) {
        ListaAssistenciaDTO listaAssistenciaDTO = new ListaAssistenciaDTO();
        for (int i = 0; i < assistencias.size(); i++) {
            listaAssistenciaDTO.getAssistencias().add(new AssistenciaDTO(assistencias.get(i).getNumAssist(),assistencias.get(i).getAssunto(), assistencias.get(i).getEstado(), assistencias.get(i).getEquipamento(), assistencias.get(i).getMarca(), assistencias.get(i).getModelo(), assistencias.get(i).getNumSerie(), assistencias.get(i).getTecnico()));
        }
        return listaAssistenciaDTO;
    }
//
    public static ListaOrcamentoDTO listaorcamentos2ListaOrcamentosDTO(ArrayList<Orcamento> orcamentos) {
        ListaOrcamentoDTO listaOrcamentoDTO = new ListaOrcamentoDTO();
        for (int i = 0; i < orcamentos.size(); i++) {
            listaOrcamentoDTO.getOrcamentos().add(new OrcamentoDTO(orcamentos.get(i).getNumOrc(),orcamentos.get(i).getDataOrcamento(), orcamentos.get(i).getResponsavel(), orcamentos.get(i).getValor()));
        }
        return listaOrcamentoDTO;
    }

//
//
//
//
//
//
//
//


    public static DataDTO data2dataDTO(Data data) throws NullPointerException {
        DataDTO dataDTO = new DataDTO();
        dataDTO.setDia(data.getDia());
        dataDTO.setMes(data.getMes());
        dataDTO.setAno(data.getAno());
        return dataDTO;
    }

    public static Data dataDTO2data(DataDTO dataDTO) throws NullPointerException {
        Data data = null;

        data = new Data(dataDTO.getDia(), dataDTO.getMes(), dataDTO.getAno());

        return data;
    }

    public static TecnicoPartialDTO tecnico2TecnicoPartialDTO(Tecnico tecnico) throws NullPointerException {
        TecnicoPartialDTO tecnicoPartialDTO = new TecnicoPartialDTO();
        tecnicoPartialDTO.setNumTec(tecnico.getNumTec());
        tecnicoPartialDTO.setNome(tecnico.getNome());

        return tecnicoPartialDTO;
    }

    public static AssistenciaPartialDTO assistencia2AssistenciaPartialDTO(Assistencia assistencia) throws NullPointerException {
        AssistenciaPartialDTO assistenciaPartialDTO = new AssistenciaPartialDTO();
        assistenciaPartialDTO.setNumAssis(assistencia.getNumAssist());
        assistenciaPartialDTO.setAssunto(assistencia.getAssunto());

        return assistenciaPartialDTO;
    }

    public static OrcamentoPartialDTO orcamento2OrcamentoPartialDTO(Orcamento orcamento) throws NullPointerException {
        OrcamentoPartialDTO orcamentoPartialDTO = new OrcamentoPartialDTO();
        orcamentoPartialDTO.setNumOrc(orcamento.getNumOrc());
        orcamentoPartialDTO.setValor(orcamento.getValor());

        return orcamentoPartialDTO;
    }

    public static TecnicoDTO tecnico2TecnicoDTO(Tecnico tecnico) throws NullPointerException {
        TecnicoDTO tecnicoDTO = new TecnicoDTO();
        tecnicoDTO.setNumTec(tecnico.getNumTec());
        tecnicoDTO.setNome(tecnico.getNome());
        DataDTO dataDTO = data2dataDTO(tecnico.getDataNascimento());
        tecnicoDTO.setDataNascimento(dataDTO);
        return tecnicoDTO;
    }

    public static Tecnico tecnicoDTO2Tecnico(TecnicoDTO tecnicoDTO) throws NullPointerException {
        Tecnico tecnico = null;

        Data data = dataDTO2data(tecnicoDTO.getDataNascimento());
        tecnico = new Tecnico(tecnicoDTO.getNumTec(), tecnicoDTO.getNome(), data);

        return tecnico;
    }

    public static ListaTecnicoPartialDTO listaTecnico2ListaTecnicoPartialDTO(ArrayList<Tecnico> tecnicos) throws NullPointerException {
        ArrayList<TecnicoPartialDTO> tecnicosDTO = new ArrayList<>();
        for (Tecnico tecnico : tecnicos) {
            try {
                TecnicoPartialDTO tecnicoPartialDTO = tecnico2TecnicoPartialDTO(tecnico);
                tecnicosDTO.add(tecnicoPartialDTO);
            } catch (NullPointerException e) {
                //does nothing. Actually, nothing is added to arraylist
            }
        }
        ListaTecnicoPartialDTO listaTecnicoPartialDTO = new ListaTecnicoPartialDTO();
        listaTecnicoPartialDTO.setTecnicos(tecnicosDTO);
        return listaTecnicoPartialDTO;
    }

    public static ListaAssistenciaPartialDTO listaAssistencia2ListaAssistenciaPartialDTO(ArrayList<Assistencia> assistencias) throws NullPointerException {
        ArrayList<AssistenciaPartialDTO> assistenciaDTO = new ArrayList<>();
        for (Assistencia assistencia : assistencias) {
            try {
                AssistenciaPartialDTO assistenciaPartialDTO = assistencia2AssistenciaPartialDTO(assistencia);
                assistenciaDTO.add(assistenciaPartialDTO);
            } catch (NullPointerException e) {
                //does nothing. Actually, nothing is added to arraylist
            }
        }
        ListaAssistenciaPartialDTO listaAssistenciaPartialDTO = new ListaAssistenciaPartialDTO();
        listaAssistenciaPartialDTO.setAssistencias(assistenciaDTO);
        return listaAssistenciaPartialDTO;
    }

    public static ListaOrcamentoPartialDTO listaOrcamento2ListaOrcamentoPartialDTO(ArrayList<Orcamento> orcamentos) throws NullPointerException {
        ArrayList<OrcamentoPartialDTO> orcamentoDTO = new ArrayList<>();
        for (Orcamento orcamento : orcamentos) {
            try {
                OrcamentoPartialDTO orcamentoPartialDTO = orcamento2OrcamentoPartialDTO(orcamento);
                orcamentoDTO.add(orcamentoPartialDTO);
            } catch (NullPointerException e) {
                //does nothing. Actually, nothing is added to arraylist
            }
        }
        ListaOrcamentoPartialDTO listaOrcamentoPartialDTO = new ListaOrcamentoPartialDTO();
        listaOrcamentoPartialDTO.setOrcamentos(orcamentoDTO);
        return listaOrcamentoPartialDTO;
    }

    public static ClientePartialDTO cliente2ClientePartialDTO(Cliente cliente) throws NullPointerException {
        ClientePartialDTO clientePartialDTO = new ClientePartialDTO();
        clientePartialDTO.setNome(cliente.getNome());
        clientePartialDTO.setNif(cliente.getNif());
        return clientePartialDTO;
    }
    public static ClienteDTO cliente2ClienteDTO(Cliente cliente) throws NullPointerException {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNif(cliente.getNif());
        clienteDTO.setNome(cliente.getNome());
        return clienteDTO;
    }

    public static Cliente clienteDTO2Cliente(ClienteDTO clienteDTO) throws NullPointerException {
        Cliente cliente = null;

        //Data data = dataDTO2data(funcionarioDTO.getNascimento());
        cliente = new Cliente(clienteDTO.getNif(), clienteDTO.getNome(), cliente.getNumCli());

        return cliente;
    }

    public static ListaClientePartialDTO listaCliente2ListaClientePartialDTO(ArrayList<Cliente> clientes) throws NullPointerException {
        ArrayList<ClientePartialDTO> clientesDTO = new ArrayList<>();
        for (Cliente cliente : clientes) {
            try {
                ClientePartialDTO clientePartialDTO = cliente2ClientePartialDTO(cliente);
                clientesDTO.add(clientePartialDTO);
            } catch (NullPointerException e) {
                //does nothing. Actually, nothing is added to arraylist
            }
        }
        ListaClientePartialDTO listaClientePartialDTO = new ListaClientePartialDTO();
        listaClientePartialDTO.setClientes(clientesDTO);
        return listaClientePartialDTO;
    }

    public static AssistenciaDTO assistencia2AssistenciaDTO(Assistencia assistencia) throws NullPointerException {
        AssistenciaDTO assistenciaDTO = new AssistenciaDTO();
        assistenciaDTO.setNumAssist(assistencia.getNumAssist());
        assistenciaDTO.setAssunto(assistencia.getAssunto());
        assistenciaDTO.setEquipamento(assistencia.getEquipamento());
        assistenciaDTO.setEstado(assistencia.getEstado());
        assistenciaDTO.setMarca(assistencia.getMarca());
        assistenciaDTO.setModelo(assistencia.getModelo());
        assistenciaDTO.setNumSerie(assistencia.getNumSerie());
        assistenciaDTO.setTecnico(assistencia.getTecnico());
        //DataDTO dataDTO = data2dataDTO(pessoa.getNascimento());
        //pessoaDTO.setNascimento(dataDTO);
        return assistenciaDTO;
    }

    public static OrcamentoDTO orcamento2OrcamentoDTO(Orcamento orcamento) throws NullPointerException {
        OrcamentoDTO orcamentoDTO = new OrcamentoDTO();
        orcamentoDTO.setNumOrc(orcamento.getNumOrc());
        orcamentoDTO.setResponsavel(orcamento.getResponsavel());
        orcamentoDTO.setValor(orcamento.getValor());
        DataDTO dataDTO = data2dataDTO(orcamento.getDataOrcamento());
        orcamentoDTO.setDataOrcamento(dataDTO);
        return orcamentoDTO;
    }

//    public static Assistencia assistenciaDTO2Assistencia(AssistenciaDTO assistenciaDTO) throws NullPointerException {
//        Assistencia assistencia = null;
//        //Data data = dataDTO2data(pessoaDTO.getNascimento());
//        assistencia = new Assistencia(assistenciaDTO.getNumAssist(), assistenciaDTO.getAssunto(), assistenciaDTO.getEstado(), assistenciaDTO.getEquipamento(), assistenciaDTO.getMarca(), assistenciaDTO.getModelo(), assistenciaDTO.getNumSerie(), assistenciaDTO.getTecnico());
//        return assistencia;
//    }

    public static Assistencia assistenciaDtoToAssistencia(AssistenciaPartialDTO dto){
        Assistencia pt = new Assistencia(dto.getNumAssis(),
                dto.getAssunto(),
                dto.getEstado(),
                dto.getEquipamento(),
                dto.getMarca(),
                dto.getModelo(),
                dto.getNumSerie(),
                dto.getTecnico());

        return pt;
    }

    public static Orcamento orcamentoDTO2Orcamento(OrcamentoDTO orcamentoDTO) throws NullPointerException {
        Orcamento orcamento = null;
        Data data = dataDTO2data(orcamentoDTO.getDataOrcamento());
        orcamento = new Orcamento(orcamentoDTO.getNumOrc(), orcamentoDTO.getDataOrcamento(), orcamentoDTO.getResponsavel(), orcamentoDTO.getValor());
        return orcamento;
    }
}
