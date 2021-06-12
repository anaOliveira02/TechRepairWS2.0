package pt.isep.controller;

//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import pt.isep.dto.*;
//import pt.isep.model.Cliente;
//import pt.isep.service.ClientesService;
//
//@RestController
//@RequestMapping("/api")
//public class ClientesController {
//
//    @RequestMapping(value = "/cliente",
//            method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_XML_VALUE,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> addCliente(@RequestBody ClienteDTO clienteDTO) {
//        try {
//            ClientesService.addCliente(clienteDTO);
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }
////    @RequestMapping(value = "/clienteEmp",
////            method = RequestMethod.POST,
////            consumes = MediaType.APPLICATION_XML_VALUE,
////            produces = MediaType.APPLICATION_XML_VALUE)
////    public ResponseEntity<Object> addClienteEmpresa(@RequestBody EmpresaDTO empresaDTO) {
////        try {
////            ClientesService.addClienteEmpresa(empresaDTO);
////            return new ResponseEntity<>(HttpStatus.CREATED);
////        } catch (Exception e) {
////            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
////        }
////    }
//
//    @RequestMapping(value = "/clienteRemove/{numCli}",
//            method = RequestMethod.DELETE,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> removeCliente(@PathVariable("numPar") int numCli) {
//        try {
//            ClientesService.removeCliente(numCli);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
//        }
//    }
////    @RequestMapping(value = "/clienteEmpRemove/{numEmp}",
////            method = RequestMethod.DELETE,
////            produces = MediaType.APPLICATION_XML_VALUE)
////    public ResponseEntity<Object> removeClienteEmpresa(@PathVariable("numEmp") int numEmp) {
////        try {
////            ClientesService.removeClienteEmpresa(numEmp);
////            return new ResponseEntity<>(HttpStatus.OK);
////        } catch (Exception e) {
////            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
////        }
////    }
//    @RequestMapping(value = "/cliente/{NumCli}",
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
////    @RequestMapping(value = "/clienteEmp/{numEmp}",
////            method = RequestMethod.GET,
////            produces = MediaType.APPLICATION_XML_VALUE)
////    public ResponseEntity<Object> getClienteEmp(@PathVariable("numEmp") int numEmp) {
////        try {
////            Empresa empresaDTO = ClientesService.getClienteEmp(numEmp);
////            if (empresaDTO != null) {
////                return new ResponseEntity<>(empresaDTO, HttpStatus.OK);
////            } else {
////                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
////            }
////        } catch (Exception e) {
////            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
////        }
////    }
//
//    @RequestMapping(value = "/clientes",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Object> getClientes() {
//        try {
//            ListaClienteDTO listaClienteDTO = ClientesService.getClientes();
//            if (listaClienteDTO != null) {
//                return new ResponseEntity<>(listaClienteDTO, HttpStatus.OK);
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
import pt.isep.service.ClientesService;
import pt.isep.service.TecnicosService;

@RestController
@RequestMapping("/api")
public class ClientesController {
    @RequestMapping(value = "/clientes",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getClientes() {
        try {
            ListaClientePartialDTO listaClientePartialDTO = ClientesService.getClientes();
            if (listaClientePartialDTO != null) {
                return new ResponseEntity<>(listaClientePartialDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(value = "/clientes/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getCliente(@PathVariable("id") int nr) {
        try {
            ClienteDTO clienteDTO = ClientesService.getCliente(nr);
            if (clienteDTO != null) {
                return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(value = "/clientes",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addCliente(@RequestBody ClienteDTO clienteDTO) {
        try {
            ClientesService.addCliente(clienteDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/clientes/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateCliente(@PathVariable("id") int nr, @RequestBody ClienteDTO clienteDTO) {
        try {
            ClientesService.updateCliente(nr, clienteDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/clientes/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removeCliente(@PathVariable("id") int nr) {
        try {
            ClientesService.removeCliente(nr);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
}
