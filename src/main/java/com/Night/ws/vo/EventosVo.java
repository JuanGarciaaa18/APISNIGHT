package com.Night.ws.vo;

public class EventosVo {

    private String id;
    private String nombre;
    private String ArtistaInvitado;
    private String Fecha;
   
    public EventosVo(String id, String nombre, String ArtistaInvitado, String Fecha) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.ArtistaInvitado = ArtistaInvitado;
        this.Fecha = Fecha;
    }

    public EventosVo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getArtistaInvitado() {
        return ArtistaInvitado;
    }

    public void setArtistaInvitado(String ArtistaInvitado) {
        this.ArtistaInvitado = ArtistaInvitado;
    }
    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha ;
    }
}

