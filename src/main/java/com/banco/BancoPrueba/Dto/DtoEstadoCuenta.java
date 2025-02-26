/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banco.BancoPrueba.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

@Data

@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DtoEstadoCuenta {

    private String fecha;
    private String nombre;
    private String numeroCuenta;
    private String tipoCuenta;
    private BigDecimal saldo;
    private String estado;
    private String tipoMovimiento;
    private BigDecimal valor;

    public DtoEstadoCuenta() {
    }

    public DtoEstadoCuenta(String fecha, String nombre, String numeroCuenta, String tipoCuenta, BigDecimal saldo, String estado, String tipoMovimiento, BigDecimal valor) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.estado = estado;
        this.tipoMovimiento = tipoMovimiento;
        this.valor = valor;
    }

}
