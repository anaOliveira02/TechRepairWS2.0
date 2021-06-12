package pt.isep.controller;

//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import pt.isep.dto.*;
//import pt.isep.model.Assistencia;
//import pt.isep.model.Orcamento;
//import pt.isep.service.AssistenciasService;
//import pt.isep.service.OrcamentosService;
//
//@RestController
//@RequestMapping("/api")
//public class OrçamentoController {
//
//    @RequestMapping(value = "/orcamento",
//            method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_XML_VALUE,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> addOrcamento(@RequestBody OrcamentoDTO orcamento) {
//        try {
//            OrcamentosService.addOrcamento(orcamento);
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }
//    @RequestMapping(value = "/orcamentoRemove/{numOrc}",
//            method = RequestMethod.DELETE,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> removeOrcamento(@PathVariable("numOrc") int numOrc) {
//        try {
//            OrcamentosService.removeOrcamento(numOrc);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }
//    @RequestMapping(value = "/orcamentos",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> getOrcamentos() {
//        try {
//            ListaOrcamentoDTO listaOrcamentoDTO = OrcamentosService.getOrcamentos();
//            if (listaOrcamentoDTO != null) {
//                return new ResponseEntity<>(listaOrcamentoDTO, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }
//    @RequestMapping(value = "/orcamento/{numOrc}",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> getOrcamento(@PathVariable("numOrc") int numOrc) {
//        try {
//            Orcamento orcamentoDTO = OrcamentosService.getOrcamento(numOrc);
//            if (orcamentoDTO != null) {
//                return new ResponseEntity<>(orcamentoDTO, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }
//}

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.isep.dto.*;
import pt.isep.service.OrcamentosService;
import pt.isep.service.TecnicosService;

@RestController
@RequestMapping("/api")
public class OrçamentoController {
    @RequestMapping(value = "/orcamentos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getOrcamentos() {
        try {
            ListaOrcamentoPartialDTO listaOrcamentoPartialDTO = OrcamentosService.getOrcamentos();
            if (listaOrcamentoPartialDTO != null) {
                return new ResponseEntity<>(listaOrcamentoPartialDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(value = "/orcamentos/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getOrcamento(@PathVariable("id") int nr) {
        try {
            OrcamentoDTO orcamentoDTO = OrcamentosService.getOrcamento(nr);
            if (orcamentoDTO != null) {
                return new ResponseEntity<>(orcamentoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(value = "/orcamentos",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addOrcamento(@RequestBody OrcamentoDTO orcamentoDTO) {
        try {
            OrcamentosService.addOrcamento(orcamentoDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/orcamentos/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateOrcamento(@PathVariable("id") int nr, @RequestBody OrcamentoDTO orcamentoDTO) {
        try {
            OrcamentosService.updateOrcamento(nr, orcamentoDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/orcamentos/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removeOrcamento(@PathVariable("id") int nr) {
        try {
            OrcamentosService.removeOrcamento(nr);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
}
