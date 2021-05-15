package pt.isep.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pt.isep.dto.*;
import pt.isep.model.Assistencia;
import pt.isep.model.Orcamento;
import pt.isep.service.AssistenciasService;
import pt.isep.service.OrcamentosService;

public class OrçamentoController {

    @RequestMapping(value = "/orcamento",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addOrcamento(@RequestBody OrcamentoDTO orcamento) {
        try {
            OrcamentosService.addOrcamento(orcamento);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(value = "/orcamento/{numOrc}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removeOrcamento(@PathVariable("numOrc") int numOrc) {
        try {
            OrcamentosService.removeOrcamento(numOrc);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(value = "/orcamentos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getOrcamentos() {
        try {
            ListaOrcamentoDTO listaOrcamentoDTO = OrcamentosService.getOrcamentos();
            if (listaOrcamentoDTO != null) {
                return new ResponseEntity<>(listaOrcamentoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(value = "/orcamento/{numOrc}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getOrcamento(@PathVariable("numOrc") int numOrc) {
        try {
            Orcamento orcamentoDTO = OrcamentosService.getOrcamento(numOrc);
            if (orcamentoDTO != null) {
                return new ResponseEntity<>(orcamentoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
}
