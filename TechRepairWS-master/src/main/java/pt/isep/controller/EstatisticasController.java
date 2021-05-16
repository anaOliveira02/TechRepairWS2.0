package pt.isep.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pt.isep.dto.DataDTO;
import pt.isep.dto.ErroDTO;
import pt.isep.dto.ListaClienteDTO;
import pt.isep.dto.ListaTecnicoDTO;
import pt.isep.service.EstatisticasService;

@RestController
@RequestMapping("/api")
public class EstatisticasController {

    @RequestMapping(value = "/estatisticas/5maisvelhos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getNtecnicosMaisVelhos() {
        ListaTecnicoDTO listaTecnicoDTO = EstatisticasService.getNTecnicosMaisVelhos(5);
        if (listaTecnicoDTO != null) {
            return new ResponseEntity<>(listaTecnicoDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/estatisticas/soempresas",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getSoFuncionarios() {
        ListaClienteDTO listaClienteDTO = EstatisticasService.getSoEmpresas();
        if (listaClienteDTO != null) {
            return new ResponseEntity<>(listaClienteDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/estatisticas/nascidosantesde/{dia}/{mes}/{ano}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getSoTecnicos(
            @PathVariable("dia") int dia,
            @PathVariable("mes") int mes,
            @PathVariable("ano") int ano) {
        try {
            ListaTecnicoDTO listaPessoaPartialDTO = EstatisticasService.getNascidosAntesDe(new
                    DataDTO(dia, mes, ano));
            if (listaPessoaPartialDTO != null) {
                return new ResponseEntity<>(listaPessoaPartialDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
}
