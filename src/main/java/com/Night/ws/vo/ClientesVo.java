package com.Night.ws.vo;

public class ClientesVo {

    private String cedula;
    private String nombre;
    private String correo;
    private String telefono;

    public ClientesVo(String cedula, String nombre, String correo, String telefono) {
        super();
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public ClientesVo() {
    }

    public String getcedula() {
        return cedula;
    }

    public void setcedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getcorreo() {
        return correo;
    }

    public void setcorreo(String correo) {
        this.correo = correo;
    }

    public String gettelefono() {
        return telefono;
    }

    public void settelefono(String telefono) {
        this.telefono = telefono;
    }
}