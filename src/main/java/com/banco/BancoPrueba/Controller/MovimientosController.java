/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.banco.BancoPrueba.Controller;

import com.banco.BancoPrueba.Entidades.Movimientos;
import com.banco.BancoPrueba.Exception.DatosNoEncontradoException;
import com.banco.BancoPrueba.Exception.SaldoInsuficienteException;
import com.banco.BancoPrueba.Servicio.ServicioMovimientos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/movimientos")
public class MovimientosController {

    @Autowired
    private ServicioMovimientos servicioMovimientos;

    @PostMapping("/realizarMovimiento/")
    public ResponseEntity<?> realizarMovimiento(
            @RequestParam double valorMovimiento,
            @RequestParam String numeroCuenta){

        try {
            Movimientos nuevoMovimiento = servicioMovimientos.realizarMovimiento(valorMovimiento, numeroCuenta);
            return new ResponseEntity<>(nuevoMovimiento, HttpStatus.CREATED);
        } catch (SaldoInsuficienteException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (DatosNoEncontradoException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }

    }   
}
