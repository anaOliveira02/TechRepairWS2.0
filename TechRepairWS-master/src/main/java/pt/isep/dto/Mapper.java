//package pt.isep.dto;
//
//import com.company.model.*;
//import com.company.model.partial.*;
//import pt.isep.model.Assistencia;
//import pt.isep.model.Cliente;
//import pt.isep.model.Data;
//import pt.isep.model.Tecnico;
//
//import java.util.ArrayList;
//
//public class Mapper {
//
//    public static DataDTO data2dataDTO(Data data) throws NullPointerException{
//        DataDTO dataDTO = new DataDTO();
//        dataDTO.setDia(data.getDia());
//        dataDTO.setMes(data.getMes());
//        dataDTO.setAno(data.getAno());
//        return dataDTO;
//    }
//
//    public static Data dataDTO2data(DataDTO dataDTO) throws NullPointerException {
//        Data data = null;
//        data = new Data(dataDTO.getDia(), dataDTO.getMes(), dataDTO.getAno());
//        return data;
//    }
//
//    public static TecnicoDTO tecnico2TecnicoDTO(Tecnico tecnico) throws NullPointerException {
//        TecnicoDTO tecnicoDTO = new TecnicoDTO();
//        tecnicoDTO.setNumTec(tecnico.getNumTec());
//        tecnicoDTO.setNome(tecnico.getNome());
//        DataDTO dataDTO = data2dataDTO(tecnico.getDataNascimento());
//        tecnicoDTO.setDataNascimento(dataDTO);
//        return tecnicoDTO;
//    }
//    public static Tecnico tecnicoDTO2Tecnico(TecnicoDTO tecnicoDTO) throws NullPointerException {
//        Tecnico tecnico = null;
//        Data data = dataDTO2data(tecnicoDTO.getDataNascimento());
//        tecnico = new Tecnico(tecnicoDTO.getNumTec(), tecnicoDTO.getNome(), tecnicoDTO.getDataNascimento());
//        return tecnico;
//    }

//    public static TecnicosPartial tecnicoPartialDTO2TecnicoPartial(TecnicoPartialDTO tecnicoPartialDTO) throws NullPointerException {
//        TecnicosPartial tecnicosPartial = null;
//        tecnicosPartial = new TecnicosPartial(tecnicoPartialDTO.getNumTec(), tecnicoPartialDTO.getNome());
//        return tecnicosPartial;
//    }



//    public static ListaTecnicoPartial listaTecnicoPartialDTO2ListaTecnicoPartial(ListaTecnicoPartialDTO listaTecnicoPartialDTO) throws NullPointerException {
//        ArrayList<TecnicosPartial> tecnicosPartials = new ArrayList<TecnicosPartial>();
//        ArrayList<TecnicoPartialDTO> tecnicosDTO = listaTecnicoPartialDTO.getTecnicos();
//        if(tecnicosDTO != null) {
//            for (TecnicoPartialDTO tecnicoPartialDTO : tecnicosDTO) {
//                try {
//                    TecnicosPartial tecnicosPartial = tecnicoPartialDTO2TecnicoPartial(tecnicoPartialDTO);
//                    tecnicosPartials.add(tecnicosPartial);
//                } catch (NullPointerException e) {
//                    //does nothing. Actually, nothing is added to arraylist
//                }
//            }
//        }
//        ListaTecnicoPartial listaTecnicoPartial = new ListaTecnicoPartial(tecnicosPartials);
//        return listaTecnicoPartial;
//    }



//    public static ClienteDTO cliente2ClienteDTO(Cliente cliente) throws NullPointerException {
//        ClienteDTO clienteDTO = new ClienteDTO();
//        clienteDTO.setNif(cliente.getNif());
//        clienteDTO.setNome(cliente.getNome());
//        //DataDTO dataDTO = data2dataDTO(pessoa.getNascimento());
//        //pessoaDTO.setNascimento(dataDTO);
//        return clienteDTO;
//    }
//
//    public static AssistenciaDTO assistencia2AssistenciaDTO(Assistencia assistencia) throws NullPointerException {
//        AssistenciaDTO assistenciaDTO = new AssistenciaDTO();
//        assistenciaDTO.setNumAssist(assistencia.getNumAssist());
//        assistenciaDTO.setAssunto(assistencia.getAssunto());
//        assistenciaDTO.setEquipamento(assistencia.getEquipamento());
//        assistenciaDTO.setEstado(assistencia.getEstado());
//        assistenciaDTO.setMarca(assistencia.getMarca());
//        assistenciaDTO.setModelo(assistencia.getModelo());
//        assistenciaDTO.setNumSerie(assistencia.getNumSerie());
//        assistenciaDTO.setTecnico(assistencia.getTecnico());
//        //DataDTO dataDTO = data2dataDTO(pessoa.getNascimento());
//        //pessoaDTO.setNascimento(dataDTO);
//        return assistenciaDTO;
//    }
//
//    public static OrcamentoDTO orcamento2OrcamentoDTO(Orcamento orcamento) throws NullPointerException {
//        OrcamentoDTO orcamentoDTO = new OrcamentoDTO();
//        orcamentoDTO.setNumOrc(orcamento.getNumOrc());
//        orcamentoDTO.setResponsavel(orcamento.getResponsavel());
//        orcamentoDTO.setValor(orcamento.getValor());
//        DataDTO dataDTO = data2dataDTO(orcamento.getDataOrcamento());
//        orcamentoDTO.setData(dataDTO);
//        return orcamentoDTO;
//    }
//
//    public static Cliente clienteDTO2Cliente(ClienteDTO clienteDTO) throws NullPointerException {
//        Cliente cliente = null;
//        //Data data = dataDTO2data(pessoaDTO.getNascimento());
//        cliente = new Cliente(clienteDTO.getNif(), clienteDTO.getNome());
//        return cliente;
//    }
//
//    public static Assistencia assistenciaDTO2Assistencia(AssistenciaDTO assistenciaDTO) throws NullPointerException {
//        Assistencia assistencia = null;
//        //Data data = dataDTO2data(pessoaDTO.getNascimento());
//        assistencia = new Assistencia(assistenciaDTO.getNumAssist(), assistenciaDTO.getAssunto(), assistenciaDTO.getEstado(), assistenciaDTO.getEquipamento(), assistenciaDTO.getMarca(), assistenciaDTO.getModelo(), assistenciaDTO.getNumSerie(), assistenciaDTO.getTecnico());
//        return assistencia;
//    }
//
//    public static Orcamento orcamentoDTO2Orcamento(OrcamentoDTO orcamentoDTO) throws NullPointerException {
//        Orcamento orcamento = null;
//        Data data = dataDTO2data(orcamentoDTO.getData());
//        orcamento = new Orcamento(orcamentoDTO.getNumOrc(), orcamentoDTO.getData(), orcamentoDTO.getResponsavel(), orcamentoDTO.getValor());
//        return orcamento;
//    }
//
//    public static ClientePartial clientePartialDTO2ClientePartial(ClientePartialDTO clientePartialDTO) throws NullPointerException {
//        ClientePartial clientePartial = null;
//        clientePartial = new ClientePartial(clientePartialDTO.getNif(), clientePartialDTO.getNome());
//        return clientePartial;
//    }
//
//    public static AssistenciaPartial assistenciaPartialDTO2AssistenciaPartial(AssistenciaPartialDTO assistenciaPartialDTO) throws NullPointerException {
//        AssistenciaPartial assistenciaPartial = null;
//        assistenciaPartial = new AssistenciaPartial(assistenciaPartialDTO.getNumAssis(), assistenciaPartialDTO.getAssunto(), assistenciaPartialDTO.getTecnico());
//        return assistenciaPartial;
//    }
//
//    public static OrcamentoPartial orcamentoPartialDTO2OrcamentoPartial(OrcamentoPartialDTO orcamentoPartialDTO) throws NullPointerException {
//        OrcamentoPartial orcamentoPartial = null;
//        orcamentoPartial = new OrcamentoPartial(orcamentoPartialDTO.getNumOrc(), orcamentoPartialDTO.getResponsavel(), orcamentoPartialDTO.getValor());
//        return orcamentoPartial;
//    }
//
//    public static ListaClientePartial listaClientePartialDTO2ListaClientePartial(ListaClientePartialDTO listaClientePartialDTO) throws NullPointerException {
//        ArrayList<ClientePartial> clientePartials = new ArrayList<ClientePartial>();
//        ArrayList<ClientePartialDTO> clientesDTO = listaClientePartialDTO.getClientes();
//        if(clientesDTO != null) {
//            for (ClientePartialDTO clientePartialDTO : clientesDTO) {
//                try {
//                    ClientePartial clientePartial = clientePartialDTO2ClientePartial(clientePartialDTO);
//                    clientePartials.add(clientePartial);
//                } catch (NullPointerException e) {
//                    //does nothing. Actually, nothing is added to arraylist
//                }
//            }
//        }
//        ListaClientePartial listaClientePartial = new ListaClientePartial(clientePartials);
//        return listaClientePartial;
//    }
//
//    public static ListaAssistenciaPartial listaAssistenciaPartialDTO2ListaAssistenciaPartial(ListaAssistenciaPartialDTO listaAssistenciaPartialDTO) throws NullPointerException {
//        ArrayList<AssistenciaPartial> assistenciaPartials = new ArrayList<AssistenciaPartial>();
//        ArrayList<AssistenciaPartialDTO> assistenciasDTO = listaAssistenciaPartialDTO.getAssistencias();
//        if(assistenciasDTO != null) {
//            for (AssistenciaPartialDTO assistenciaPartialDTO : assistenciasDTO) {
//                try {
//                    AssistenciaPartial assistenciaPartial = assistenciaPartialDTO2AssistenciaPartial(assistenciaPartialDTO);
//                    assistenciaPartials.add(assistenciaPartial);
//                } catch (NullPointerException e) {
//                    //does nothing. Actually, nothing is added to arraylist
//                }
//            }
//        }
//        ListaAssistenciaPartial listaAssistenciaPartial = new ListaAssistenciaPartial(assistenciaPartials);
//        return listaAssistenciaPartial;
//    }
//
//    public static ListaOrcamentoPartial listaOrcamentoPartialDTO2ListaOrcamentoPartial(ListaOrcamentoPartialDTO listaOrcamentoPartialDTO) throws NullPointerException {
//        ArrayList<OrcamentoPartial> orcamentoPartials = new ArrayList<OrcamentoPartial>();
//        ArrayList<OrcamentoPartialDTO> orcamentosDTO = listaOrcamentoPartialDTO.getOrcamentos();
//        if(orcamentosDTO != null) {
//            for (OrcamentoPartialDTO orcamentoPartialDTO : orcamentosDTO) {
//                try {
//                    OrcamentoPartial orcamentoPartial = orcamentoPartialDTO2OrcamentoPartial(orcamentoPartialDTO);
//                    orcamentoPartials.add(orcamentoPartial);
//                } catch (NullPointerException e) {
//                    //does nothing. Actually, nothing is added to arraylist
//                }
//            }
//        }
//        ListaOrcamentoPartial listaOrcamentoPartial = new ListaOrcamentoPartial(orcamentoPartials);
//        return listaOrcamentoPartial;
//    }
//}
