package pt.isep.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.isep.dto.*;
import pt.isep.model.Cliente;
import pt.isep.model.Empresa;
import pt.isep.model.Particular;
import pt.isep.model.Tecnico;
import pt.isep.service.ClientesService;
import pt.isep.service.TecnicosService;

@RestController
@RequestMapping("/api")
public class ClientesController {

    @RequestMapping(value = "/clientePart",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addClienteParticular(@RequestBody ParticularDTO clientePartDTO) {
        try {
            ClientesService.addClientePart(clientePartDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(value = "/clienteEmp",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addClienteEmpresa(@RequestBody EmpresaDTO empresaDTO) {
        try {
            ClientesService.addClienteEmpresa(empresaDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/clientePartRemove/{numPar}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removeClienteParticular(@PathVariable("numPar") int numPar) {
        try {
            ClientesService.removeClienteParticular(numPar);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(value = "/clienteEmpRemove/{numEmp}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removeClienteEmpresa(@PathVariable("numEmp") int numEmp) {
        try {
            ClientesService.removeClienteEmpresa(numEmp);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(value = "/clientePar/{numPar}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getClientePart(@PathVariable("numPar") int numPar) {
        try {
            Particular particularDTO = ClientesService.getClientePart(numPar);
            if (particularDTO != null) {
                return new ResponseEntity<>(particularDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(value = "/clienteEmp/{numEmp}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getClienteEmp(@PathVariable("numEmp") int numEmp) {
        try {
            Empresa empresaDTO = ClientesService.getClienteEmp(numEmp);
            if (empresaDTO != null) {
                return new ResponseEntity<>(empresaDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/clientes",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getClientes() {
        try {
            ListaClienteDTO listaClienteDTO = ClientesService.getClientes();
            if (listaClienteDTO != null) {
                return new ResponseEntity<>(listaClienteDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
}
