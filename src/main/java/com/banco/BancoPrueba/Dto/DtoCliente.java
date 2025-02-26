/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banco.BancoPrueba.Dto;

/**
 *
 * @author oportero
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

@Data

@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DtoCliente {

    private String clave;
    private String direccion;
    private int edad;
    private String estado;
    private Character genero;
    private String identificacion;
    private String nombre;
    private String telefono;
    
    public DtoCliente() {
    }

    public DtoCliente(String clave, String direccion, int edad, String estado, Character genero, String identificacion, String nombre, String telefono) {
        this.clave = clave;
        this.direccion = direccion;
        this.edad = edad;
        this.estado = estado;
        this.genero = genero;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.telefono = telefono;
    }

}

