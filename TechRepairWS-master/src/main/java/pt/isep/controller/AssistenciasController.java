package pt.isep.controller;

//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import pt.isep.dto.AssistenciaDTO;
//import pt.isep.dto.ErroDTO;
//import pt.isep.dto.ListaAssistenciaDTO;
//import pt.isep.model.Assistencia;
//import pt.isep.service.AssistenciasService;
//
//@RestController
//@RequestMapping("/api")
//public class AssistenciasController {
//
//    @RequestMapping(value = "/assistencia",
//            method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_XML_VALUE,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> addAssistencia(@RequestBody AssistenciaDTO assistencia) {
//        try {
//            AssistenciasService.addAssistencia(assistencia);
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }
//    @RequestMapping(value = "/assistenciaRemove/{numAssist}",
//            method = RequestMethod.DELETE,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> removeAssistencia(@PathVariable("numAssist") int numAssist) {
//        try {
//            AssistenciasService.removeAssistencia(numAssist);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }
//    @RequestMapping(value = "/assistencias",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> getAssistencias() {
//        try {
//            ListaAssistenciaDTO listaAssistenciaDTO = AssistenciasService.getAssistencias();
//            if (listaAssistenciaDTO != null) {
//                return new ResponseEntity<>(listaAssistenciaDTO, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }
//
//    @RequestMapping(value = "/assistencia/{numAssist}",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> getAssistencia(@PathVariable("numAssist") int numAssist) {
//        try {
//            Assistencia assistenciaDTO = AssistenciasService.getAssistencia(numAssist);
//            if (assistenciaDTO != null) {
//                return new ResponseEntity<>(assistenciaDTO, HttpStatus.OK);
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
import pt.isep.service.AssistenciasService;
import pt.isep.service.ClientesService;
import pt.isep.service.TecnicosService;

@RestController
@RequestMapping("/api")
public class AssistenciasController {
//    @RequestMapping(value = "/assistencias",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> getAssistencias() {
//        try {
//            ListaAssistenciaPartialDTO listaAssistenciaPartialDTO = AssistenciasService.getAssistencias();
//            if (listaAssistenciaPartialDTO != null) {
//                return new ResponseEntity<>(listaAssistenciaPartialDTO, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }
//    @RequestMapping(value = "/assistencias/{id}",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> getAssistencia(@PathVariable("id") int nr) {
//        try {
//            AssistenciaDTO assistenciaDTO = AssistenciasService.getAssistencia(nr);
//            if (assistenciaDTO != null) {
//                return new ResponseEntity<>(assistenciaDTO, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }
//    @RequestMapping(value = "/assitencias",
//            method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_XML_VALUE,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> addAssistencia(@RequestBody AssistenciaDTO assistenciaDTO) {
//        try {
//            AssistenciasService.addAssistencia(assistenciaDTO);
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }
//
//    @RequestMapping(value = "/assistencias/{id}",
//            method = RequestMethod.PUT,
//            consumes = MediaType.APPLICATION_XML_VALUE,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> updateAssistencia(@PathVariable("id") int nr, @RequestBody AssistenciaDTO assistenciaDTO) {
//        try {
//            AssistenciasService.updateAssistencia(nr, assistenciaDTO);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }
//
//    @RequestMapping(value = "/assistencias/{id}",
//            method = RequestMethod.DELETE,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> removeAssistencia(@PathVariable("id") int nr) {
//        try {
//            AssistenciasService.removeAssistencia(nr);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }

    @RequestMapping(value = "/assistencias",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getAssistencias() {
//        try {
//            ListaAssistenciaPartialDTO assistenciasDTO = AssistenciasService.getAssistencias();
//            return new ResponseEntity<>(assistenciasDTO, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
        try {
            ListaAssistenciaPartialDTO listaClientePartialDTO = AssistenciasService.getAssistencias();
            if (listaClientePartialDTO != null) {
                return new ResponseEntity<>(listaClientePartialDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }

    }

    @RequestMapping(value = "/assistencia/{bi}",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> getAssistencia(@PathVariable("numAssis") int numAssis) {
//        try {
//            AssistenciaPartialDTO assistenciaDTO = AssistenciasService.getAssistencia(numAssis);
//            return new ResponseEntity<>(assistenciaDTO, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getAssistencia(@PathVariable("id") int nr) {
        try {
            AssistenciaDTO clienteDTO = AssistenciasService.getAssistencia(nr);
            if (clienteDTO != null) {
                return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/assistencia",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addAssistencia(@RequestBody AssistenciaPartialDTO assistenciaDTO) {
        try {
            AssistenciasService.addAssistencia(assistenciaDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/assistencia/{numAssis}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateAssistencia(@PathVariable("numAssis") int numAssis, @RequestBody
            AssistenciaPartialDTO dto) {
        try {
            AssistenciasService.updateAssistencia(numAssis, dto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
}