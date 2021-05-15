package pt.isep.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.isep.dto.ErroDTO;
import pt.isep.dto.ListaTecnicoDTO;
import pt.isep.dto.TecnicoDTO;
import pt.isep.model.Tecnico;
import pt.isep.service.TecnicosService;

@RestController
@RequestMapping("/api")
public class TecnicosController {
/*    @RequestMapping(value = "/tecnico",
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

    @RequestMapping(value = "/tecnico/{numTec}",
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
    }*/

    @RequestMapping(value = "/tecnicos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getTecnicos(@PathVariable("numTec") int numTec) {
        try {
            ListaTecnicoDTO listaTecnicoDTO = TecnicosService.getTecnicos(numTec);
            if (listaTecnicoDTO != null) {
                return new ResponseEntity<>(listaTecnicoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(value = "/tecnico/{numTec}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getTecnico(@PathVariable("numTec") int numTec) {
        try {
            Tecnico tecnicoDTO = TecnicosService.getTecnicos(numTec);
            if (tecnicoDTO != null) {
                return new ResponseEntity<>(tecnicoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(value = "/tecnico",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addTecnico(@PathVariable("numTec") int numTec, @RequestBody Tecnico tecnicoDTO) {
        try {
            TecnicosService.addTecnico(tecnicoDTO, numTec);
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
            TecnicosService.removerTecnico(numTec);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
}