package com.Night.ws.dao;

import java.util.List;
import java.util.Iterator;

import org.springframework.stereotype.Service;
import com.Night.ws.utilidades.ClientesUtilidades;
import com.Night.ws.vo.ClientesVo;

@Service
public class ClientesDao {

    public ClientesDao() {
        ClientesUtilidades.iniciarLista();
    }

    public ClientesVo consultarClientePorCedula(String cedula) {
        for (ClientesVo c : ClientesUtilidades.listaClientes) {
            if (c.getcedula().equals(cedula)) {
                return c;
            }
        }
        return null;
    }

    public List<ClientesVo> obtenerListaClientes() {
        return ClientesUtilidades.listaClientes;
    }

    public ClientesVo registrarCliente(ClientesVo clienteVo) {
        for (ClientesVo c : ClientesUtilidades.listaClientes) {
            if (c.getcedula().equals(clienteVo.getcedula())) {
                return null;
            }
        }
        ClientesUtilidades.listaClientes.add(clienteVo);
        return clienteVo;
    }

    public ClientesVo actualizarCliente(ClientesVo cliente) {
        for (ClientesVo c : ClientesUtilidades.listaClientes) {
            if (c.getcedula().equals(cliente.getcedula())) {
                c.setNombre(cliente.getNombre());
                c.setcorreo(cliente.getcorreo());
                c.settelefono(cliente.gettelefono());
                return c;
            }
        }
        return null;
    }

    public boolean eliminarCliente(String cedula) {
        Iterator<ClientesVo> iterator = ClientesUtilidades.listaClientes.iterator();
        while (iterator.hasNext()) {
            ClientesVo c = iterator.next();
            if (c.getcedula().equals(cedula)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}