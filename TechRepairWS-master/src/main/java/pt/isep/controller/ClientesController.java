package pt.isep.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pt.isep.dto.ErroDTO;
import pt.isep.dto.ListaClienteDTO;
import pt.isep.dto.ListaTecnicoDTO;
import pt.isep.dto.TecnicoDTO;
import pt.isep.model.Cliente;
import pt.isep.model.Empresa;
import pt.isep.model.Particular;
import pt.isep.model.Tecnico;
import pt.isep.service.ClientesService;
import pt.isep.service.TecnicosService;

public class ClientesController {

    @RequestMapping(value = "/cliente.part",
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
    @RequestMapping(value = "/cliente.emp",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addClienteEmpresa(@RequestBody Empresa empresaDTO) {
        try {
            ClientesService.addClienteEmpresa(empresaDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
//    @RequestMapping(value = "/cliente",
//            method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_XML_VALUE,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> addCliente(@RequestBody Cliente clienteDTO) {
//        try {
//            ClientesService.addCliente(clienteDTO);
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }
    @RequestMapping(value = "/cliente.part/{numPar}",
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
    @RequestMapping(value = "/cliente.emp/{numEmp}",
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
    @RequestMapping(value = "/cliente.par/{numPar}",
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
    @RequestMapping(value = "/cliente.emp/{numEmp}",
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
//    @RequestMapping(value = "/cliente.par/{numPar}",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> getCliente(@PathVariable("numCli") int numCli) {
//        try {
//            Cliente clienteDTO = ClientesService.getCliente(numCli);
//            if (clienteDTO != null) {
//                return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }
//    @RequestMapping(value = "/clients.part",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> getClientesPart() {
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
    @RequestMapping(value = "/clients",
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
