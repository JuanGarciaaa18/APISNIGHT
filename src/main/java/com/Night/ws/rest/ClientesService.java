package com.Night.ws.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Night.ws.dao.ClientesDao;
import com.Night.ws.vo.ClientesVo;

@RestController
@RequestMapping("/servicio/clientes")
public class ClientesService {

    @Autowired
    private ClientesDao clienteDao;

    @GetMapping("hola")
    public String saludo() {
        return "Este es el saludo de Cliente web";
    }

    @GetMapping("clientes")
    public ResponseEntity<ClientesVo> getCliente(@RequestParam(value = "id") String cedula) {
        ClientesVo cliente = clienteDao.consultarClientePorCedula(cedula);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("clientes-list")
    public ResponseEntity<List<ClientesVo>> getListaClientes() {
        List<ClientesVo> clientes = clienteDao.obtenerListaClientes();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping("guardar/clientes")
    public ResponseEntity<ClientesVo> registrarCliente(@RequestBody ClientesVo cliente) {
        ClientesVo nuevoCliente = clienteDao.registrarCliente(cliente);
        if (nuevoCliente != null) {
            return ResponseEntity.ok(nuevoCliente);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("actualizar/clientes")
    public ResponseEntity<ClientesVo> actualizarCliente(@RequestBody ClientesVo cliente) {
        ClientesVo actualizado = clienteDao.actualizarCliente(cliente);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable String id) {
        boolean eliminado = clienteDao.eliminarCliente(id);
        if (eliminado) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
