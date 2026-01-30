package com.example;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase procesa listas de usuarios. Contiene 'code smells' intencionados.
 */
public class ProcesadorUsuarios {
    private static final int ROL_ADMIN = 1;
    private static final int ROL_INVITADO = 2;
    public void procesarAdmin(String nombre) {
    
        admins += nombre + ",";
    }
    public void procesarInvitado(String nombre) {
        invitados += nombre + ",";
    }
    /**
     * Procesa una lista de cadenas con formato "nombre:rol" y devuelve un resumen 
     * clasificado de usuarios.
     * * @param usuarios Lista de Strings que contienen la información de los usuarios.
     * @return Una cadena de texto con los nombres de administradores e invitados separados.
     */
    // Método con 'code smells': largo, números mágicos, malos nombres.
    public String procesarLista(List<String> usuarios) {
        String admins = "";
        String invitados = "";

        for (String usuario : usuarios) {
            String[] parts = usuario.split(":"); // Formato "nombre:rol"
            if (parts.length == 2) {
                String nombre = parts[0];
                int rol = Integer.parseInt(parts[1]);

                // Número Mágico: 1 es Admin
                if (rol == ROL_ADMIN) {
                    procesarAdmin(nombre);
                }
                // Número Mágico: 2 es Invitado
                else if (rol == ROL_INVITADO) {
                    procesarInvitado(nombre);
                }
            }
        }
        return "Admins: " + admins + " | Invitados: " + invitados;
    }
}