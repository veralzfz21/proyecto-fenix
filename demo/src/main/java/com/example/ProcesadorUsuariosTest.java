package com.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ProcesadorUsuariosTest {

    @Test
    void debeProcesarAdminsEInvitados() {
        ProcesadorUsuarios procesador = new ProcesadorUsuarios();

        List<String> usuarios = List.of(
            "Ana:1",
            "Luis:2",
            "Maria:1"
        );

        String resultado = procesador.procesarLista(usuarios);

        assertEquals(
            "Admins: Ana,Maria, | Invitados: Luis,",
            resultado
        );
    }
}