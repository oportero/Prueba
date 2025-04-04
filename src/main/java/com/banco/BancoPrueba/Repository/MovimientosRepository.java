/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.banco.BancoPrueba.Repository;

import com.banco.BancoPrueba.Entidades.Movimientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovimientosRepository extends JpaRepository<Movimientos, Long> {

    @Query(value = "Select top 1 saldo from [PruebaBanco].[banco].Movimientos where cuentaId = :cuentaId order by fechaMovimiento desc", nativeQuery = true)
    Double obtenerSaldo(@Param("cuentaId") Long cuentaId);

    @Query(value = "Select top 1 * from [PruebaBanco].[banco].Movimientos where cuentaId = :numeroCuenta order by fechaMovimiento desc", nativeQuery = true)
    Movimientos obtenerCuentaAfectar(@Param("numeroCuenta") Long numeroCuenta);

    @Query(value = "Select sum(valor) as valorTope from [PruebaBanco].[banco].Movimientos where tipoMovimiento ='Retiro' and cuentaId = :cuentaId \n"
            + "and fechaMovimiento >=  dateadd(DAY, datediff(day, 0, getdate()),0)   and fechaMovimiento <=  getdate() ", nativeQuery = true)
    Double obtenerValorTope(@Param("cuentaId") Long cuentaId);

}
