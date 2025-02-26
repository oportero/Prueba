/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banco.BancoPrueba.Integracion;

import com.banco.BancoPrueba.Controller.PersonaController;
import com.banco.BancoPrueba.Dto.DtoPersona;
import com.banco.BancoPrueba.Entidades.Cliente;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author oportero
 */
@SpringBootTest
public class ClienteControllerIntegrationTest {

    @Autowired
    private PersonaController personaController;

//    @Test
//    public void testObtenerClientePorCedula() {
//        ResponseEntity<Set<DtoPersona>> response = personaController.obtenerPersonaDto("1802672277");
//        assertEquals(200, response.getStatusCodeValue());
//        assertNotNull(response.getBody());
//    }
}
