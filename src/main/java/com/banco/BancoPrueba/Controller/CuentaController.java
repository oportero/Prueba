/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.banco.BancoPrueba.Controller;

import com.banco.BancoPrueba.Dto.DtoResponse;
import com.banco.BancoPrueba.Entidades.Cliente;
import com.banco.BancoPrueba.Entidades.Cuenta;
import com.banco.BancoPrueba.Exception.ErrorGrabacionException;
import com.banco.BancoPrueba.Servicio.ServicioCuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cuentas")
public class CuentaController {
    
    @Autowired
    private ServicioCuenta servicioCuenta;
    
    @PostMapping("/crearCuentaCliente")
    public ResponseEntity<?> crearCuentaCliente(@RequestBody Cuenta datosCuenta) {

        try {
            Cuenta nuevaCuenta = servicioCuenta.guardarCuentaCliente(datosCuenta);
            return new ResponseEntity<>(nuevaCuenta, HttpStatus.CREATED);
        } catch (ErrorGrabacionException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        } 

    }
   
    
    @GetMapping("/reporte/{cliente}/{fechaInicio}/{fechaFin}")
    public ResponseEntity<?> reporte(@PathVariable("cliente") Long cliente,
            @PathVariable("fechaInicio") String fechaInicio,
            @PathVariable("fechaFin") String fechaFin) {
        try {

            return ResponseEntity.ok(servicioCuenta.reporte(fechaInicio, fechaFin, cliente));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);

        }
    }

  
}
