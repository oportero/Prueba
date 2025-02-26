/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.banco.BancoPrueba.Controller;

import com.banco.BancoPrueba.Dto.DtoPersona;
import com.banco.BancoPrueba.Entidades.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.banco.BancoPrueba.Entidades.Cliente;
import com.banco.BancoPrueba.Exception.DatosNoEncontradoException;
import com.banco.BancoPrueba.Exception.ErrorGrabacionException;
import com.banco.BancoPrueba.Servicio.ServicioPersona;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/clientes")
public class PersonaController {
    
    @Autowired
    private ServicioPersona servicioPersona;

    @PostMapping("/guardarPersona")
    public ResponseEntity<?> guardarPersona(@RequestBody Cliente datosCliente) {

        try {
            Cliente nuevoCliente = servicioPersona.guardarPersonaCliente(datosCliente);
            return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
        } catch (ErrorGrabacionException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        } 

    }
    
    
    @GetMapping("/obtenerPersonas")
    public ResponseEntity<List<Persona>> obtenerPersona() {
        try {

            return ResponseEntity.ok(servicioPersona.obtenerPersonas());
        } catch (DatosNoEncontradoException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar datos de clientes", e);
        }
    }
    
    
    @GetMapping("/obtenerPersonaDto/{ci}")
    public ResponseEntity<Set<DtoPersona>> obtenerPersonaDto(@PathVariable("ci") String ci) {
        try {

            return ResponseEntity.ok(servicioPersona.obtenerPersonasDto(ci));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar datos del cliente", e);

        }
    }

//    @PutMapping("/{id}")
//    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
//        return servicioPersona.updateCliente(id, cliente);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteCliente(@PathVariable Long id) {
//        servicioPersona.deleteCliente(id);
//    }      
}
