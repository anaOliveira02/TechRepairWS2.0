//package pt.isep.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import pt.isep.dto.ErroDTO;
//import pt.isep.dto.ListaTecnicoDTO;
//import pt.isep.dto.TecnicoDTO;
//import pt.isep.model.Tecnico;
//import pt.isep.service.TecnicosService;
//
//@RestController
//@RequestMapping("/api")
//public class TecnicosController {
//
//    @RequestMapping(value = "/tecnicos",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> getTecnicos() {
//        try {
//            ListaTecnicoDTO listaTecnicoDTO = TecnicosService.getTecnicos();
//            if (listaTecnicoDTO != null) {
//                return new ResponseEntity<>(listaTecnicoDTO, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }
//    @RequestMapping(value = "/tecnico/{numTec}",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> getTecnico(
//            @PathVariable("numTec") int numTec) {
//        try {
//            Tecnico tecnicoDTO = TecnicosService.getTecnico(numTec);
//            if (tecnicoDTO != null) {
//                return new ResponseEntity<>(tecnicoDTO, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }
//    @RequestMapping(value = "/tecnico",
//            method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_XML_VALUE,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> addTecnico(@RequestBody TecnicoDTO tecnico) {
//        try {
//            TecnicosService.addTecnico(tecnico);
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }
//    @RequestMapping(value = "/tecnicoRemove/{numTec}",
//            method = RequestMethod.DELETE,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> removeTecnico(@PathVariable("numTec") int numTec) {
//        try {
//            TecnicosService.removeTecnico(numTec);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }
//}

package pt.isep.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.isep.dto.*;
import pt.isep.service.AssistenciasService;
import pt.isep.service.TecnicosService;

@RestController
@RequestMapping("/api")
public class TecnicosController {
//    @RequestMapping(value = "/tecnicos",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> getTecnicos() {
//        try {
//            ListaTecnicoPartialDTO listaTecnicoPartialDTO = TecnicosService.getTecnicos();
//            if (listaTecnicoPartialDTO != null) {
//                return new ResponseEntity<>(listaTecnicoPartialDTO, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }
//    @RequestMapping(value = "/tecnicos/{id}",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> getTecnico(@PathVariable("id") int nr) {
//        try {
//            TecnicoDTO tecnicoDTO = TecnicosService.getTecnico(nr);
//            if (tecnicoDTO != null) {
//                return new ResponseEntity<>(tecnicoDTO, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }
//    @RequestMapping(value = "/tecnicos",
//            method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_XML_VALUE,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> addTecnico(@RequestBody TecnicoDTO tecnicoDTO) {
//        try {
//            TecnicosService.addTecnico(tecnicoDTO);
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }
//
//    @RequestMapping(value = "/tecnicos/{id}",
//            method = RequestMethod.PUT,
//            consumes = MediaType.APPLICATION_XML_VALUE,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> updateTecnico(@PathVariable("id") int nr, @RequestBody TecnicoDTO tecnicoDTO) {
//        try {
//            TecnicosService.updateTecnico(nr, tecnicoDTO);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }
//
//    @RequestMapping(value = "/tecnicos/{id}",
//            method = RequestMethod.DELETE,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> removeTecnico(@PathVariable("id") int nr) {
//        try {
//            TecnicosService.removeTecnico(nr);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }

    @RequestMapping(value = "/tecnicos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getTecnicos() {
        try {
            ListaTecnicoPartialDTO tecnicosDTO = TecnicosService.getTecnicos();
            return new ResponseEntity<>(tecnicosDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/tecnico/{bi}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getTecnico(@PathVariable("numTec") int numTec) {
        try {
            TecnicoPartialDTO tecnicoDTO = TecnicosService.getTecnico(numTec);
            return new ResponseEntity<>(tecnicoDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/tecnico",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addTecnico(@RequestBody TecnicoPartialDTO assistenciaDTO) {
        try {
            TecnicosService.addTecnico(assistenciaDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/tecnico/{numTec}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateTecnico(@PathVariable("numTec") int numTec, @RequestBody
            TecnicoPartialDTO dto) {
        try {
            TecnicosService.updateTecnico(numTec, dto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
}
