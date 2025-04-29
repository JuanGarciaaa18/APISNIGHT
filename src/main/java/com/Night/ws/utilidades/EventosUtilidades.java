package com.Night.ws.utilidades;

import java.util.ArrayList;
import java.util.List;

import com.Night.ws.vo.EventosVo;

public class EventosUtilidades {

    public final static int TIPO_ADMIN = 1;
    public final static int TIPO_EMPLEADO = 2;
    static int bandera = 0;

    public static List<EventosVo> listaEventos = new ArrayList<EventosVo>();

    public static void iniciarLista() {
        if (bandera == 0) {
        	listaEventos.add(new EventosVo("111","Noche De Perreo", "Rayoy y Toby" , "03/05/2025"));
        	listaEventos.add(new EventosVo("222","El Boquisucio", "Luigi21+" , "08/05/2025"));
            bandera = 1;
        }
    }
    
  
}
