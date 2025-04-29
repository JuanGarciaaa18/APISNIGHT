package com.Night.ws.dao;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Night.ws.utilidades.EventosUtilidades;
import com.Night.ws.vo.EventosVo;

@Service
public class EventosDao {

    public EventosDao() {
        EventosUtilidades.iniciarLista();
    }

    public EventosVo consultarPersonaIndividual(String id) {
        EventosVo eventoEncontrado = null;
        for (EventosVo p : EventosUtilidades.listaEventos) {
            if (p.getId().equals(id)) {
                eventoEncontrado = new EventosVo();
                eventoEncontrado.setId(p.getId());
                eventoEncontrado.setNombre(p.getNombre());
                eventoEncontrado.setArtistaInvitado(p.getArtistaInvitado());
                eventoEncontrado.setFecha(p.getFecha());
                break;
            }
        }
        return eventoEncontrado;
    }

    public List<EventosVo> obtenerlistaEventos() {
        return EventosUtilidades.listaEventos;
    }

    public EventosVo RegistrarEvento(EventosVo nuevoEvento) {
        boolean existe = false;

        for (EventosVo obj : EventosUtilidades.listaEventos) {
            if (obj.getId() != null && obj.getId().equals(nuevoEvento.getId())) {
                existe = true;
                break;
            }
        }

        if (!existe) {
            EventosUtilidades.listaEventos.add(nuevoEvento);
            return nuevoEvento;
        } else {
            return null;
        }
    }

    public EventosVo actualizarEvento(EventosVo eventoActualizado) {
        for (EventosVo obj : EventosUtilidades.listaEventos) {
            if (obj.getId().equals(eventoActualizado.getId())) {
                obj.setNombre(eventoActualizado.getNombre());
                obj.setArtistaInvitado(eventoActualizado.getArtistaInvitado());
                obj.setFecha(eventoActualizado.getFecha());
                return obj;
            }
        }
        return null;
    }

    public void eliminarPersona(EventosVo eventoAEliminar) {
        EventosUtilidades.listaEventos.removeIf(obj -> obj.getId().equals(eventoAEliminar.getId()));
    }
}
 