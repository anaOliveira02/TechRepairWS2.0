package pt.isep.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pt.isep.dto.AssistenciaDTO;
import pt.isep.dto.ErroDTO;
import pt.isep.dto.ListaAssistenciaDTO;
import pt.isep.dto.ListaClienteDTO;
import pt.isep.model.Assistencia;
import pt.isep.model.Empresa;
import pt.isep.model.Particular;
import pt.isep.service.AssistenciasService;
import pt.isep.service.ClientesService;

public class AssistenciasController {

    @RequestMapping(value = "/assistencia",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addAssistencia(@RequestBody AssistenciaDTO assistencia) {
        try {
            AssistenciasService.addAssistencia(assistencia);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(value = "/assistencia/{numAssist}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removeAssistencia(@PathVariable("numAssist") int numAssist) {
        try {
            AssistenciasService.removeAssistencia(numAssist);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(value = "/assistencias",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getAssistencias() {
        try {
            ListaAssistenciaDTO listaAssistenciaDTO = AssistenciasService.getAssistencias();
            if (listaAssistenciaDTO != null) {
                return new ResponseEntity<>(listaAssistenciaDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/assistencia/{numAssist}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getAssistencia(@PathVariable("numAssist") int numAssist) {
        try {
            Assistencia assistenciaDTO = AssistenciasService.getAssistencia(numAssist);
            if (assistenciaDTO != null) {
                return new ResponseEntity<>(assistenciaDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
}
