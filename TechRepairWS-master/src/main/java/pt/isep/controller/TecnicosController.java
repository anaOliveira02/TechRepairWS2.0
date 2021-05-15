package pt.isep.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.isep.dto.ErroDTO;
import pt.isep.dto.ListaTecnicoDTO;
import pt.isep.dto.TecnicoDTO;
import pt.isep.service.TecnicosService;

@RestController
@RequestMapping("/api")
public class TecnicosController {
    @RequestMapping(value = "/tecnico",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addTecnico(@RequestBody TecnicoDTO tecnico) {
        try {
            TecnicosService.addTecnico(tecnico);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/tecnico/{numTec}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removeTecnico(@PathVariable("numTec") int numTec) {
        try {
            TecnicosService.removeTecnico(numTec);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/intituicao/get",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getFuncionarios(@PathVariable("numTec") int numTec) {
        try {
            ListaTecnicoDTO listaTecnicoDTO = TecnicosService.getTecnicos();
            if (listaTecnicoDTO != null) {
                return new ResponseEntity<>(listaTecnicoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
}
