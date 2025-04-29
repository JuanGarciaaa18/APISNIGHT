package com.Night.ws.rest;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Night.ws.dao.EventosDao;
import com.Night.ws.vo.EventosVo;

@RestController
@RequestMapping("/servicio/evento")
public class EventosService {

    @Autowired(required = true)
    private EventosDao EventosDao;

    @GetMapping("hola")
    public String saludo() {
        return "Este es el saludo de Evento web";
    }

    @GetMapping("Eventos")
    public ResponseEntity<EventosVo> getEvento(
            @RequestParam(value = "id", defaultValue = "0") String id) {
        
    	EventosVo Eventos = EventosDao.consultarPersonaIndividual(id);

        if (Eventos == null) {
            Eventos = new EventosVo();
        }

        return ResponseEntity.ok(Eventos);
    }
    
    @GetMapping("Eventos-list")
    public ResponseEntity<List<EventosVo>> getEventolist() {
        List<EventosVo> Eventos = EventosDao.obtenerlistaEventos();
        return ResponseEntity.ok(Eventos);
    }

    @PostMapping("guardar/evento")
    public ResponseEntity<EventosVo> RegistrarEvento(@RequestBody EventosVo Evento){
    	
    	EventosVo miEvento=EventosDao.RegistrarEvento(Evento);
    	if(miEvento!=null) {
    		return ResponseEntity.ok(miEvento);
    	}else {
    		return ResponseEntity.notFound().build();
    	}
    }
    
    @PutMapping("actualizar/evento")
    public ResponseEntity<EventosVo> actualizarUsuario(@RequestBody EventosVo Evento) {
    	
    	EventosVo miEvento = null;
        if (EventosDao.consultarPersonaIndividual(Evento.getId()) != null) {
        	miEvento = EventosDao.actualizarEvento(Evento);
            if (miEvento != null) {
                return ResponseEntity.ok(miEvento);
            } else {		
                return ResponseEntity.notFound().build(); 
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable String id) {
        EventosVo miPersona = EventosDao.consultarPersonaIndividual(id);
        if (miPersona != null) {
            EventosDao.eliminarPersona(miPersona);
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.notFound().build();
    }

}