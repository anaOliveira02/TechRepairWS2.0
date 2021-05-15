package pt.isep.dto;

import pt.isep.model.Cliente;
import pt.isep.model.Data;
import pt.isep.model.Tecnico;

import java.util.ArrayList;
import java.util.Date;

public class Converter {

    private static DataDTO dataDTO;

    public static Tecnico tecnicoDTO2Tecnico(TecnicoDTO tecnico) {
        //Data novaData = dataDTO2data(tecnico.getDataNascimento());
        return new Tecnico(tecnico.getNumTec(), tecnico.getNome(), tecnico.getDataNascimento(), tecnico.getEmail());
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
            listaClienteDTO.getClientes().add(new ClienteDTO(clientes.get(i).getNumCli(),clientes.get(i).getNome(), clientes.get(i).getNif()));
        }
        return listaClienteDTO;
    }

//    private static Data date2dataDTO(Date dataNascimento) {
//
//    }
}
