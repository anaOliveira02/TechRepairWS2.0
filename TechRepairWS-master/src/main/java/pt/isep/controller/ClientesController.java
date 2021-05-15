package pt.isep.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pt.isep.dto.ErroDTO;
import pt.isep.dto.TecnicoDTO;
import pt.isep.model.Particular;
import pt.isep.service.ClientesService;
import pt.isep.service.TecnicosService;

public class ClientesController {

    @RequestMapping(value = "/cliente/part",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addClienteParticular(@RequestBody Particular clientePartDTO) {
        try {
            ClientesService.addClienteParticular(clientePartDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
}
