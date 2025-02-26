/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banco.BancoPrueba.Servicio;

import com.banco.BancoPrueba.Dto.DtoCliente;
import com.banco.BancoPrueba.Entidades.Cliente;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author oportero
 */
@SpringBootTest
public class ClienteServiceTest {
    @Autowired
    private ServicioPersona servicioPersona;

//    @Test
//    public void testCrearCliente() {
//        Cliente dtoCliente = new Cliente();
//        dtoCliente.setNombre("Jose Martinez");
//        dtoCliente.setClave("9999");
//        dtoCliente.setDireccion("Ambato y Rocafuerte");
//        dtoCliente.setEdad(43);
//        dtoCliente.setEstado("ACT");
//        dtoCliente.setGenero('H');
//        dtoCliente.setIdentificacion("1711750628");
//        dtoCliente.setTelefono("0986546465");
//
//        Cliente nuevoCliente = servicioPersona.guardarPersonaCliente(dtoCliente);
//        assertNotNull(nuevoCliente);
//        assertEquals("Jose Martinez", nuevoCliente.getNombre());
//    }
}
